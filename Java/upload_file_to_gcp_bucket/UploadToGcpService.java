package com.example.folder_sans_rapport.exportToGcp;

import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.auth.oauth2.*;
import com.google.cloud.storage.*;
import com.google.common.collect.*;
import com.google.common.io.*;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class UploadToGcpService {

    private final ObjectMapper objectMapper;
    
    // get the value from your application.properties file for example
    // the value should be a JSON like that => { "type": "service_account", "project_id": "project_on_gcp", "private_key_id": "", "private_key": "", "client_email": "", "client_id": "", "auth_uri": "", "token_uri": "", "auth_provider_x509_cert_url": "", "client_x509_cert_url": "" }
    @Value("${gcs.bucket.credentials}")
    private String gcsCredentials;

    @Value("${gcs.bucket.name}")
    private String gcsBucketName;

    @Transactional
    public void uploadFileToGoogleCloudBucket(MultipartFile file) {
        GcsObjectDto gcsObjectDto = objectMapper.readValue(gcsCredentials, GcsObjectDto.class);
        GoogleCredentials credentials = GoogleCredentials.fromStream(CharSource.wrap(gcsCredentials).asByteSource(StandardCharsets.UTF_8).openStream()).createScoped(Lists.newArrayList("https://www.googleapis.com/auth/devstorage.read_write"));
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).setProjectId(gcsObjectDto.getProjectId()).build().getService();

        BlobId blobId = BlobId.of(gcsBucketName, "path/to/define/name_of_file.csv");
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();

        // send to GCP
        storage.createFrom(blobInfo, file.getInputStream());
    }
    
}

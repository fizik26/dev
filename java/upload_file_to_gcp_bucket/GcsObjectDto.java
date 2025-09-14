import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GcsObjectDto {
    
    @JsonProperty("type")
    private String type;

    @JsonProperty("project_id")
    private String projectId;

    @JsonProperty("private_key_id")
    private String privateKeyId;

    @JsonProperty("private_key")
    private String privateKey;

    @JsonProperty("client_email")
    private String clientEmail;

    @JsonProperty("client_id")
    private String clientId;

    @JsonProperty("auth_uri")
    private String authUri;

    @JsonProperty("token_uri")
    private String tokenUri;

    @JsonProperty("auth_provider_x509_cert_url")
    private String authProvider;

    @JsonProperty("client_x509_cert_url")
    private String clientCert;
}

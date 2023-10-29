package com.example.folder_sans_rapport.importFileOpenCsv;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CsvImportService {

    @Transactional
    public void importFile(MultipartFile file, char separator) {
        AtomicInteger rowNum = new AtomicInteger(1); // the first line is the header of the CSV
        List<CsvDto> dtoList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new ByteArrayInputStream(file.getInputStream().readAllBytes())))) {

            // create csv bean reader - the profile can be determine before or you can not
            // use a profile if you don't have specific headers
            CsvToBean<CsvDto> csvToBean = new CsvToBeanBuilder<CsvDto>(reader)
                    .withSeparator(separator)
                    .withType(CsvDto.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withIgnoreEmptyLine(true)
                    .withProfile(CsvProfiles.profile1)
                    .build();

            dtoList = csvToBean.parse();

            // work on the DTO for validation and to transform it to an Entity to save it
            // into a DataBase for example

        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}

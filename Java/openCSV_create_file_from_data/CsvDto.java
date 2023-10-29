package com.example.folder_sans_rapport.createCsvViaData;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvIgnore;
import com.opencsv.bean.CsvBindByNames;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CsvDto {
    @CsvIgnore(profiles = { CsvProfiles.profile1 })
    @CsvBindByNames({
            @CsvBindByName(column = "code_version", profiles = { CsvProfiles.profile2,
                    CsvProfiles.profile3 }, required = true),
            @CsvBindByName(column = "code", profiles = { CsvProfiles.profile4 }, required = true),
            @CsvBindByName(column = "id", profiles = { CsvProfiles.profile5 }, required = true)
    })
    private String code;

    @CsvBindByName(column = "name")
    private String name;

    @CsvIgnore(profiles = { CsvProfiles.profile3, CsvProfiles.profile2 })
    @CsvBindByName(column = "email")
    private String email;
}

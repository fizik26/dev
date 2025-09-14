import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.springframework.stereotype.Service;

import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.*;

import org.apache.commons.io.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class CreateCsvFileService {

    private final DataRepository dataRepository;

    public byte[] createCsvFileFromData() {
        List<CsvToCreateDto> listObjects = dataRepository.findAll();

        // Creating HeaderColumnNameMappingStrategy
        HeaderColumnNameMappingStrategy<CsvToCreateDto> mappingStrategy = new HeaderColumnNameMappingStrategy<>();
        mappingStrategy.setProfile(CsvProfiles.profile4);
        mappingStrategy.setType(CsvToCreateDto.class);

        // we can set an order ( for the columns ) with the ordered list of header name
        mappingStrategy.setColumnOrderOnWrite(new OrderedComparatorIgnoringCase(CsvToCreateDto.FIELDS_ORDER));

        File file = File.createTempFile("myCsvFile", ".csv");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        StatefulBeanToCsv<CsvToCreateDto> beanToCsv = new StatefulBeanToCsvBuilder<CsvToCreateDto>(writer).withMappingStrategy(mappingStrategy).withProfile(CsvProfiles.profile4).withQuotechar(ICSVWriter.NO_QUOTE_CHARACTER).withSeparator(';').build();
        beanToCsv.write(listObjects);
        writer.close();

        byte[] contentToReturn = FileUtils.readFileToByteArray(file);
        deleteTempFiles(file);
        return contentToReturn;
    }

    private static void deleteTempFiles(File... files) {
        for(File file : files) {
            FileUtils.deleteQuietly(file);
        }
    }
}

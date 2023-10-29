import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor

@RestController
@RequestMapping("/import")
@PreAuthorize("hasAnyAuthority('role1', 'role2')")
public class CsvImportController {

    private final CsvImportService csvImportService;
    private final SecurityService securityService;

    @PostMapping(path = "")
    @PreAuthorize("hasAnyAuthority('role1') and @securityService.hasAcces()")
    public void importCsvFile(@RequestParam(value = "file") MultipartFile file,
            @RequestParam(value = "csvDelimiter") char separator) {
        csvImportService.importFile(file, separator);
    }

}
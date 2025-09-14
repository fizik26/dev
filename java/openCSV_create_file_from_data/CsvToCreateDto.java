import com.opencsv.bean.CsvBindByName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CsvToCreateDto extends CsvDto {

    public static final String[] FIELDS_ORDER = { "code", "name", "email", "mission" };

    @CsvBindByName(column = "mission", required = true)
    private String mission;
}

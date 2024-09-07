package Java.json_to_bean;

import lombok.Data;

@Data
public class Voiture {

    @Id
    private String modele;

    private String code;
    
}

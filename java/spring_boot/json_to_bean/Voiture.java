package java.spring_boot.json_to_bean;

import lombok.Data;

@Data
public class Voiture {

    @Id
    private String modele;

    private String code;
    
}

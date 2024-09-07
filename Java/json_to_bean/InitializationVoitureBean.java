package Java.json_to_bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.core.util.Json;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class InitializationVoitureBean {

    @Value("${json.voitures}")
    private Resource voituresResource;

    @Getter
    @Valid
    private List<Voiture> voitures;

    InitializationVoitureBean() {
        voitures = new ArrayList<>();
    }

    /**
     * Initialisation des voitures à partir du fichier json voitures
     *
     * @throws IOException Exception d'entrée/sortie
     */
    @PostConstruct
    public final void init() throws IOException {
        ObjectMapper jsonMapper = Json.mapper();
        voitures = jsonMapper.readValue(voituresResource.getInputStream(), new TypeReference<List<Voiture>>() {
        });
    }
}

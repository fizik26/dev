package java.spring_boot.json_to_bean;

import org.apache.logging.log4j.spi.StandardLevel;
import org.springframework.stereotype.Repository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Repository
public class MemoryVoitureRepository implements VoitureRepository {

    @Valid
    private final List<Voiture> voitures;

    public MemoryVoitureRepository(final InitializationVoitureBean voitureBean) {
        this.voitures = voitureBean.getVoitures();
    }

    public List<Voiture> findAll() {
        return this.voitures;
    }

    public Optional<Voiture> findByCode(final String codeVoiture) {
        return voitures.stream().filter(voiture -> voiture.getCode().equals(codeVoiture)).findFirst();
    }
}

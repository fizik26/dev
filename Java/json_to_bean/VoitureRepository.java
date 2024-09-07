package Java.json_to_bean;

import java.util.List;
import java.util.Optional;

public interface VoitureRepository {

    /**
     * Récupère toutes les voitures
     *
     * @return {@link List} de {@link Voiture}
     */
    List<Voiture> findAll();

    /**
     * Récupère une Voiture par rapport à un code
     *
     * @param codeVoiture : code de la voiture permettant la recherche
     * @return {@link Optional<Voiture>}
     */
    Optional<Voiture> findByCode(String codeVoiture);

}

package java.mapstruct.mapstruct_helper;

import org.mapstruct.Mapper;

/**
 * Mapper de Reporting
 */
@Mapper(uses = UserMapperHelper.class)
public interface ReportingMapper {

    // le mapper va utiliser la méthode du Helper pour convertir l'objet TypesUser en code
    Reporting userToReporting(User user);
}

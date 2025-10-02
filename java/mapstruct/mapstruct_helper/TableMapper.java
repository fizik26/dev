package java.mapstruct.mapstruct_helper;

import org.mapstruct.Mapper;

/**
 * Mapper de Table (classement)
 */
@Mapper(uses = UserMapperHelper.class)
public interface TableMapper {

    // le mapper va utiliser la méthode du Helper pour convertir l'objet TypesUser en code
    Table userToTable(User user);
}

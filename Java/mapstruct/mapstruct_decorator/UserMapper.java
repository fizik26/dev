package Java.mapstruct.mapstruct_decorator;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MapStructConfig.class)
@DecoratedWith(UserMapperDecorator.class)
public interface UserMapper {

    /**
     * Permet de mapper les données d'un {@link User} dans un autre {@link User}
     *
     * @param user : {@link User} source
     * @param userTarget : {@link User} qui contiendra de nouvelles valeurs
     * @return {@link User}
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "objectifInitial", ignore = true)
    User updateUser(User user, @MappingTarget User userTarget);

}
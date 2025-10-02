package java.mapstruct.mapstruct_helper;

import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

/**
 * Helper de mapper pour les types d'utilisateurs
 */
@Component
@RequiredArgsConstructor
public class UserMapperHelper {

    // utilisation d'un service de l'application
    private final UserAppService userAppService;

    @Named("getTypeUser")
    public TypesUser getTypeUser(final String code) {
        return userAppService.getTypeByCode(code);
    }

}

package java.mapstruct.mapstruct_helper;

import org.springframework.stereotype.Service;

@Service
public class UserAppService {

    public TypesUser getTypeByCode(final String code) {
        return new TypesUser();
    }
}

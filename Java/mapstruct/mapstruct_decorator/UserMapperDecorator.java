package Java.mapstruct.mapstruct_decorator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.validation.Valid;

public abstract class UserMapperDecorator implements UserMapper {

    @Autowired
    @Qualifier("delegate")
    private UserMapper delegate;

    @Autowired
    private UserService userService;

    @Override
    public User updateUser(@Valid final User user, @Valid final User userTarget) {

        User userUpdated = delegate.updateParcours(user, userTarget);

        if (StringUtils.isNotBlank(userUpdated.getScore())) {
            userUpdated.setScore(userService.findScore());
        } else {
            userUpdated.setScore(null);
        }
        return userUpdated;
    }
}

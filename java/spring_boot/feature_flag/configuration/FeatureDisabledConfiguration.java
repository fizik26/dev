import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import service.MyService;
import service.internal.SecondImplementationMyService;

@Configuration
@ConditionalOnProperty(
    name = "feature.my-feature.enabled",
    havingValue = "false"
)
public class FeatureDisabledConfiguration {

    @Bean // an interface (in most use cases), service, repository ...
    public MyService dontDoThingsService {
        return new SecondImplementationMyService();
    }

}
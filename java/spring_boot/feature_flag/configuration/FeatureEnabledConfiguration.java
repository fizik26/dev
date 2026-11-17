import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import service.MyService;
import service.internal.FirstImplementationMyService;

@Configuration
@ConditionalOnProperty(
    name = "feature.my-feature.enabled",
    havingValue = "true"
)
public class FeatureEnabledConfiguration {

    @Bean // an interface (in most use cases), service, repository ...
    public MyService doThingsService {
        return new FirstImplementationMyService();
    }

}
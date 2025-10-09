package java.openapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.core.util.Yaml;
import io.swagger.v3.oas.models.OpenAPI;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;
import org.springdoc.core.customizers.SpringDocCustomizers;
import org.springdoc.core.properties.SpringDocConfigProperties;
import org.springdoc.core.providers.SpringDocProviders;
import org.springdoc.core.service.AbstractRequestService;
import org.springdoc.core.service.GenericResponseService;
import org.springdoc.core.service.OpenAPIService;
import org.springdoc.core.service.OperationService;
import org.springdoc.webmvc.api.OpenApiWebMvcResource;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Locale;
import java.util.Objects;

import static org.springdoc.core.utils.Constants.SPRINGDOC_ENABLED;


/**
 * Controller custom héritant de {@link OpenApiWebMvcResource} venant remplacer celui auto-configuré par SpringDoc.
 */
@RestController
@ConditionalOnProperty(name = SPRINGDOC_ENABLED, matchIfMissing = true)
@Slf4j
public class OpenApiController extends OpenApiWebMvcResource {

    /**
     * Resource pointant vers le fichier contenant le contrat de l'API au format OpenApi / Yml
     * "Route" définie dans le application.yaml
     */
    @Nullable
    @Value("${myapp.openapi.contract.location}")
    private Resource openAPIResource;

    @Nullable
    private OpenAPI openAPI;

    /**
     * Instantiates a new Open api web mvc resource.
     *
     * @param openAPIBuilderObjectFactory the open api builder object factory
     * @param requestBuilder              the request builder
     * @param responseBuilder             the response builder
     * @param operationParser             the operation parser
     * @param springDocConfigProperties   the spring doc config properties
     * @param springDocProviders          the spring doc providers
     * @param springDocCustomizers        the spring doc customizers
     */
    public OpenApiController(
            final ObjectFactory<OpenAPIService> openAPIBuilderObjectFactory,
            final AbstractRequestService requestBuilder,
            final GenericResponseService responseBuilder,
            final OperationService operationParser,
            final SpringDocConfigProperties springDocConfigProperties,
            final SpringDocProviders springDocProviders,
            final SpringDocCustomizers springDocCustomizers) {
        super(openAPIBuilderObjectFactory, requestBuilder, responseBuilder, operationParser,
                springDocConfigProperties, springDocProviders, springDocCustomizers);
    }

    /**
     * Parsing du fichier yaml contenu dans {@code openAPIResource} pour construire l'objet {@code openAPI}.
     */
    @PostConstruct
    public void initOpenAPI() throws IOException {
        if (Objects.isNull(openAPIResource)) {
        ObjectMapper yamlMapper = Yaml.mapper();
        openAPI = yamlMapper.readValue(openAPIResource.getInputStream(), OpenAPI.class);
    }

    @Override
    protected OpenAPI getOpenApi(final String serverBaseUrl, final Locale locale) {
        return super.getOpenApi(serverBaseUrl, locale);
    }
}


package Java.mapstruct.mapstruct_decorator;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

/**
 * Fichier permettant la configuration de base de MapStruct qui est utilisé sur tous les Mapper MapStruct
 */
@MapperConfig(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        unmappedSourcePolicy = ReportingPolicy.WARN,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public class MapStructConfig {
}
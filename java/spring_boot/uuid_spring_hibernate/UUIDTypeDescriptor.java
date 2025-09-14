package java.spring_boot.uuid_spring_hibernate;

import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.AbstractTypeDescriptor;
import org.hibernate.type.descriptor.java.ImmutableMutabilityPlan;

import java.util.UUID;

/**
 * Descriptor du {@link UUID}
 */
public class UUIDTypeDescriptor extends AbstractTypeDescriptor<UUID> {

    private static final long serialVersionUID = 7019675228994915034L;

    public static final UUIDTypeDescriptor INSTANCE = new UUIDTypeDescriptor();

    /**
     * Constructeur permettant d'initialiser un Descriptor pour le type donné
     */
    public UUIDTypeDescriptor() {
        super(UUID.class, ImmutableMutabilityPlan.INSTANCE);
    }

    @Override
    public String toString(final UUID uuid) {
        return uuid.toString();
    }

    @Override
    public UUID fromString(final String s) {
        return UUID.fromString(s);
    }

    @Override
    public <T> T unwrap(final UUID uuid, final Class<T> type, final WrapperOptions wrapperOptions) {
        if (uuid == null) {
            return null;
        }

        if (String.class.isAssignableFrom(type)) {
            return (T) uuid.toString();
        }

        throw unknownUnwrap(type);
    }

    @Override
    public <T> UUID wrap(final T value, final WrapperOptions wrapperOptions) {
        if (value == null) {
            return null;
        }

        if (value instanceof String) {
            return UUID.fromString((String) value);
        }

        throw unknownWrap(value.getClass());
    }
}
package Java.uuid_spring_hibernate;

import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;

import java.util.UUID;

/**
 * CLasse permettant de définir le type UUID
 */
public class UUIDType extends AbstractSingleColumnStandardBasicType<UUID> {

    private static final long serialVersionUID = 7019675228998915034L;

    public static final UUIDType INSTANCE = new UUIDType();
    public static final String NAME = "UUIDType";

    /**
     * Constructeur permettant de définir le type SQL et le type Java du nouveau Type créé
     */
    public UUIDType() {
        super(VarcharTypeDescriptor.INSTANCE, UUIDTypeDescriptor.INSTANCE);
    }

    @Override
    public String getName() {
        return NAME;
    }
}
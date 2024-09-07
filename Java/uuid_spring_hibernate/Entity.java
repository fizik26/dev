package Java.uuid_spring_hibernate;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;


@Getter
@Setter
@RequiredArgsConstructor
@TypeDef(name = UUIDType.NAME,
        typeClass = UUIDType.class,
        defaultForType = UUID.class)
@Entity
@Table(name = "entity")
public class Entity 

    private static final long serialVersionUID = 6889986130806119768L;

    @Id
    @Column(name = "entity_id")
    private UUID id;

    @Column(name = "name")
    private String name;
}
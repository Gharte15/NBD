package Model;

import jakarta.persistence.Embedded;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotNull;
import org.junit.platform.engine.UniqueId;

import java.io.Serializable;

@MappedSuperclass
public class AbstractEntity implements Serializable {
    @Embedded
    @NotNull
    private UniqueId entityId;

    @Version
    private long version;
}

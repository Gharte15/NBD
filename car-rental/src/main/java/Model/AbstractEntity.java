package Model;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import java.io.Serializable;

@MappedSuperclass
public class AbstractEntity implements Serializable {
    @Version
    private long version;
}

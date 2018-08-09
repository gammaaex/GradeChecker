package gammaaex.domain.model;

import java.io.Serializable;
import java.util.Objects;

public abstract class AbstractEntity<Type extends AbstractEntity<Type>> implements Serializable {

    private final Integer identifier;

    public AbstractEntity(Integer identifier) {
        if (identifier == null) throw new RuntimeException("identifierにNullは許されません。");

        this.identifier = identifier;
    }

    /**
     * @return get identifier.
     */
    public Integer getIdentifier() {
        return identifier;
    }

    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null || that instanceof AbstractEntity == false) {
            return false;
        }
        return getIdentifier().equals(((AbstractEntity) that).getIdentifier());
    }

    public int hashCode() {
        return Objects.hashCode(this.getIdentifier());
    }

    public Type clone() {
        try {
            return (Type) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error("clone not supported");
        }
    }
}

package gammaaex.domain.model;

import java.io.Serializable;

public abstract class AbstractValueObject implements Serializable {

    public abstract boolean equals(Object object);

    public abstract int hashCode();

}

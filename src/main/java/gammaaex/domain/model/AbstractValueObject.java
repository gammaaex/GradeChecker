package gammaaex.domain.model;

import java.io.Serializable;

/**
 * ValueObjectの抽象クラス
 */
public abstract class AbstractValueObject implements Serializable {


    /**
     * 全てのプロパティの等価性を用いて、このバリューオブジェクトの等価性を比較する。
     *
     * @param object 比較対象のオブジェクト
     * @return 等価の場合は{@code true}
     */
    public abstract boolean equals(Object object);

    /**
     * このエンティティのハッシュコードを返す。
     *
     * @return ハッシュコード
     */
    public abstract int hashCode();

}

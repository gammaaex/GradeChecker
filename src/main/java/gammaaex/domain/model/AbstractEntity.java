package gammaaex.domain.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Entity、AggregateRootの抽象クラス
 *
 * @param <Type> 実装クラスの型
 */
public abstract class AbstractEntity<Type extends AbstractEntity<Type>> implements Serializable {

    /**
     * Entityの識別子
     */
    private final Integer identifier;

    /**
     * コンストラクタ
     *
     * @param identifier 識別子
     */
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

    /**
     * エンティティの{@link #getIdentifier() 識別子}を用いて、このエンティティの同一性を比較する。
     *
     * @param that 比較対象のオブジェクト
     * @return 同じ識別子を持つ場合は{@code true}
     */
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null || that instanceof AbstractEntity == false) {
            return false;
        }
        return getIdentifier().equals(((AbstractEntity) that).getIdentifier());
    }

    /**
     * このエンティティのハッシュコードを返す。
     * <p>
     * Effective Java 第二版 項目9に従い、equalsメソッドを
     * オーバーライドするときは必ずhashCodeメソッドもオーバーライドする。
     *
     * @return ハッシュコード
     */
    public int hashCode() {
        return Objects.hash(this.getIdentifier());
    }

    /**
     * このエンティティの複製を生成する。
     *
     * @return このエンティティの複製。
     */
    public Type clone() {
        try {
            return (Type) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error("clone not supported");
        }
    }
}

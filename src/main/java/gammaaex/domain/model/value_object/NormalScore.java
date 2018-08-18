package gammaaex.domain.model.value_object;

import gammaaex.domain.model.AbstractValueObject;

import java.util.Objects;

/**
 * 通常の成績を表現するクラス
 */
public final class NormalScore extends AbstractValueObject {

    /**
     * テストの成績
     */
    private final Integer score;

    /**
     * コンストラクタ
     *
     * @param score テストの成績
     */
    public NormalScore(Integer score) {
        this.score = score;
    }

    /**
     * scoreがnullかどうか判断し、結果によって0か1を返す。
     *
     * @return Integer 0か1
     */
    public Integer getZeroOrOne() {
        return this.score == null ? 0 : 1;
    }

    /**
     * scoreがnullかどうか判断し、結果によって0か自身の値を返す。
     *
     * @return 0かscoreの値
     */
    public Integer getZeroOrThis() {
        return this.score == null ? 0 : this.score;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;

        if (object == null) return false;

        if (this.getClass() != object.getClass()) return false;

        NormalScore that = (NormalScore) object;

        if (!this.score.equals(that.score)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.score);
    }
}

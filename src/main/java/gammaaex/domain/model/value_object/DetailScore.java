package gammaaex.domain.model.value_object;

import gammaaex.domain.model.AbstractValueObject;

import java.util.Objects;

/**
 * 少数を含むような詳細な成績を表現するクラス
 */
public final class DetailScore extends AbstractValueObject {

    /**
     * テストの成績
     */
    private final Double score;

    /**
     * コンストラクタ
     *
     * @param score テストの成績
     */
    public DetailScore(Double score) {
        this.score = score;
    }

    /**
     * @return get score.
     */
    public Double getScore() {
        return score;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;

        if (object == null) return false;

        if (this.getClass() != object.getClass()) return false;

        DetailScore that = (DetailScore) object;

        if (!this.getScore().equals(that.getScore())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getScore());
    }
}

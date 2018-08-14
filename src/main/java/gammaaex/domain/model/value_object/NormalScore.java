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
     * @return get score.
     */
    public Integer getScore() {
        return score;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;

        if (object == null) return false;

        if (this.getClass() != object.getClass()) return false;

        NormalScore that = (NormalScore) object;

        if (!this.getScore().equals(that.getScore())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getScore());
    }
}

package gammaaex.domain.model.value_object;

import gammaaex.domain.model.AbstractValueObject;

import java.util.Objects;

public class ExamScore extends AbstractValueObject {

    /**
     * テスト結果
     */
    private final Double score;

    /**
     * コンストラクタ
     *
     * @param score テスト結果
     */
    public ExamScore(Double score) {
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

        ExamScore that = (ExamScore) object;

        if (!this.getScore().equals(that.getScore())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(score);
    }
}
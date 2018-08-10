package gammaaex.domain.model.value_object;

import gammaaex.domain.model.AbstractValueObject;

import java.util.Objects;

public final class AssignmentsScore extends AbstractValueObject {

    /**
     * 課題の成績
     */
    private final Integer score;

    /**
     * コンストラクタ
     *
     * @param score 課題の成績
     */
    public AssignmentsScore(Integer score) {
        if (score.equals(null)) throw new RuntimeException("Nullは許可されません。");
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

        AssignmentsScore that = (AssignmentsScore) object;

        if (!this.getScore().equals(that.getScore())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getScore());
    }
}

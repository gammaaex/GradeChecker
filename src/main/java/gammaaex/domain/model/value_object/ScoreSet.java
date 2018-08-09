package gammaaex.domain.model.value_object;

import gammaaex.domain.model.AbstractValueObject;
import gammaaex.domain.model.entity.Assignments;
import gammaaex.domain.model.entity.Exam;
import gammaaex.domain.model.entity.MiniExam;

import java.util.Objects;

/**
 * 同一idのexam, assigments, miniexamのセット
 */
public final class ScoreSet extends AbstractValueObject {

    /**
     * テスト結果
     */
    private final Exam exam;

    /**
     * 課題
     */
    private final Assignments assignments;

    /**
     * 小テスト
     */
    private final MiniExam miniExam;

    /**
     * コンストラクタ
     *
     * @param exam        テスト結果
     * @param assignments 課題
     * @param miniExam    小テスト
     */
    public ScoreSet(Exam exam, Assignments assignments, MiniExam miniExam) {
        this.exam = exam;
        this.assignments = assignments;
        this.miniExam = miniExam;
    }

    /**
     * @return get exam.
     */
    public Exam getExam() {
        return exam;
    }

    /**
     * @return get assignments.
     */
    public Assignments getAssignments() {
        return assignments;
    }

    /**
     * @return get miniExam.
     */
    public MiniExam getMiniExam() {
        return miniExam;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;

        if (object == null) return false;

        if (this.getClass() != object.getClass()) return false;

        ScoreSet that = (ScoreSet) object;

        if (!this.getExam().equals(that.getExam())) return false;

        if (!this.getAssignments().equals(that.getAssignments())) return false;

        if (!this.getMiniExam().equals(that.getMiniExam())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(exam, assignments, miniExam);
    }
}

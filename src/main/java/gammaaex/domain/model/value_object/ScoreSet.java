package gammaaex.domain.model.value_object;

import gammaaex.domain.model.AbstractValueObject;
import gammaaex.domain.model.entity.Assignments;
import gammaaex.domain.model.entity.Exam;
import gammaaex.domain.model.entity.MiniExam;

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
}

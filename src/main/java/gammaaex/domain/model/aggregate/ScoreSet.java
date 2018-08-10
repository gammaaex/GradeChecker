package gammaaex.domain.model.aggregate;

import gammaaex.domain.model.AbstractEntity;
import gammaaex.domain.model.entity.Assignments;
import gammaaex.domain.model.entity.Exam;
import gammaaex.domain.model.entity.MiniExam;

/**
 * 同一idのexam, assigments, miniexamのセット
 */
public final class ScoreSet extends AbstractEntity<ScoreSet> {

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
        super(exam.getIdentifier());

        if (!exam.getIdentifier().equals(assignments.getIdentifier())) {
            throw new IllegalArgumentException();
        }
        if (!exam.getIdentifier().equals(miniExam.getIdentifier())) {
            throw new IllegalArgumentException();
        }

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

package gammaaex.domain.model.entity;

import gammaaex.domain.model.AbstractEntity;
import gammaaex.domain.model.value_object.AssignmentsScore;

/**
 * 課題を表現するイミュータブルなクラス
 */
public final class Assignments extends AbstractEntity<Assignments> {

    /**
     * 課題1の成績
     */
    private final AssignmentsScore score1;

    /**
     * 課題2の成績
     */
    private final AssignmentsScore score2;

    /**
     * 課題3の成績
     */
    private final AssignmentsScore score3;

    /**
     * 課題4の成績
     */
    private final AssignmentsScore score4;

    /**
     * 課題5の成績
     */
    private final AssignmentsScore score5;

    /**
     * 課題6の成績
     */
    private final AssignmentsScore score6;

    public Assignments(
            Integer id,
            AssignmentsScore score1,
            AssignmentsScore score2,
            AssignmentsScore score3,
            AssignmentsScore score4,
            AssignmentsScore score5,
            AssignmentsScore score6
    ) {
        super(id);
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
        this.score4 = score4;
        this.score5 = score5;
        this.score6 = score6;
    }

    /**
     * @return get score1.
     */
    public AssignmentsScore getScore1() {
        return score1;
    }

    /**
     * @return get score2.
     */
    public AssignmentsScore getScore2() {
        return score2;
    }

    /**
     * @return get score3.
     */
    public AssignmentsScore getScore3() {
        return score3;
    }

    /**
     * @return get score4.
     */
    public AssignmentsScore getScore4() {
        return score4;
    }

    /**
     * @return get score5.
     */
    public AssignmentsScore getScore5() {
        return score5;
    }

    /**
     * @return get score6.
     */
    public AssignmentsScore getScore6() {
        return score6;
    }
}

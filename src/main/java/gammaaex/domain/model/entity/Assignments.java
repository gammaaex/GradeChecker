package gammaaex.domain.model.entity;

/**
 * 課題を表現するイミュータブルなクラス
 */
public final class Assignments {

    /**
     * 識別子
     */
    private final Integer id;

    /**
     * 課題1の成績
     */
    private final Integer score1;

    /**
     * 課題2の成績
     */
    private final Integer score2;

    /**
     * 課題3の成績
     */
    private final Integer score3;

    /**
     * 課題4の成績
     */
    private final Integer score4;

    /**
     * 課題5の成績
     */
    private final Integer score5;

    /**
     * 課題6の成績
     */
    private final Integer score6;

    public Assignments(
            Integer id,
            Integer score1,
            Integer score2,
            Integer score3,
            Integer score4,
            Integer score5,
            Integer score6
    ) {
        this.id = id;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
        this.score4 = score4;
        this.score5 = score5;
        this.score6 = score6;
    }

    /**
     * @return get id.
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return get score1.
     */
    public Integer getScore1() {
        return score1;
    }

    /**
     * @return get score2.
     */
    public Integer getScore2() {
        return score2;
    }

    /**
     * @return get score3.
     */
    public Integer getScore3() {
        return score3;
    }

    /**
     * @return get score4.
     */
    public Integer getScore4() {
        return score4;
    }

    /**
     * @return get score5.
     */
    public Integer getScore5() {
        return score5;
    }

    /**
     * @return get score6.
     */
    public Integer getScore6() {
        return score6;
    }
}

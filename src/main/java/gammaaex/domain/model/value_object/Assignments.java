package gammaaex.domain.model.value_object;

/**
 * 課題を表現するイミュータブルなクラス
 */
public final class Assignments {

    /**
     * 識別子
     */
    public final Integer id;

    /**
     * 課題1の成績
     */
    public final Integer score1;

    /**
     * 課題2の成績
     */
    public final Integer score2;

    /**
     * 課題3の成績
     */
    public final Integer score3;

    /**
     * 課題4の成績
     */
    public final Integer score4;

    /**
     * 課題5の成績
     */
    public final Integer score5;

    /**
     * 課題6の成績
     */
    public final Integer score6;

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
}

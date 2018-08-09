package gammaaex.domain.model.entity;

import gammaaex.domain.model.AbstractEntity;

/**
 * 小テストを表現するイミュータブルなクラス
 */
public final class MiniExam extends AbstractEntity<MiniExam> {

    /**
     * 第1回小テストの点数
     */
    private final Integer score1;

    /**
     * 第2回小テストの点数
     */
    private final Integer score2;

    /**
     * 第3回小テストの点数
     */
    private final Integer score3;

    /**
     * 第4回小テストの点数
     */
    private final Integer score4;

    /**
     * 第5回小テストの点数
     */
    private final Integer score5;

    /**
     * 第6回小テストの点数
     */
    private final Integer score6;

    /**
     * 第7回小テストの点数
     */
    private final Integer score7;

    /**
     * 第8回小テストの点数
     */
    private final Integer score8;

    /**
     * 第9回小テストの点数
     */
    private final Integer score9;

    /**
     * 第10回小テストの点数
     */
    private final Integer score10;

    /**
     * 第11回小テストの点数
     */
    private final Integer score11;

    /**
     * 第12回小テストの点数
     */
    private final Integer score12;

    /**
     * 第13回小テストの点数
     */
    private final Integer score13;

    /**
     * 第14回小テストの点数
     */
    private final Integer score14;

    public MiniExam(
            Integer id,
            Integer score1,
            Integer score2,
            Integer score3,
            Integer score4,
            Integer score5,
            Integer score6,
            Integer score7,
            Integer score8,
            Integer score9,
            Integer score10,
            Integer score11,
            Integer score12,
            Integer score13,
            Integer score14
    ) {
        super(id);
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
        this.score4 = score4;
        this.score5 = score5;
        this.score6 = score6;
        this.score7 = score7;
        this.score8 = score8;
        this.score9 = score9;
        this.score10 = score10;
        this.score11 = score11;
        this.score12 = score12;
        this.score13 = score13;
        this.score14 = score14;
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

    /**
     * @return get score7.
     */
    public Integer getScore7() {
        return score7;
    }

    /**
     * @return get score8.
     */
    public Integer getScore8() {
        return score8;
    }

    /**
     * @return get score9.
     */
    public Integer getScore9() {
        return score9;
    }

    /**
     * @return get score10.
     */
    public Integer getScore10() {
        return score10;
    }

    /**
     * @return get score11.
     */
    public Integer getScore11() {
        return score11;
    }

    /**
     * @return get score12.
     */
    public Integer getScore12() {
        return score12;
    }

    /**
     * @return get score13.
     */
    public Integer getScore13() {
        return score13;
    }

    /**
     * @return get score14.
     */
    public Integer getScore14() {
        return score14;
    }
}

package gammaaex.domain.model.entity;

import gammaaex.domain.model.AbstractEntity;
import gammaaex.domain.model.value_object.MiniExamScore;

/**
 * 小テストを表現するイミュータブルなクラス
 */
public final class MiniExam extends AbstractEntity<MiniExam> {

    /**
     * 第1回小テストの点数
     */
    private final MiniExamScore score1;

    /**
     * 第2回小テストの点数
     */
    private final MiniExamScore score2;

    /**
     * 第3回小テストの点数
     */
    private final MiniExamScore score3;

    /**
     * 第4回小テストの点数
     */
    private final MiniExamScore score4;

    /**
     * 第5回小テストの点数
     */
    private final MiniExamScore score5;

    /**
     * 第6回小テストの点数
     */
    private final MiniExamScore score6;

    /**
     * 第7回小テストの点数
     */
    private final MiniExamScore score7;

    /**
     * 第8回小テストの点数
     */
    private final MiniExamScore score8;

    /**
     * 第9回小テストの点数
     */
    private final MiniExamScore score9;

    /**
     * 第10回小テストの点数
     */
    private final MiniExamScore score10;

    /**
     * 第11回小テストの点数
     */
    private final MiniExamScore score11;

    /**
     * 第12回小テストの点数
     */
    private final MiniExamScore score12;

    /**
     * 第13回小テストの点数
     */
    private final MiniExamScore score13;

    /**
     * 第14回小テストの点数
     */
    private final MiniExamScore score14;

    public MiniExam(
            Integer id,
            MiniExamScore score1,
            MiniExamScore score2,
            MiniExamScore score3,
            MiniExamScore score4,
            MiniExamScore score5,
            MiniExamScore score6,
            MiniExamScore score7,
            MiniExamScore score8,
            MiniExamScore score9,
            MiniExamScore score10,
            MiniExamScore score11,
            MiniExamScore score12,
            MiniExamScore score13,
            MiniExamScore score14
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
    public MiniExamScore getScore1() {
        return score1;
    }

    /**
     * @return get score2.
     */
    public MiniExamScore getScore2() {
        return score2;
    }

    /**
     * @return get score3.
     */
    public MiniExamScore getScore3() {
        return score3;
    }

    /**
     * @return get score4.
     */
    public MiniExamScore getScore4() {
        return score4;
    }

    /**
     * @return get score5.
     */
    public MiniExamScore getScore5() {
        return score5;
    }

    /**
     * @return get score6.
     */
    public MiniExamScore getScore6() {
        return score6;
    }

    /**
     * @return get score7.
     */
    public MiniExamScore getScore7() {
        return score7;
    }

    /**
     * @return get score8.
     */
    public MiniExamScore getScore8() {
        return score8;
    }

    /**
     * @return get score9.
     */
    public MiniExamScore getScore9() {
        return score9;
    }

    /**
     * @return get score10.
     */
    public MiniExamScore getScore10() {
        return score10;
    }

    /**
     * @return get score11.
     */
    public MiniExamScore getScore11() {
        return score11;
    }

    /**
     * @return get score12.
     */
    public MiniExamScore getScore12() {
        return score12;
    }

    /**
     * @return get score13.
     */
    public MiniExamScore getScore13() {
        return score13;
    }

    /**
     * @return get score14.
     */
    public MiniExamScore getScore14() {
        return score14;
    }
}

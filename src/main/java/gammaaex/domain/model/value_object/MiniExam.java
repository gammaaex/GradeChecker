package gammaaex.domain.model.value_object;

/**
 * 小テストを表現するイミュータブルなクラス
 */
public final class MiniExam {

    /**
     * 識別子
     */
    public final Integer id;

    /**
     * 第1回小テストの点数
     */
    public final Integer score1;

    /**
     * 第2回小テストの点数
     */
    public final Integer score2;

    /**
     * 第3回小テストの点数
     */
    public final Integer score3;

    /**
     * 第4回小テストの点数
     */
    public final Integer score4;

    /**
     * 第5回小テストの点数
     */
    public final Integer score5;

    /**
     * 第6回小テストの点数
     */
    public final Integer score6;

    /**
     * 第7回小テストの点数
     */
    public final Integer score7;

    /**
     * 第8回小テストの点数
     */
    public final Integer score8;

    /**
     * 第9回小テストの点数
     */
    public final Integer score9;

    /**
     * 第10回小テストの点数
     */
    public final Integer score10;

    /**
     * 第11回小テストの点数
     */
    public final Integer score11;

    /**
     * 第12回小テストの点数
     */
    public final Integer score12;

    /**
     * 第13回小テストの点数
     */
    public final Integer score13;

    /**
     * 第14回小テストの点数
     */
    public final Integer score14;

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
        this.id = id;
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
}

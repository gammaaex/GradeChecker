package gammaaex.domain.model.entity;

import gammaaex.domain.model.AbstractEntity;
import gammaaex.domain.model.value_object.NormalScore;

/**
 * 小テストを表現するイミュータブルなクラス
 */
public final class MiniExam extends AbstractEntity<MiniExam> {

    /**
     * 第1回小テストの点数
     */
    private final NormalScore score1;

    /**
     * 第2回小テストの点数
     */
    private final NormalScore score2;

    /**
     * 第3回小テストの点数
     */
    private final NormalScore score3;

    /**
     * 第4回小テストの点数
     */
    private final NormalScore score4;

    /**
     * 第5回小テストの点数
     */
    private final NormalScore score5;

    /**
     * 第6回小テストの点数
     */
    private final NormalScore score6;

    /**
     * 第7回小テストの点数
     */
    private final NormalScore score7;

    /**
     * 第8回小テストの点数
     */
    private final NormalScore score8;

    /**
     * 第9回小テストの点数
     */
    private final NormalScore score9;

    /**
     * 第10回小テストの点数
     */
    private final NormalScore score10;

    /**
     * 第11回小テストの点数
     */
    private final NormalScore score11;

    /**
     * 第12回小テストの点数
     */
    private final NormalScore score12;

    /**
     * 第13回小テストの点数
     */
    private final NormalScore score13;

    /**
     * 第14回小テストの点数
     */
    private final NormalScore score14;

    /**
     * コンストラクタ
     *
     * @param id      識別子
     * @param score1  第1回小テストの点数
     * @param score2  第2回小テストの点数
     * @param score3  第3回小テストの点数
     * @param score4  第4回小テストの点数
     * @param score5  第5回小テストの点数
     * @param score6  第6回小テストの点数
     * @param score7  第7回小テストの点数
     * @param score8  第8回小テストの点数
     * @param score9  第9回小テストの点数
     * @param score10 第10回小テストの点数
     * @param score11 第11回小テストの点数
     * @param score12 第12回小テストの点数
     * @param score13 第13回小テストの点数
     * @param score14 第14回小テストの点数
     */
    public MiniExam(
            Integer id,
            NormalScore score1,
            NormalScore score2,
            NormalScore score3,
            NormalScore score4,
            NormalScore score5,
            NormalScore score6,
            NormalScore score7,
            NormalScore score8,
            NormalScore score9,
            NormalScore score10,
            NormalScore score11,
            NormalScore score12,
            NormalScore score13,
            NormalScore score14
    ) {
        super(id);

        if (score1 == null) throw new IllegalArgumentException();
        if (score2 == null) throw new IllegalArgumentException();
        if (score3 == null) throw new IllegalArgumentException();
        if (score4 == null) throw new IllegalArgumentException();
        if (score5 == null) throw new IllegalArgumentException();
        if (score6 == null) throw new IllegalArgumentException();
        if (score7 == null) throw new IllegalArgumentException();
        if (score8 == null) throw new IllegalArgumentException();
        if (score9 == null) throw new IllegalArgumentException();
        if (score10 == null) throw new IllegalArgumentException();
        if (score11 == null) throw new IllegalArgumentException();
        if (score12 == null) throw new IllegalArgumentException();
        if (score13 == null) throw new IllegalArgumentException();
        if (score14 == null) throw new IllegalArgumentException();

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
    public NormalScore getScore1() {
        return score1;
    }

    /**
     * @return get score2.
     */
    public NormalScore getScore2() {
        return score2;
    }

    /**
     * @return get score3.
     */
    public NormalScore getScore3() {
        return score3;
    }

    /**
     * @return get score4.
     */
    public NormalScore getScore4() {
        return score4;
    }

    /**
     * @return get score5.
     */
    public NormalScore getScore5() {
        return score5;
    }

    /**
     * @return get score6.
     */
    public NormalScore getScore6() {
        return score6;
    }

    /**
     * @return get score7.
     */
    public NormalScore getScore7() {
        return score7;
    }

    /**
     * @return get score8.
     */
    public NormalScore getScore8() {
        return score8;
    }

    /**
     * @return get score9.
     */
    public NormalScore getScore9() {
        return score9;
    }

    /**
     * @return get score10.
     */
    public NormalScore getScore10() {
        return score10;
    }

    /**
     * @return get score11.
     */
    public NormalScore getScore11() {
        return score11;
    }

    /**
     * @return get score12.
     */
    public NormalScore getScore12() {
        return score12;
    }

    /**
     * @return get score13.
     */
    public NormalScore getScore13() {
        return score13;
    }

    /**
     * @return get score14.
     */
    public NormalScore getScore14() {
        return score14;
    }


    /**
     * 小テストの受験率を計算する。
     *
     * @return 受験率
     */
    public Double calculateAdmissionRate() {
        Integer totalScore = this.calculateNumberOfAdmission();
        Integer numberOfMaxMiniExam = 14;
        Double rate = totalScore.doubleValue() / numberOfMaxMiniExam.doubleValue();

        if (rate < 0.0 && rate > 1.0) throw new RuntimeException("受験率の値が不正です。");

        return rate;
    }

    /**
     * 小テストの回数を計算する。
     *
     * @return 受験
     */
    public Integer calculateNumberOfAdmission() {
        Integer count = 0;

        count += this.getScore1().getZeroOrOne();
        count += this.getScore2().getZeroOrOne();
        count += this.getScore3().getZeroOrOne();
        count += this.getScore4().getZeroOrOne();
        count += this.getScore5().getZeroOrOne();
        count += this.getScore6().getZeroOrOne();
        count += this.getScore7().getZeroOrOne();
        count += this.getScore8().getZeroOrOne();
        count += this.getScore9().getZeroOrOne();
        count += this.getScore10().getZeroOrOne();
        count += this.getScore11().getZeroOrOne();
        count += this.getScore12().getZeroOrOne();
        count += this.getScore13().getZeroOrOne();
        count += this.getScore14().getZeroOrOne();

        return count;
    }
}

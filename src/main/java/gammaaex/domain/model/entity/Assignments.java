package gammaaex.domain.model.entity;

import gammaaex.domain.model.AbstractEntity;
import gammaaex.domain.model.value_object.NormalScore;
import gammaaex.domain.service.utility.ConvertingService;

/**
 * 課題を表現するイミュータブルなクラス
 */
public final class Assignments extends AbstractEntity<Assignments> {

    /**
     * 課題1の成績
     */
    private final NormalScore score1;

    /**
     * 課題2の成績
     */
    private final NormalScore score2;

    /**
     * 課題3の成績
     */
    private final NormalScore score3;

    /**
     * 課題4の成績
     */
    private final NormalScore score4;

    /**
     * 課題5の成績
     */
    private final NormalScore score5;

    /**
     * 課題6の成績
     */
    private final NormalScore score6;

    /**
     * コンストラクタ
     *
     * @param id     識別子
     * @param score1 課題1の成績
     * @param score2 課題2の成績
     * @param score3 課題3の成績
     * @param score4 課題4の成績
     * @param score5 課題5の成績
     * @param score6 課題6の成績
     */
    public Assignments(
            Integer id,
            NormalScore score1,
            NormalScore score2,
            NormalScore score3,
            NormalScore score4,
            NormalScore score5,
            NormalScore score6
    ) {
        super(id);

        if (score1 == null) throw new IllegalArgumentException();
        if (score2 == null) throw new IllegalArgumentException();
        if (score3 == null) throw new IllegalArgumentException();
        if (score4 == null) throw new IllegalArgumentException();
        if (score5 == null) throw new IllegalArgumentException();
        if (score6 == null) throw new IllegalArgumentException();

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
     * 課題の合計点を計算する。
     *
     * @param convertingService
     * @return 合計点
     */
    public Integer calculateTotalScore(ConvertingService convertingService) {
        Integer totalScore = 0;

        totalScore += convertingService.convertNullToInteger(getScore1().getScore());
        totalScore += convertingService.convertNullToInteger(getScore2().getScore());
        totalScore += convertingService.convertNullToInteger(getScore3().getScore());
        totalScore += convertingService.convertNullToInteger(getScore4().getScore());
        totalScore += convertingService.convertNullToInteger(getScore5().getScore());
        totalScore += convertingService.convertNullToInteger(getScore6().getScore());

        return totalScore;
    }
}

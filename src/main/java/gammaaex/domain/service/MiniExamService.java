package gammaaex.domain.service;

import gammaaex.domain.model.value_object.MiniExam;

/**
 * MiniExamのビジネスロジックを司るクラス
 */
public class MiniExamService {

    /**
     * コンストラクタ
     */
    public MiniExamService() {

    }

    /**
     * 小テストの受験率を計算する。
     *
     * @param miniExam 小テスト
     * @return 受験率
     */
    public Double calculateAdmissionRate(MiniExam miniExam) {
        Integer totalScore = this.calculateNumberOfAdmission(miniExam);
        Integer numberOfMaxMiniExam = 14;
        Double rate = totalScore.doubleValue() / numberOfMaxMiniExam.doubleValue();

        if (rate < 0.0 && rate > 1.0) throw new RuntimeException("受験率の値が不正です。");

        return rate;
    }

    /**
     * 小テストの回数を計算する。
     *
     * @param miniExam 小テスト
     * @return 受験
     */
    public Integer calculateNumberOfAdmission(MiniExam miniExam) {
        Integer count = 0;

        count += getCount(miniExam.score1);
        count += getCount(miniExam.score2);
        count += getCount(miniExam.score3);
        count += getCount(miniExam.score4);
        count += getCount(miniExam.score5);
        count += getCount(miniExam.score6);
        count += getCount(miniExam.score7);
        count += getCount(miniExam.score8);
        count += getCount(miniExam.score9);
        count += getCount(miniExam.score10);
        count += getCount(miniExam.score11);
        count += getCount(miniExam.score12);
        count += getCount(miniExam.score13);
        count += getCount(miniExam.score14);

        return count;
    }

    /**
     * Integerオブジェクトがnullかどうか判断し、結果によって0か1を返す。
     *
     * @param number 対象のIntegerオブジェクト
     * @return Integer 0か1
     */
    private Integer getCount(Integer number) {
        return number == null ? 1 : 0;
    }
}

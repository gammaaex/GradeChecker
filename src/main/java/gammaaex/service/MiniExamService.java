package gammaaex.service;

import gammaaex.value_object.MiniExam;

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
     * 小テストの受験率を計算する
     *
     * @param miniExam 小テスト
     * @return 受験率
     */
    public Double calculateAdmissionRate(MiniExam miniExam) {
        Integer totalScore = this.calculateNumberOfAdmission(miniExam);
        Integer numberOfMaxMiniExam = 14;

        return totalScore.doubleValue() / numberOfMaxMiniExam.doubleValue();
    }

    /**
     * 小テストの回数を計算する
     *
     * @param miniExam 小テスト
     * @return 受験
     */
    public Integer calculateNumberOfAdmission(MiniExam miniExam) {
        Integer count = 0;

        count += miniExam.score1 == null ? 1 : 0;
        count += miniExam.score2 == null ? 1 : 0;
        count += miniExam.score3 == null ? 1 : 0;
        count += miniExam.score4 == null ? 1 : 0;
        count += miniExam.score5 == null ? 1 : 0;
        count += miniExam.score6 == null ? 1 : 0;
        count += miniExam.score7 == null ? 1 : 0;
        count += miniExam.score8 == null ? 1 : 0;
        count += miniExam.score9 == null ? 1 : 0;
        count += miniExam.score10 == null ? 1 : 0;
        count += miniExam.score11 == null ? 1 : 0;
        count += miniExam.score12 == null ? 1 : 0;
        count += miniExam.score13 == null ? 1 : 0;
        count += miniExam.score14 == null ? 1 : 0;

        return count;
    }
}

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

    public Double calculateAdmissionRate(MiniExam miniExam) {
        Integer totalScore = this.calculateTotalScore(miniExam);
        Integer amountOfMiniExam = 14;

        return totalScore.doubleValue() / amountOfMiniExam.doubleValue();
    }

    public Integer calculateTotalScore(MiniExam miniExam) {
        Integer totalScore = 0;

        totalScore += miniExam.score1;
        totalScore += miniExam.score2;
        totalScore += miniExam.score3;
        totalScore += miniExam.score4;
        totalScore += miniExam.score5;
        totalScore += miniExam.score6;
        totalScore += miniExam.score7;
        totalScore += miniExam.score8;
        totalScore += miniExam.score9;
        totalScore += miniExam.score10;
        totalScore += miniExam.score11;
        totalScore += miniExam.score12;
        totalScore += miniExam.score13;
        totalScore += miniExam.score14;

        return totalScore;
    }
}

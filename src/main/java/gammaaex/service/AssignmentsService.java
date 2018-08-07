package gammaaex.service;

import gammaaex.value_object.Assignments;

/**
 * Assignmentsのビジネスロジックを司るクラス
 */
public class AssignmentsService {

    /**
     * コンストラクタ
     */
    public AssignmentsService() {

    }

    /**
     * 課題の合計点を計算する
     *
     * @param assignments 課題
     * @return 合計点
     */
    public Integer calculateTotalScore(Assignments assignments) {
        Integer totalScore = 0;

        totalScore += assignments.score1;
        totalScore += assignments.score2;
        totalScore += assignments.score3;
        totalScore += assignments.score4;
        totalScore += assignments.score5;
        totalScore += assignments.score6;

        return totalScore;
    }
}

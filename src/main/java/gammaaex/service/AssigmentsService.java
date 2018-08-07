package gammaaex.service;

import gammaaex.value_object.Assignments;

/**
 * Assignmentsのビジネスロジックを司るクラス
 */
public class AssigmentsService {

    /**
     * コンストラクタ
     */
    public AssigmentsService() {

    }

    public Integer calcrateTotalScore(Assignments assignments) {
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

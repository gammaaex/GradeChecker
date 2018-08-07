package gammaaex.domain.service;

import gammaaex.domain.model.value_object.Assignments;

/**
 * Assignmentsのビジネスロジックを司るクラス
 */
public class AssignmentsService {

    /**
     * Service変数
     */
    private final ConvertingService convertingService;

    /**
     * コンストラクタ
     */
    public AssignmentsService() {
        this.convertingService = new ConvertingService();
    }

    /**
     * 課題の合計点を計算する。
     *
     * @param assignments 課題
     * @return 合計点
     */
    public Integer calculateTotalScore(Assignments assignments) {
        Integer totalScore = 0;

        totalScore += this.convertingService.convertNullToInteger(assignments.score1);
        totalScore += this.convertingService.convertNullToInteger(assignments.score2);
        totalScore += this.convertingService.convertNullToInteger(assignments.score3);
        totalScore += this.convertingService.convertNullToInteger(assignments.score4);
        totalScore += this.convertingService.convertNullToInteger(assignments.score5);
        totalScore += this.convertingService.convertNullToInteger(assignments.score6);

        return totalScore;
    }
}

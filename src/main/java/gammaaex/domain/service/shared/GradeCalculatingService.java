package gammaaex.domain.service.shared;

import gammaaex.domain.model.entity.Assignments;
import gammaaex.domain.model.entity.Exam;
import gammaaex.domain.model.entity.MiniExam;
import gammaaex.domain.model.type.Grade;
import gammaaex.domain.service.AssignmentsService;
import gammaaex.domain.service.MiniExamService;
import gammaaex.domain.service.utility.ConvertingService;

/**
 * 成績を計算するクラス
 */
public class GradeCalculatingService {

    /**
     * Service変数
     */
    private final ConvertingService convertingService;
    private final AssignmentsService assignmentsService;
    private final MiniExamService miniExamService;

    /**
     * コンストラクタ
     *
     * @param convertingService
     * @param assignmentsService
     * @param miniExamService
     */
    public GradeCalculatingService(
            ConvertingService convertingService,
            AssignmentsService assignmentsService,
            MiniExamService miniExamService
    ) {
        this.convertingService = convertingService;
        this.assignmentsService = assignmentsService;
        this.miniExamService = miniExamService;
    }

    /**
     * 成績をGradeに変換する。
     *
     * @param point 成績
     * @return Grade
     */
    public Grade convertPointToGrade(Double point) {
        Grade grade = Grade.K;

        if (point == null) return grade;

        if (point >= 90) {
            grade = Grade.A;
        } else if (point >= 80) {
            grade = Grade.B;
        } else if (point >= 70) {
            grade = Grade.C;
        } else if (point >= 60) {
            grade = Grade.D;
        } else {
            grade = Grade.E;
        }

        return grade;
    }

    /**
     * 最終成績を計算する。
     *
     * @param exam        テスト
     * @param assignments 課題
     * @param miniExam    小テスト
     * @return 最終成績
     * @see <a href="https://ksuap.github.io/2018spring/lesson14/assignments/#2-a-4-成績の算出">仕様</a>
     */
    public Double calculateFinalScore(Exam exam, Assignments assignments, MiniExam miniExam) {
        if (exam.getScore() == null) return null;

        Double finalScore = 70 * this.convertingService.convertNullToDouble(exam.getScore().getScore()) / 100
                + 25 * this.assignmentsService.calculateTotalScore(assignments) / 60
                + 5 * this.miniExamService.calculateAdmissionRate(miniExam);

        return (Double) Math.ceil(finalScore);
    }
}

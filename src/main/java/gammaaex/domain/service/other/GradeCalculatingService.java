package gammaaex.domain.service.other;

import gammaaex.domain.model.entity.Assignments;
import gammaaex.domain.model.entity.Exam;
import gammaaex.domain.model.entity.MiniExam;
import gammaaex.domain.model.type.Grade;
import gammaaex.domain.service.AssignmentsService;
import gammaaex.domain.service.MiniExamService;
import gammaaex.infrastructure.repository.AssignmentsRepository;
import gammaaex.infrastructure.repository.MiniExamRepository;

/**
 * 成績を計算するクラス
 */
public class GradeCalculatingService {

    /**
     * Service変数
     */
    private final ConvertingService convertingService;

    /**
     * コンストラクタ
     */
    public GradeCalculatingService() {
        this.convertingService = new ConvertingService();
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

        Double finalScore = 70 * this.convertingService.convertNullToDouble(exam.getScore()) / 100
                + 25 * new AssignmentsService(new AssignmentsRepository()).calculateTotalScore(assignments) / 60
                + 5 * new MiniExamService(new MiniExamRepository()).calculateAdmissionRate(miniExam);

        return (Double) Math.ceil(finalScore);
    }
}

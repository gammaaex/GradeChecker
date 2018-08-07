package gammaaex.grade.calculator;

import gammaaex.grade.Grade;
import gammaaex.service.AssignmentsService;
import gammaaex.service.MiniExamService;
import gammaaex.value_object.Assignments;
import gammaaex.value_object.Exam;
import gammaaex.value_object.MiniExam;

/**
 * 成績を計算するクラス
 */
public class GradeCalculator {

    /**
     * コンストラクタ
     */
    public GradeCalculator() {

    }

    /**
     * 成績をGradeに変換する
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
     * 最終成績を計算する
     *
     * @param exam        テスト
     * @param assignments 課題
     * @param miniExam    小テスト
     * @return 最終成績
     */
    public Integer calculateFinalScore(Exam exam, Assignments assignments, MiniExam miniExam) {
        Double finalScore = 70 * exam.point / 100
                + 25 * new AssignmentsService().calculateTotalScore(assignments) / 60
                + 5 * new MiniExamService().calculateAdmissionRate(miniExam);

        return ((Double) Math.ceil(finalScore)).intValue();
    }
}

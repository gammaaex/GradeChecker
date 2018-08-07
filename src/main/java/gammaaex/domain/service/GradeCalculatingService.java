package gammaaex.domain.service;

import gammaaex.domain.model.type.Grade;
import gammaaex.domain.model.value_object.Assignments;
import gammaaex.domain.model.value_object.Exam;
import gammaaex.domain.model.value_object.MiniExam;

/**
 * 成績を計算するクラス
 */
public class GradeCalculatingService {

    /**
     * コンストラクタ
     */
    public GradeCalculatingService() {

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
     *
     * @see <a href="https://ksuap.github.io/2018spring/lesson14/assignments/#2-a-4-成績の算出">仕様</a>
     */
    public Integer calculateFinalScore(Exam exam, Assignments assignments, MiniExam miniExam) {
        Double finalScore = 70 * exam.point / 100
                + 25 * new AssignmentsService().calculateTotalScore(assignments) / 60
                + 5 * new MiniExamService().calculateAdmissionRate(miniExam);

        return ((Double) Math.ceil(finalScore)).intValue();
    }
}

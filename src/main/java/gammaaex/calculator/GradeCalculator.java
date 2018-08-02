package gammaaex.calculator;

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
    public Grade convertPointToGrade(Double point){
        Grade grade = Grade.K;

        if (point == null) return grade;

        if (point >= 90) {
            grade = Grade.A;
        } else if(point >= 80){
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
}

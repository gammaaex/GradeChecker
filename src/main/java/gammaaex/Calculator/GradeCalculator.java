package gammaaex.Calculator;

public class GradeCalculator {
    public GradeCalculator() {
    }

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

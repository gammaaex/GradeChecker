package gammaaex.printer;

import gammaaex.grade.calculator.GradeCalculator;
import gammaaex.entity.Exam;

import java.util.TreeMap;

/**
 * Examの標準出力を司るクラス
 */
public class ExamPrinter extends Printer {

    /**
     * コンストラクタ
     */
    public ExamPrinter() {

    }

    /**
     * exam用の出力を行う
     *
     * @param filledExamTreeMap 番号飛びがないTreeMap
     */
    public void print(TreeMap<Integer, Exam> filledExamTreeMap) {
        GradeCalculator gradeCalculator = new GradeCalculator();

        filledExamTreeMap.forEach((key, exam) -> {
            this.printCSVLine(
                    exam.id.toString(),
                    exam.point == null ? Double.toString(0.000) : exam.point.toString(),
                    " " + gradeCalculator.convertPointToGrade(exam.point).getText()
            );
        });
    }
}

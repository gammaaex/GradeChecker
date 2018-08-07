package gammaaex.presentation.print;

import gammaaex.domain.service.GradeCalculatingService;
import gammaaex.domain.model.value_object.Exam;

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
        GradeCalculatingService gradeCalculator = new GradeCalculatingService();

        filledExamTreeMap.forEach((key, exam) -> {
            this.printCSVLine(
                    exam.id.toString(),
                    exam.point == null ? Double.toString(0.000) : exam.point.toString(),
                    " " + gradeCalculator.convertPointToGrade(exam.point).getText()
            );
        });
    }
}

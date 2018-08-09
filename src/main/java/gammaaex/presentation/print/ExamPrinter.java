package gammaaex.presentation.print;

import gammaaex.domain.model.entity.Exam;
import gammaaex.domain.service.other.GradeCalculatingService;

import java.util.TreeMap;

/**
 * Examの標準出力を司るクラス
 */
public class ExamPrinter extends Printer {

    /**
     * コンストラクタ
     */
    public ExamPrinter() {
        super();
    }

    /**
     * exam用の出力を行う。
     *
     * @param filledExamTreeMap 番号飛びがないTreeMap
     */
    public void print(TreeMap<Integer, Exam> filledExamTreeMap) {
        GradeCalculatingService gradeCalculator = new GradeCalculatingService();

        filledExamTreeMap.forEach((key, exam) -> {
            this.printCSVLine(
                    exam.getIdentifier().toString(),
                    exam.getScore() == null ? Double.toString(0.000) : exam.getScore().toString(),
                    " " + gradeCalculator.convertPointToGrade(exam.getScore()).getText()
            );
        });
    }
}

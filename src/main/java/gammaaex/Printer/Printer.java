package gammaaex.Printer;

import gammaaex.Entity.Exam;
import gammaaex.Calculator.GradeCalculator;

import java.util.TreeMap;

/**
 * 標準出力を司るクラス
 */
public class Printer {

    /**R
     * コンストラクタ
     */
    public Printer() {

    }

    /**
     * exam用の出力を行う
     *
     * @param filledExamTreeMap 番号飛びがないTreeMap
     */
    public void printExam(TreeMap<Integer, Exam> filledExamTreeMap) {
        GradeCalculator gradeCalculator = new GradeCalculator();

        filledExamTreeMap.forEach((key, exam) -> {
            this.printCSVLine(
                    exam.id.toString(),
                    exam.point == null ? Double.toString(0.000) : exam.point.toString(),
                    " " + gradeCalculator.convertPointToGrade(exam.point).getText()
            );
        });
    }

    /**
     * CSV形式でPrintする
     *
     * @param arguments 文字列の可変長引数
     */
    public void printCSVLine(String... arguments) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String argument : arguments) {
            stringBuilder.append(argument).append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        System.out.println(stringBuilder);
    }
}

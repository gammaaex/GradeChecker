package gammaaex.presentation.print;

import gammaaex.domain.model.entity.Exam;
import gammaaex.domain.model.type.Grade;

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
     * exam用の出力を行う
     *
     * @param exam  テスト結果
     * @param grade グレード
     */
    public void print(Exam exam, Grade grade) {
        this.printCSVLine(
                exam.getIdentifier().toString(),
                exam.getExamScore() == null ? Double.toString(0.000) : exam.getExamScore().toString(),
                " " + grade.getText()
        );
    }
}

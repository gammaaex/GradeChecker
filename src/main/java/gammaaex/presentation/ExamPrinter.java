package gammaaex.presentation;

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
     * @see <a href="https://ksuap.github.io/2018spring/lesson14/assignments/#1-b-実行例">出力仕様</a>
     */
    public void print(Exam exam, Grade grade) {
        this.printCSVLine(
                exam.getIdentifier().toString(),
                exam.getDetailScore().getText(),
                " " + grade.getText()
        );
    }
}

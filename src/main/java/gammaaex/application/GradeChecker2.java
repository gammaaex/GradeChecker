package gammaaex.application;

import gammaaex.infrastructure.input.ArgumentAnalyzer;
import gammaaex.infrastructure.input.ExamAnalyzer;
import gammaaex.infrastructure.input.FileAnalyzer;
import gammaaex.presentation.print.ExamPrinter;

/**
 * ステップ2に相当するクラス
 *
 * @see <a href="https://ksuap.github.io/2018spring/lesson14/assignments/#%E3%82%B9%E3%83%86%E3%83%83%E3%83%972">課題ページを参照</a>
 */
public class GradeChecker2 {

    /**
     * 問題を解くメソッド
     *
     * @param arguments 実行時引数
     */
    public void run(String[] arguments) {
        new ArgumentAnalyzer().validateForMany(arguments);

        new ExamPrinter().print(
                new ExamAnalyzer().createExamMapFillId(
                        new FileAnalyzer().getResource(arguments[0])
                )
        );
    }
}

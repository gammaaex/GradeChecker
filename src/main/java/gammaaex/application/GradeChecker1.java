package gammaaex.application;

import gammaaex.infrastructure.input.ArgumentAnalyzer;
import gammaaex.infrastructure.input.ExamAnalyzer;
import gammaaex.infrastructure.input.FileAnalyzer;
import gammaaex.presentation.print.ExamPrinter;

/**
 * ステップ1に相当するクラス
 *
 * @see <a href="https://ksuap.github.io/2018spring/lesson14/assignments/#ステップ1">課題ページを参照</a>
 */
public class GradeChecker1 {

    /**
     * 問題を解くメソッド
     *
     * @param arguments 実行時引数
     */
    public void run(String[] arguments) {
        new ArgumentAnalyzer().validateForOne(arguments);

        new ExamPrinter().print(
                new ExamAnalyzer().createExamMapFillId(
                        new FileAnalyzer().getResource(arguments[0])
                )
        );
    }
}
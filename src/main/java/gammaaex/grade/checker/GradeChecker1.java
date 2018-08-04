package gammaaex.grade.checker;

import gammaaex.analyzer.ArgumentAnalyzer;
import gammaaex.analyzer.ExamAnalyzer;
import gammaaex.analyzer.FileAnalyzer;
import gammaaex.printer.ExamPrinter;

/**
 * ステップ1に相当するクラス
 *
 * @see <a href="https://ksuap.github.io/2018spring/lesson14/assignments/#%E3%82%B9%E3%83%86%E3%83%83%E3%83%971">課題ページを参照</a>
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
                new ExamAnalyzer().getExamMapFillId(
                        new FileAnalyzer().getResource(arguments[0])
                )
        );
    }
}
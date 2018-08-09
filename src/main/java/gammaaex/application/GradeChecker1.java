package gammaaex.application;

import gammaaex.domain.service.ExamService;
import gammaaex.domain.service.other.ArgumentAnalyzingService;
import gammaaex.infrastructure.repository.ExamRepository;
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
        new ArgumentAnalyzingService().validateForOne(arguments);

        new ExamPrinter().print(
                new ExamService(new ExamRepository()).createMapFillId(
                        arguments[0]
                )
        );
    }
}
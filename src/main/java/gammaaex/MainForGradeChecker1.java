package gammaaex;

import gammaaex.application.GradeChecker1;
import gammaaex.infrastructure.repository.ExamRepository;

/**
 * メインクラス
 */
public class MainForGradeChecker1 {

    /**
     * メインメソッド
     *
     * @param args 実行時引数
     */
    public static void main(String[] args) {
        new GradeChecker1(
                new ExamRepository(args[0])
        ).run(args);
    }
}

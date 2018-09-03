package gammaaex;

import gammaaex.application.GradeChecker4;
import gammaaex.infrastructure.repository.AssignmentsRepository;
import gammaaex.infrastructure.repository.ExamRepository;
import gammaaex.infrastructure.repository.MiniExamRepository;

/**
 * メインクラス
 */
public class MainForGradeChecker4 {

    /**
     * メインメソッド
     *
     * @param args 実行時引数
     */
    public static void main(String[] args) {
        new GradeChecker4(
                new ExamRepository(args[0]),
                new AssignmentsRepository(args[1]),
                new MiniExamRepository(args[2])
        ).run(args);
    }
}

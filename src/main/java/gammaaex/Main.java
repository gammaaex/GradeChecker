package gammaaex;

import gammaaex.application.GradeChecker3;
import gammaaex.infrastructure.repository.AssignmentsRepository;
import gammaaex.infrastructure.repository.ExamRepository;
import gammaaex.infrastructure.repository.MiniExamRepository;

/**
 * メインクラス
 */
public class Main {

    /**
     * メインメソッド
     *
     * @param args 実行時引数
     */
    public static void main(String[] args) {
//        new GradeChecker1(
//                new ExamRepository(args[0])
//        ).run(args);
//
//        new GradeChecker2(
//                new ExamRepository(args[0]),
//                new AssignmentsRepository(args[1]),
//                new MiniExamRepository(args[2])
//        ).run(args);

        new GradeChecker3(
                new ExamRepository(args[0]),
                new AssignmentsRepository(args[1]),
                new MiniExamRepository(args[2])
        ).run(args);
    }
}

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
//                new ExamRepository(),
//                new AssignmentsRepository(),
//                new MiniExamRepository()
//        ).run(args);

//        new GradeChecker2(
//                new ExamRepository(),
//                new AssignmentsRepository(),
//                new MiniExamRepository()
//        ).run(args);

        new GradeChecker3(
                new ExamRepository(),
                new AssignmentsRepository(),
                new MiniExamRepository()
        ).run(args);
    }
}

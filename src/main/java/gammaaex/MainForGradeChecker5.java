package gammaaex;

import gammaaex.application.GradeChecker5;
import gammaaex.infrastructure.repository.AssignmentsRepository;
import gammaaex.infrastructure.repository.ExamRepository;
import gammaaex.infrastructure.repository.MiniExamRepository;

import java.util.Map;

/**
 * メインクラス
 */
public class MainForGradeChecker5 {

    /**
     * メインメソッド
     *
     * @param args 実行時引数
     */
    public static void main(String[] args) {
        Map<Option, String> argMap = new Arguments(args).create();

        new GradeChecker5(
                new ExamRepository(argMap.get(Option.EXAM)),
                new AssignmentsRepository(argMap.get(Option.ASSIGNMENTS)),
                new MiniExamRepository(argMap.get(Option.MINIEXAM))
        ).run(args);
    }
}

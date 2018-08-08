package gammaaex.application;

import gammaaex.domain.model.value_object.Assignments;
import gammaaex.domain.model.value_object.Exam;
import gammaaex.domain.model.value_object.MiniExam;
import gammaaex.domain.model.value_object.ScoreSet;
import gammaaex.domain.service.ScoreSetService;
import gammaaex.infrastructure.input.ArgumentAnalyzer;
import gammaaex.infrastructure.input.AssignmentsAnalyzer;
import gammaaex.infrastructure.input.ExamAnalyzer;
import gammaaex.infrastructure.input.MiniExamAnalyzer;
import gammaaex.presentation.print.Printer;

import java.util.TreeMap;

/**
 * ステップ2に相当するクラス
 *
 * @see <a href="https://ksuap.github.io/2018spring/lesson14/assignments/#ステップ2">課題ページを参照</a>
 */
public class GradeChecker2 {

    /**
     * 問題を解くメソッド
     *
     * @param arguments 実行時引数
     */
    public void run(String[] arguments) {
        new ArgumentAnalyzer().validateForMany(arguments);

        ExamAnalyzer examAnalyzer = new ExamAnalyzer();
        AssignmentsAnalyzer assignmentsAnalyzer = new AssignmentsAnalyzer();
        MiniExamAnalyzer miniExamAnalyzer = new MiniExamAnalyzer();

        TreeMap<Integer, Exam> exam = examAnalyzer.createExamMapFillId(examAnalyzer.getResource(arguments[0]));
        TreeMap<Integer, Assignments> assignments = assignmentsAnalyzer.createAssignmentsMap(assignmentsAnalyzer.getResource(arguments[1]));
        TreeMap<Integer, MiniExam> miniExam = miniExamAnalyzer.createExamMapFillId(miniExamAnalyzer.getResource(arguments[2]));
        TreeMap<Integer, ScoreSet> scoreSetMap = new ScoreSetService().createScoreSetMap(exam, assignments, miniExam);

        scoreSetMap.forEach((index, scoreSet) -> {
            new Printer().printAll(scoreSet);
        });
    }
}

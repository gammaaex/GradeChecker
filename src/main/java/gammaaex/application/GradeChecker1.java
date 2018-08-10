package gammaaex.application;

import gammaaex.domain.model.entity.Exam;
import gammaaex.domain.service.ExamService;
import gammaaex.domain.service.other.ArgumentAnalyzingService;
import gammaaex.domain.service.other.GradeCalculatingService;
import gammaaex.infrastructure.repository.ExamRepository;
import gammaaex.presentation.print.ExamPrinter;

import java.util.TreeMap;

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

        TreeMap<Integer, Exam> examMap = new ExamService(new ExamRepository()).createMapFillId(arguments[0]);
        ExamPrinter examPrinter = new ExamPrinter();
        GradeCalculatingService gradeCalculatingService = new GradeCalculatingService();

        examMap.forEach((index, exam) -> {
            examPrinter.print(exam, gradeCalculatingService.convertPointToGrade(exam.getScore()));
        });
    }
}
package gammaaex.application;

import gammaaex.domain.model.entity.Exam;
import gammaaex.domain.repository.AbstractAssignmentsRepository;
import gammaaex.domain.repository.AbstractExamRepository;
import gammaaex.domain.repository.AbstractMiniExamRepository;
import gammaaex.domain.service.AssignmentsService;
import gammaaex.domain.service.ExamService;
import gammaaex.domain.service.MiniExamService;
import gammaaex.domain.service.shared.GradeCalculatingService;
import gammaaex.domain.service.utility.ArgumentAnalyzingService;
import gammaaex.domain.service.utility.ConvertingService;
import gammaaex.presentation.print.ExamPrinter;

import java.util.TreeMap;

/**
 * ステップ1に相当するクラス
 *
 * @see <a href="https://ksuap.github.io/2018spring/lesson14/assignments/#ステップ1">課題ページを参照</a>
 */
public class GradeChecker1 {

    private final AbstractExamRepository examRepository;
    private final AbstractAssignmentsRepository assignmentsRepository;
    private final AbstractMiniExamRepository miniExamRepository;

    public GradeChecker1(
            AbstractExamRepository examRepository,
            AbstractAssignmentsRepository assignmentsRepository,
            AbstractMiniExamRepository miniExamRepository
    ) {
        this.examRepository = examRepository;
        this.assignmentsRepository = assignmentsRepository;
        this.miniExamRepository = miniExamRepository;
    }

    /**
     * 問題を解くメソッド
     *
     * @param arguments 実行時引数
     */
    public void run(String[] arguments) {
        new ArgumentAnalyzingService().validateForOne(arguments);

        TreeMap<Integer, Exam> examMap = new ExamService(this.examRepository).createMapFillId(arguments[0]);
        ExamPrinter examPrinter = new ExamPrinter();
        GradeCalculatingService gradeCalculatingService = new GradeCalculatingService(
                new ConvertingService(),
                new AssignmentsService(this.assignmentsRepository),
                new MiniExamService(this.miniExamRepository)
        );

        examMap.forEach((index, exam) -> {
            examPrinter.print(exam, gradeCalculatingService.convertPointToGrade(exam.getScore().getScore()));
        });
    }
}
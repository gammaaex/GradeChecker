package gammaaex.application;

import gammaaex.domain.model.entity.Exam;
import gammaaex.domain.repository.AbstractAssignmentsRepository;
import gammaaex.domain.repository.AbstractExamRepository;
import gammaaex.domain.repository.AbstractMiniExamRepository;
import gammaaex.domain.service.AssignmentsService;
import gammaaex.domain.service.ExamService;
import gammaaex.domain.service.MiniExamService;
import gammaaex.domain.service.shared.GradeCalculatingService;
import gammaaex.domain.service.utility.ArgumentValidatorService;
import gammaaex.domain.service.utility.ConvertingService;
import gammaaex.presentation.print.ExamPrinter;
import gammaaex.presentation.print.Printer;

import java.util.TreeMap;

/**
 * ステップ1に相当するクラス
 *
 * @see <a href="https://ksuap.github.io/2018spring/lesson14/assignments/#ステップ1">課題ページを参照</a>
 */
public class GradeChecker1 {

    /**
     * ExamのRepository
     */
    private final AbstractExamRepository examRepository;

    /**
     * AssignmentsのRepository
     */
    private final AbstractAssignmentsRepository assignmentsRepository;

    /**
     * MiniExamのRepository
     */
    private final AbstractMiniExamRepository miniExamRepository;

    /**
     * コンストラクタ
     *
     * @param examRepository        ExamのRepository
     * @param assignmentsRepository AssignmentsのRepository
     * @param miniExamRepository    MiniExamのRepository
     */
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
        if (!new ArgumentValidatorService().validateForOne(arguments)) {
            new Printer().printErrorByArgumentNotFound("java GradeChecker1 <EXAM.CSV>");
            return;
        }

        TreeMap<Integer, Exam> examMap = new ExamService(this.examRepository).createMapFillId(arguments[0]);
        ExamPrinter examPrinter = new ExamPrinter();
        GradeCalculatingService gradeCalculatingService = new GradeCalculatingService(
                new ConvertingService(),
                new AssignmentsService(this.assignmentsRepository, new ConvertingService()),
                new MiniExamService(this.miniExamRepository)
        );

        examMap.forEach((index, exam) -> {
            examPrinter.print(exam, gradeCalculatingService.convertPointToGrade(exam.getExamScore().getScore()));
        });
    }
}
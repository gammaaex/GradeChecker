package gammaaex.application;

import gammaaex.domain.model.aggregate.ScoreSet;
import gammaaex.domain.model.entity.Assignments;
import gammaaex.domain.model.entity.CalculatedScore;
import gammaaex.domain.model.entity.Exam;
import gammaaex.domain.model.entity.MiniExam;
import gammaaex.domain.repository.AssignmentsRepositoryInterface;
import gammaaex.domain.repository.ExamRepositoryInterface;
import gammaaex.domain.repository.MiniExamRepositoryInterface;
import gammaaex.domain.service.shared.GradeCalculatingService;
import gammaaex.domain.service.utility.ArgumentValidatorService;
import gammaaex.domain.service.utility.ConvertingService;
import gammaaex.presentation.print.CalculatedScorePrinter;
import gammaaex.presentation.print.Printer;

import java.util.List;

/**
 * ステップ2に相当するクラス
 *
 * @see <a href="https://ksuap.github.io/2018spring/lesson14/assignments/#ステップ2">課題ページを参照</a>
 */
public class GradeChecker2 {

    /**
     * ExamのRepository
     */
    private final ExamRepositoryInterface examRepository;

    /**
     * AssignmentsのRepository
     */
    private final AssignmentsRepositoryInterface assignmentsRepository;

    /**
     * MiniExamのRepository
     */
    private final MiniExamRepositoryInterface miniExamRepository;

    /**
     * コンストラクタ
     *
     * @param examRepository        ExamのRepository
     * @param assignmentsRepository AssignmentsのRepository
     * @param miniExamRepository    MiniExamのRepository
     */
    public GradeChecker2(
            ExamRepositoryInterface examRepository,
            AssignmentsRepositoryInterface assignmentsRepository,
            MiniExamRepositoryInterface miniExamRepository
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
        if (!new ArgumentValidatorService().validateForMany(arguments)) {
            new Printer().printErrorByArgumentNotFound("java GradeChecker2 <EXAM.CSV> <ASSIGNMENTS.CSV> <MINIEXAM.CSV>");
            return;
        }

        ConvertingService convertingService = new ConvertingService();

        List<Exam> examList = this.examRepository.findAllByFillId();
        List<Assignments> assignmentsList = this.assignmentsRepository.findAll();
        List<MiniExam> miniExamList = this.miniExamRepository.findAllByFillId();

        List<ScoreSet> scoreSetList = convertingService.createScoreSetList(examList, assignmentsList, miniExamList);

        GradeCalculatingService gradeCalculatingService = new GradeCalculatingService(convertingService);
        List<CalculatedScore> calculatedScoreList =
                gradeCalculatingService.convertListFromScoreSetToCalculatedScore(scoreSetList);

        new CalculatedScorePrinter().printCalculatedScore(calculatedScoreList);
    }
}

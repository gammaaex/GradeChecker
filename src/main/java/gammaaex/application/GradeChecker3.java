package gammaaex.application;

import gammaaex.domain.model.aggregate.ScoreSet;
import gammaaex.domain.model.entity.Assignments;
import gammaaex.domain.model.entity.CalculatedScore;
import gammaaex.domain.model.entity.CalculatedScoreList;
import gammaaex.domain.model.entity.Exam;
import gammaaex.domain.model.entity.MiniExam;
import gammaaex.domain.model.type.Grade;
import gammaaex.domain.repository.AssignmentsRepositoryInterface;
import gammaaex.domain.repository.ExamRepositoryInterface;
import gammaaex.domain.repository.MiniExamRepositoryInterface;
import gammaaex.domain.service.ArgumentValidatorService;
import gammaaex.domain.service.ConvertingService;
import gammaaex.domain.service.GradeCalculatingService;
import gammaaex.presentation.print.CalculatedScorePrinter;
import gammaaex.presentation.print.Printer;

import java.util.List;

/**
 * ステップ3に相当するクラス
 *
 * @see <a href="https://ksuap.github.io/2018spring/lesson14/assignments/#ステップ2">課題ページを参照</a>
 */
public class GradeChecker3 {

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
    public GradeChecker3(
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
            new Printer().printErrorByArgumentNotFound("java GradeChecker3 <EXAM.CSV> <ASSIGNMENTS.CSV> <MINIEXAM.CSV>");
            return;
        }

        ConvertingService convertingService = new ConvertingService();

        List<Exam> examList = this.examRepository.findAllByFillId();
        List<Assignments> assignmentsList = this.assignmentsRepository.findAll();
        List<MiniExam> miniExamList = this.miniExamRepository.findAllByFillId();

        List<ScoreSet> scoreSetList = convertingService.createScoreSetList(examList, assignmentsList, miniExamList);

        GradeCalculatingService gradeCalculatingService = new GradeCalculatingService();
        List<CalculatedScore> convertedList = gradeCalculatingService.convert(scoreSetList);
        CalculatedScoreList calculatedScoreList = new CalculatedScoreList(convertedList);
        CalculatedScorePrinter calculatedScorePrinter = new CalculatedScorePrinter();

        calculatedScorePrinter.printCalculatedScore(convertedList);

        calculatedScorePrinter.printAverage(
                calculatedScoreList.calculateAverage(),
                new CalculatedScoreList(calculatedScoreList.extractByCreditGetter()).calculateAverage()
        );

        calculatedScorePrinter.printMaximize(
                calculatedScoreList.calculateMaximize(),
                new CalculatedScoreList(calculatedScoreList.extractByCreditGetter()).calculateMaximize()
        );

        calculatedScorePrinter.printMinimum(
                calculatedScoreList.calculateMinimum(),
                new CalculatedScoreList(calculatedScoreList.extractByCreditGetter()).calculateMinimum()
        );

        calculatedScorePrinter.printGradeStats(
                calculatedScoreList.countByGrade(Grade.A),
                calculatedScoreList.countByGrade(Grade.B),
                calculatedScoreList.countByGrade(Grade.C),
                calculatedScoreList.countByGrade(Grade.D),
                calculatedScoreList.countByGrade(Grade.E),
                calculatedScoreList.countByGrade(Grade.K)
        );
    }
}

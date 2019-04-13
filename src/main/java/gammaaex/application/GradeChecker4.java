package gammaaex.application;

import gammaaex.domain.model.entity.CalculatedScoreList;
import gammaaex.domain.model.type.Grade;
import gammaaex.domain.repository.AssignmentsRepositoryInterface;
import gammaaex.domain.repository.ExamRepositoryInterface;
import gammaaex.domain.repository.MiniExamRepositoryInterface;
import gammaaex.domain.service.ArgumentValidatorService;
import gammaaex.domain.service.ConvertingService;
import gammaaex.domain.service.GradeCalculatingService;
import gammaaex.presentation.CalculatedScorePrinter;
import gammaaex.presentation.Printer;

/**
 * ステップ4に相当するクラス
 *
 * @see <a href="https://ksuap.github.io/2018spring/lesson14/assignments/#ステップ2">課題ページを参照</a>
 */
public class GradeChecker4 {

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
    public GradeChecker4(
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
            new Printer().printErrorByArgumentNotFound("java GradeChecker4 <EXAM.CSV> <ASSIGNMENTS.CSV> <MINIEXAM.CSV>");
            return;
        }

        CalculatedScoreList calculatedScoreList = new CalculatedScoreList(
                new GradeCalculatingService().convertForAttendance(
                        new ConvertingService().createScoreSetList(
                                this.examRepository.findAllByFillId(),
                                this.assignmentsRepository.findAll(),
                                this.miniExamRepository.findAllByFillId()
                        )
                )
        );

        CalculatedScorePrinter calculatedScorePrinter = new CalculatedScorePrinter();

        calculatedScorePrinter.printCalculatedScore(calculatedScoreList);
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
        calculatedScorePrinter.printGradeStatsForAttendance(
                calculatedScoreList.countByGrade(Grade.A),
                calculatedScoreList.countByGrade(Grade.B),
                calculatedScoreList.countByGrade(Grade.C),
                calculatedScoreList.countByGrade(Grade.D),
                calculatedScoreList.countByGrade(Grade.E),
                calculatedScoreList.countByGrade(Grade.K),
                calculatedScoreList.countByGrade(Grade.L)
        );
    }
}

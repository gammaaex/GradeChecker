package gammaaex.application;

import gammaaex.domain.model.aggregate.ScoreSet;
import gammaaex.domain.model.entity.Assignments;
import gammaaex.domain.model.entity.Exam;
import gammaaex.domain.model.entity.MiniExam;
import gammaaex.domain.model.type.Grade;
import gammaaex.domain.model.value_object.CalculatedScore;
import gammaaex.domain.repository.AbstractAssignmentsRepository;
import gammaaex.domain.repository.AbstractExamRepository;
import gammaaex.domain.repository.AbstractMiniExamRepository;
import gammaaex.domain.service.AssignmentsService;
import gammaaex.domain.service.CalculatedScoreService;
import gammaaex.domain.service.ExamService;
import gammaaex.domain.service.MiniExamService;
import gammaaex.domain.service.ScoreSetService;
import gammaaex.domain.service.shared.GradeCalculatingService;
import gammaaex.domain.service.utility.ConvertingService;
import gammaaex.presentation.print.CalculatedScorePrinter;

import java.util.TreeMap;

/**
 * ステップ2に相当するクラス
 *
 * @see <a href="https://ksuap.github.io/2018spring/lesson14/assignments/#ステップ2">課題ページを参照</a>
 */
public class GradeChecker3 {

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
    public GradeChecker3(
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
        new GradeChecker2(
                this.examRepository,
                this.assignmentsRepository,
                this.miniExamRepository
        ).run(arguments);

        ConvertingService convertingService = new ConvertingService();

        ExamService examService = new ExamService(this.examRepository);
        AssignmentsService assignmentsService = new AssignmentsService(this.assignmentsRepository, convertingService);
        MiniExamService miniExamService = new MiniExamService(this.miniExamRepository);

        TreeMap<Integer, Exam> examMap = examService.createMapFillId(arguments[0]);
        TreeMap<Integer, Assignments> assignmentsMap = assignmentsService.createMap(arguments[1]);
        TreeMap<Integer, MiniExam> miniExamMap = miniExamService.createMapFillId(arguments[2]);

        TreeMap<Integer, ScoreSet> scoreSetMap = new ScoreSetService().createMap(examMap, assignmentsMap, miniExamMap);

        GradeCalculatingService gradeCalculatingService = new GradeCalculatingService(
                convertingService,
                assignmentsService,
                miniExamService
        );

        TreeMap<Integer, CalculatedScore> calculatedScoreMap =
                gradeCalculatingService.convertMapFromScoreSetToCalculatedScore(scoreSetMap);

        CalculatedScoreService calculatedScoreService = new CalculatedScoreService();
        CalculatedScorePrinter calculatedScorePrinter = new CalculatedScorePrinter();

        calculatedScorePrinter.printAverage(
                calculatedScoreService.calculateAverage(calculatedScoreMap),
                calculatedScoreService.calculateAverage(
                        calculatedScoreService.extractByCreditGetter(calculatedScoreMap)
                )
        );

        calculatedScorePrinter.printMaximize(
                calculatedScoreService.calculateMaximize(calculatedScoreMap),
                calculatedScoreService.calculateMaximize(
                        calculatedScoreService.extractByCreditGetter(calculatedScoreMap)
                )
        );

        calculatedScorePrinter.printMinimum(
                calculatedScoreService.calculateMinimum(calculatedScoreMap),
                calculatedScoreService.calculateMinimum(
                        calculatedScoreService.extractByCreditGetter(calculatedScoreMap)
                )
        );

        calculatedScorePrinter.printGradeStats(
                calculatedScoreService.countByGrade(calculatedScoreMap, Grade.A),
                calculatedScoreService.countByGrade(calculatedScoreMap, Grade.B),
                calculatedScoreService.countByGrade(calculatedScoreMap, Grade.C),
                calculatedScoreService.countByGrade(calculatedScoreMap, Grade.D),
                calculatedScoreService.countByGrade(calculatedScoreMap, Grade.E),
                calculatedScoreService.countByGrade(calculatedScoreMap, Grade.K)
        );
    }
}

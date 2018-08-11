package gammaaex.application;

import gammaaex.domain.model.aggregate.ScoreSet;
import gammaaex.domain.model.entity.Assignments;
import gammaaex.domain.model.entity.Exam;
import gammaaex.domain.model.entity.MiniExam;
import gammaaex.domain.model.value_object.CalculatedScore;
import gammaaex.domain.repository.AbstractAssignmentsRepository;
import gammaaex.domain.repository.AbstractExamRepository;
import gammaaex.domain.repository.AbstractMiniExamRepository;
import gammaaex.domain.service.AssignmentsService;
import gammaaex.domain.service.ExamService;
import gammaaex.domain.service.MiniExamService;
import gammaaex.domain.service.ScoreSetService;
import gammaaex.domain.service.shared.GradeCalculatingService;
import gammaaex.domain.service.utility.ArgumentValidatorService;
import gammaaex.domain.service.utility.ConvertingService;
import gammaaex.presentation.print.CalculatedScorePrinter;
import gammaaex.presentation.print.Printer;

import java.util.TreeMap;

/**
 * ステップ2に相当するクラス
 *
 * @see <a href="https://ksuap.github.io/2018spring/lesson14/assignments/#ステップ2">課題ページを参照</a>
 */
public class GradeChecker2 {

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
    public GradeChecker2(
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
        if (!new ArgumentValidatorService().validateForMany(arguments)) {
            new Printer().printErrorByArgumentNotFound("java GradeChecker2 <EXAM.CSV> <ASSIGNMENTS.CSV> <MINIEXAM.CSV>");
            return;
        }

        ConvertingService convertingService = new ConvertingService();

        ExamService examService = new ExamService(this.examRepository);
        AssignmentsService assignmentsService = new AssignmentsService(this.assignmentsRepository, convertingService);
        MiniExamService miniExamService = new MiniExamService(this.miniExamRepository);

        TreeMap<Integer, Exam> examMap = examService.createMapFillId(arguments[0]);
        TreeMap<Integer, Assignments> assignmentsMap = assignmentsService.createMap(arguments[1]);
        TreeMap<Integer, MiniExam> miniExamMap = miniExamService.createMapFillId(arguments[2]);

        TreeMap<Integer, ScoreSet> scoreSetMap = new ScoreSetService().createMap(examMap, assignmentsMap, miniExamMap);

        TreeMap<Integer, CalculatedScore> calculatedScoreMap = new TreeMap<>();

        scoreSetMap.forEach((index, scoreSet) -> {
            Exam exam = scoreSet.getExam();
            Assignments assignments = scoreSet.getAssignments();
            MiniExam miniExam = scoreSet.getMiniExam();
            GradeCalculatingService gradeCalculatingService = new GradeCalculatingService(
                    convertingService,
                    assignmentsService,
                    miniExamService
            );

            Double finalScore = gradeCalculatingService.calculateFinalScore(exam, assignments, miniExam);

            calculatedScoreMap.put(index, new CalculatedScore(
                    exam.getIdentifier(),
                    finalScore,
                    exam.getExamScore().getScore(),
                    assignmentsService.calculateTotalScore(assignments).doubleValue(),
                    miniExamService.calculateAdmissionRate(miniExam),
                    gradeCalculatingService.convertPointToGrade(finalScore)
            ));
        });

        new CalculatedScorePrinter().printCalculatedScore(calculatedScoreMap);
    }
}

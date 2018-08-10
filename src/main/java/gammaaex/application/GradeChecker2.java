package gammaaex.application;

import gammaaex.domain.model.entity.Assignments;
import gammaaex.domain.model.entity.Exam;
import gammaaex.domain.model.entity.MiniExam;
import gammaaex.domain.model.entity.ScoreSet;
import gammaaex.domain.service.AssignmentsService;
import gammaaex.domain.service.ExamService;
import gammaaex.domain.service.MiniExamService;
import gammaaex.domain.service.utility.ArgumentAnalyzingService;
import gammaaex.domain.service.shared.GradeCalculatingService;
import gammaaex.domain.service.ScoreSetService;
import gammaaex.infrastructure.repository.AssignmentsRepository;
import gammaaex.infrastructure.repository.ExamRepository;
import gammaaex.infrastructure.repository.MiniExamRepository;
import gammaaex.presentation.print.Printer;

import java.util.TreeMap;

/**
 * ステップ2に相当するクラス
 *
 * @see <a href="https://ksuap.github.io/2018spring/lesson14/assignments/#ステップ2">課題ページを参照</a>
 */
public class GradeChecker2 {

    private final ExamRepository examRepository;
    private final AssignmentsRepository assignmentsRepository;
    private final MiniExamRepository miniExamRepository;

    public GradeChecker2() {
        this.examRepository = new ExamRepository();
        this.assignmentsRepository = new AssignmentsRepository();
        this.miniExamRepository = new MiniExamRepository();
    }

    /**
     * 問題を解くメソッド
     *
     * @param arguments 実行時引数
     */
    public void run(String[] arguments) {
        new ArgumentAnalyzingService().validateForMany(arguments);

        ExamService examService = new ExamService(this.examRepository);
        AssignmentsService assignmentsService = new AssignmentsService(this.assignmentsRepository);
        MiniExamService miniExamService = new MiniExamService(this.miniExamRepository);

        TreeMap<Integer, Exam> examMap = examService.createMapFillId(arguments[0]);
        TreeMap<Integer, Assignments> assignmentsMap = assignmentsService.createMap(arguments[1]);
        TreeMap<Integer, MiniExam> miniExamMap = miniExamService.createMapFillId(arguments[2]);

        TreeMap<Integer, ScoreSet> scoreSetMap = new ScoreSetService().createMap(examMap, assignmentsMap, miniExamMap);

        scoreSetMap.forEach((index, scoreSet) -> {
            Exam exam = scoreSet.getExam();
            Assignments assignments = scoreSet.getAssignments();
            MiniExam miniExam = scoreSet.getMiniExam();
            GradeCalculatingService gradeCalculatingService = new GradeCalculatingService();

            Double finalScore = gradeCalculatingService.calculateFinalScore(exam, assignments, miniExam);

            new Printer().printAll(
                    exam,
                    finalScore,
                    assignmentsService.calculateTotalScore(assignments),
                    miniExamService.calculateAdmissionRate(miniExam),
                    gradeCalculatingService.convertPointToGrade(finalScore).getText()
            );
        });
    }
}

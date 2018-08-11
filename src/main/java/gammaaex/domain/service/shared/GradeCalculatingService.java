package gammaaex.domain.service.shared;

import gammaaex.domain.model.aggregate.ScoreSet;
import gammaaex.domain.model.entity.Assignments;
import gammaaex.domain.model.entity.Exam;
import gammaaex.domain.model.entity.MiniExam;
import gammaaex.domain.model.type.Grade;
import gammaaex.domain.model.value_object.CalculatedScore;
import gammaaex.domain.service.AssignmentsService;
import gammaaex.domain.service.MiniExamService;
import gammaaex.domain.service.utility.ConvertingService;

import java.util.TreeMap;

/**
 * 成績を計算するクラス
 */
public class GradeCalculatingService {

    /**
     * {@link ConvertingService ConvertingServiceを参照}
     */
    private final ConvertingService convertingService;

    /**
     * AssignmentsのService
     */
    private final AssignmentsService assignmentsService;

    /**
     * MiniExamのService
     */
    private final MiniExamService miniExamService;

    /**
     * コンストラクタ
     *
     * @param convertingService  ConvertingServiceのインスタンス
     * @param assignmentsService AssignmentsのService
     * @param miniExamService    MiniExamのService
     */
    public GradeCalculatingService(
            ConvertingService convertingService,
            AssignmentsService assignmentsService,
            MiniExamService miniExamService
    ) {
        this.convertingService = convertingService;
        this.assignmentsService = assignmentsService;
        this.miniExamService = miniExamService;
    }

    /**
     * 成績をGradeに変換する。
     * pointをnullに設定すると{@code Grade.K}が出力される。
     *
     * @param point 成績
     * @return Grade
     */
    public Grade convertPointToGrade(Double point) {
        Grade grade = Grade.K;

        if (point == null) return grade;

        if (point >= 90) {
            grade = Grade.A;
        } else if (point >= 80) {
            grade = Grade.B;
        } else if (point >= 70) {
            grade = Grade.C;
        } else if (point >= 60) {
            grade = Grade.D;
        } else {
            grade = Grade.E;
        }

        return grade;
    }

    /**
     * 最終成績を計算する。
     *
     * @param exam        テスト
     * @param assignments 課題
     * @param miniExam    小テスト
     * @return 最終成績
     * @see <a href="https://ksuap.github.io/2018spring/lesson14/assignments/#2-a-4-成績の算出">仕様</a>
     */
    public Double calculateFinalScore(Exam exam, Assignments assignments, MiniExam miniExam) {
        Double examScore = exam.getExamScore().getScore() == null
                ? 0
                : exam.getExamScore().getScore();

        Double finalScore = 70 * this.convertingService.convertNullToDouble(examScore) / 100
                + 25 * this.assignmentsService.calculateTotalScore(assignments) / 60
                + 5 * this.miniExamService.calculateAdmissionRate(miniExam);

        return (Double) Math.ceil(finalScore);
    }

    public TreeMap<Integer, CalculatedScore> convertMapFromScoreSetToCalculatedScore(TreeMap<Integer, ScoreSet> scoreSetMap) {
        TreeMap<Integer, CalculatedScore> calculatedScoreMap = new TreeMap<>();

        scoreSetMap.forEach((index, scoreSet) -> {
            Exam exam = scoreSet.getExam();
            Assignments assignments = scoreSet.getAssignments();
            MiniExam miniExam = scoreSet.getMiniExam();
//            GradeCalculatingService gradeCalculatingService = new GradeCalculatingService(
//                    convertingService,
//                    assignmentsService,
//                    miniExamService
//            );


            Double finalScore = this.calculateFinalScore(exam, assignments, miniExam);

            calculatedScoreMap.put(index, new CalculatedScore(
                    exam.getIdentifier(),
                    finalScore,
                    exam.getExamScore().getScore(),
                    assignmentsService.calculateTotalScore(assignments).doubleValue(),
                    miniExamService.calculateAdmissionRate(miniExam),
                    this.convertPointToGrade(
                            exam.getExamScore().getScore() == null ? null : finalScore
                    )
            ));
        });

        return calculatedScoreMap;
    }
}

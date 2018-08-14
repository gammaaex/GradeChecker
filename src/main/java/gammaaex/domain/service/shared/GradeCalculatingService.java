package gammaaex.domain.service.shared;

import gammaaex.domain.model.aggregate.ScoreSet;
import gammaaex.domain.model.entity.Assignments;
import gammaaex.domain.model.entity.CalculatedScore;
import gammaaex.domain.model.entity.Exam;
import gammaaex.domain.model.entity.MiniExam;
import gammaaex.domain.model.type.Grade;
import gammaaex.domain.model.value_object.DetailScore;
import gammaaex.domain.service.utility.ConvertingService;

import java.util.ArrayList;
import java.util.List;

/**
 * 成績を計算するクラス
 */
public class GradeCalculatingService {

    /**
     * {@link ConvertingService ConvertingServiceを参照}
     */
    private final ConvertingService convertingService;

    /**
     * コンストラクタ
     *
     * @param convertingService ConvertingServiceのインスタンス
     */
    public GradeCalculatingService(ConvertingService convertingService) {
        this.convertingService = convertingService;
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
        Double examScore = exam.getDetailScore().getScore() == null
                ? 0
                : exam.getDetailScore().getScore();
        Integer totalScore = assignments.calculateTotalScore(convertingService);
        Double admissionRate = miniExam.calculateAdmissionRate();

        Double finalScore = 70 * examScore / 100
                + 25 * totalScore.doubleValue() / 60
                + 5 * admissionRate;

        return Math.ceil(finalScore);
    }

    public List<CalculatedScore> convertListFromScoreSetToCalculatedScore(List<ScoreSet> scoreSetList) {
        List<CalculatedScore> calculatedScoreList = new ArrayList<>();

        scoreSetList.forEach(scoreSet -> {
            Exam exam = scoreSet.getExam();
            Assignments assignments = scoreSet.getAssignments();
            MiniExam miniExam = scoreSet.getMiniExam();

            Double finalScore = this.calculateFinalScore(exam, assignments, miniExam);

            calculatedScoreList.add(new CalculatedScore(
                    exam.getIdentifier(),
                    new DetailScore(finalScore),
                    new DetailScore(exam.getDetailScore().getScore()),
                    new DetailScore(assignments.calculateTotalScore(convertingService).doubleValue()),
                    new DetailScore(miniExam.calculateAdmissionRate()),
                    this.convertPointToGrade(
                            exam.getDetailScore().getScore() == null ? null : finalScore
                    )
            ));
        });

        return calculatedScoreList;
    }
}

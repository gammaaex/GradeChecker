package gammaaex.domain.service;

import gammaaex.domain.model.aggregate.ScoreSet;
import gammaaex.domain.model.entity.Assignments;
import gammaaex.domain.model.entity.CalculatedScore;
import gammaaex.domain.model.entity.Exam;
import gammaaex.domain.model.entity.MiniExam;
import gammaaex.domain.model.type.Grade;
import gammaaex.domain.model.value_object.DetailScore;

import java.util.ArrayList;
import java.util.List;

/**
 * 成績を計算するクラス
 */
public class GradeCalculatingService {

    /**
     * 成績をGradeに変換する。
     * scoreをnullに設定すると{@code Grade.K}が出力される。
     *
     * @param score 成績
     * @return Grade
     */
    public Grade convertPointToGrade(Double score) {
        Grade grade = Grade.K;

        if (score == null) return grade;

        if (score >= 90) {
            grade = Grade.A;
        } else if (score >= 80) {
            grade = Grade.B;
        } else if (score >= 70) {
            grade = Grade.C;
        } else if (score >= 60) {
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
        Double examScore = exam.getDetailScore().getZeroOrScore();
        Integer totalScore = assignments.calculateTotalScore();
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
                    new DetailScore(exam.getDetailScore().getNullOrScore()),
                    new DetailScore(assignments.calculateTotalScore().doubleValue()),
                    new DetailScore(miniExam.calculateAdmissionRate()),
                    this.convertPointToGrade(
                            exam.getDetailScore().getNullOrScore() == null ? null : finalScore
                    )
            ));
        });

        return calculatedScoreList;
    }
}

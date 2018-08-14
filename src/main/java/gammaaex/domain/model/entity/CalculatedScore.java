package gammaaex.domain.model.entity;

import gammaaex.domain.model.AbstractEntity;
import gammaaex.domain.model.AbstractValueObject;
import gammaaex.domain.model.type.Grade;
import gammaaex.domain.model.value_object.DetailScore;

import java.util.Objects;

/**
 * 計算された成績を保持する
 */
public final class CalculatedScore extends AbstractEntity<CalculatedScore> {

    /**
     * 最終成績
     */
    private final DetailScore finalScore;

    /**
     * 試験の点数
     */
    private final DetailScore examScore;

    /**
     * 課題の合計点
     */
    private final DetailScore assignmentsTotalScore;

    /**
     * 小テストの出席率
     */
    private final DetailScore miniExamAdmissionRate;

    /**
     * グレード
     */
    private final Grade grade;

    /**
     * コンストラクタ
     *
     * @param id                    識別子
     * @param finalScore            最終成績
     * @param examScore             試験の点数
     * @param assignmentsTotalScore 課題の合計点
     * @param miniExamAdmissionRate 小テストの出席率
     * @param grade                 グレード
     */
    public CalculatedScore(
            Integer id,
            DetailScore finalScore,
            DetailScore examScore,
            DetailScore assignmentsTotalScore,
            DetailScore miniExamAdmissionRate,
            Grade grade
    ) {
        super(id);
        this.finalScore = finalScore;
        this.examScore = examScore;
        this.assignmentsTotalScore = assignmentsTotalScore;
        this.miniExamAdmissionRate = miniExamAdmissionRate;
        this.grade = grade;
    }

    /**
     * @return get finalScore.
     */
    public DetailScore getFinalScore() {
        return finalScore;
    }

    /**
     * @return get examScore.
     */
    public DetailScore getExamScore() {
        return examScore;
    }

    /**
     * @return get assignmentsTotalScore.
     */
    public DetailScore getAssignmentsTotalScore() {
        return assignmentsTotalScore;
    }

    /**
     * @return get miniExamAdmissionRate.
     */
    public DetailScore getMiniExamAdmissionRate() {
        return miniExamAdmissionRate;
    }

    /**
     * @return get grade.
     */
    public Grade getGrade() {
        return grade;
    }
}

package gammaaex.domain.model.value_object;

import gammaaex.domain.model.AbstractValueObject;
import gammaaex.domain.model.type.Grade;

import java.util.Objects;

/**
 * 計算された成績を保持する
 */
public class CalculatedScore extends AbstractValueObject {

    /**
     * 識別子
     */
    private final Integer id;

    /**
     * 最終成績
     */
    private final Double finalScore;

    /**
     * 試験の点数
     */
    private final Double examScore;

    /**
     * 課題の合計点
     */
    private final Double assignmentsTotalScore;

    /**
     * 小テストの出席率
     */
    private final Double miniExamAdmissionRate;

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
            Double finalScore,
            Double examScore,
            Double assignmentsTotalScore,
            Double miniExamAdmissionRate,
            Grade grade
    ) {
        this.id = id;
        this.finalScore = finalScore;
        this.examScore = examScore;
        this.assignmentsTotalScore = assignmentsTotalScore;
        this.miniExamAdmissionRate = miniExamAdmissionRate;
        this.grade = grade;
    }

    /**
     * @return get id.
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return get finalScore.
     */
    public Double getFinalScore() {
        return finalScore;
    }

    /**
     * @return get examScore.
     */
    public Double getExamScore() {
        return examScore;
    }

    /**
     * @return get assignmentsTotalScore.
     */
    public Double getAssignmentsTotalScore() {
        return assignmentsTotalScore;
    }

    /**
     * @return get miniExamAdmissionRate.
     */
    public Double getMiniExamAdmissionRate() {
        return miniExamAdmissionRate;
    }

    /**
     * @return get grade.
     */
    public Grade getGrade() {
        return grade;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;

        if (object == null) return false;

        if (this.getClass() != object.getClass()) return false;

        CalculatedScore that = (CalculatedScore) object;

        if (!this.getId().equals(that.getId())) return false;

        if (!this.getFinalScore().equals(that.getFinalScore())) return false;

        if (!this.getExamScore().equals(that.getExamScore())) return false;

        if (!this.getAssignmentsTotalScore().equals(that.getAssignmentsTotalScore())) return false;

        if (!this.getMiniExamAdmissionRate().equals(that.getMiniExamAdmissionRate())) return false;

        if (!this.getGrade().equals(that.getGrade())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.getId(),
                this.getFinalScore(),
                this.getExamScore(),
                this.getAssignmentsTotalScore(),
                this.getMiniExamAdmissionRate(),
                this.getGrade()
        );
    }
}

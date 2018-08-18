package gammaaex.domain.model.entity;

import gammaaex.domain.model.type.Grade;

import java.util.ArrayList;
import java.util.List;

/**
 * CalculatedScoreののファーストクラスコレクション
 */
public class CalculatedScoreList {

    private List<CalculatedScore> calculatedScoreList;

    /**
     * コンストラクタ
     *
     * @param calculatedScoreList CalculatedScoreのList
     */
    public CalculatedScoreList(List<CalculatedScore> calculatedScoreList) {
        this.calculatedScoreList = calculatedScoreList;
    }

    /**
     * 平均点を計算する。
     *
     * @return 平均点
     */
    public Double calculateAverage() {
        Double average = 0.0;

        for (CalculatedScore calculatedScore : this.calculatedScoreList) {
            average += calculatedScore.getFinalScore().getZeroOrScore();
        }

        average = average / this.calculatedScoreList.size();

        return average;
    }

    /**
     * 最高点を計算する。
     *
     * @return 最高点
     */
    public Double calculateMaximize() {
        Double maximize = Double.MIN_VALUE;

        for (CalculatedScore calculatedScore : this.calculatedScoreList) {
            if (calculatedScore.getFinalScore().getZeroOrScore() > maximize) {
                maximize = calculatedScore.getFinalScore().getZeroOrScore();
            }
        }

        return maximize;
    }

    /**
     * 最高点を計算する。
     *
     * @return 最高点
     */
    public Double calculateMinimum() {
        Double minimum = Double.MAX_VALUE;

        for (CalculatedScore calculatedScore : this.calculatedScoreList) {
            if (calculatedScore.getFinalScore().getZeroOrScore() < minimum) {
                minimum = calculatedScore.getFinalScore().getZeroOrScore();
            }
        }

        return minimum;
    }

    /**
     * 単位取得者のみを抽出する。
     *
     * @return 単位取得者のList
     */
    public List<CalculatedScore> extractByCreditGetter() {
        List<CalculatedScore> extractedList = new ArrayList<>();

        this.calculatedScoreList.forEach(calculatedScore -> {
            if (calculatedScore.getGrade().equals(Grade.K)) return;
            if (calculatedScore.getGrade().equals(Grade.E)) return;

            extractedList.add(calculatedScore);
        });

        return extractedList;
    }

    /**
     * CalculatedScoreのListから指定されたGradeの数をカウントする。
     *
     * @param grade カウントしたいGrade
     * @return Gradeの数
     */
    public Integer countByGrade(Grade grade) {
        Integer count = 0;

        for (CalculatedScore calculatedScore : this.calculatedScoreList) {
            if (calculatedScore.getGrade().equals(grade)) count++;
        }

        return count;
    }
}

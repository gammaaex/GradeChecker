package gammaaex.domain.service;

import gammaaex.domain.model.type.Grade;
import gammaaex.domain.model.value_object.CalculatedScore;

import java.util.TreeMap;

/**
 * CalculatedScoreのビジネスロジックを司るクラス
 */
public class CalculatedScoreService {

    /**
     * 平均点を計算する。
     *
     * @param calculatedScoreMap CalculatedScoreのTreeMap
     * @return 平均点
     */
    public Double calculateAverage(TreeMap<Integer, CalculatedScore> calculatedScoreMap) {
        Double average = 0.0;

        for (Integer key : calculatedScoreMap.keySet()) {
            CalculatedScore calculatedScore = calculatedScoreMap.get(key);
            average += calculatedScore.getFinalScore() != null
                    ? calculatedScore.getFinalScore()
                    : 0.0;
        }

        average = average / calculatedScoreMap.size();

        return average;
    }

    /**
     * 最高点を計算する。
     *
     * @param calculatedScoreMap CalculatedScoreのTreeMap
     * @return 最高点
     */
    public Double calculateMaximize(TreeMap<Integer, CalculatedScore> calculatedScoreMap) {
        Double max = 0.0;

        for (Integer key : calculatedScoreMap.keySet()) {
            CalculatedScore calculatedScore = calculatedScoreMap.get(key);

            if (calculatedScore.getFinalScore() > max) max = calculatedScore.getFinalScore();
        }

        return max;
    }


    /**
     * 最高点を計算する。
     *
     * @param calculatedScoreMap CalculatedScoreのTreeMap
     * @return 最高点
     */
    public Double calculateMinimum(TreeMap<Integer, CalculatedScore> calculatedScoreMap) {
        Double max = Double.MAX_VALUE;

        for (Integer key : calculatedScoreMap.keySet()) {
            CalculatedScore calculatedScore = calculatedScoreMap.get(key);

            if (calculatedScore.getFinalScore() < max) max = calculatedScore.getFinalScore();
        }

        return max;
    }


    /**
     * 単位取得者のみを抽出する。
     *
     * @param calculatedScoreMap 全ての生徒のTreeMap
     * @return 単位取得者のTreeMap
     */
    public TreeMap<Integer, CalculatedScore> extractByCreditGetter(TreeMap<Integer, CalculatedScore> calculatedScoreMap) {
        TreeMap<Integer, CalculatedScore> extractedMap = new TreeMap<>();

        calculatedScoreMap.forEach((index, calculatedScore) -> {
            if (calculatedScore.getGrade().equals(Grade.K)) return;
            if (calculatedScore.getGrade().equals(Grade.E)) return;

            extractedMap.put(index, calculatedScore);
        });

        return extractedMap;
    }

    /**
     * グレードの数をカウントする。
     *
     * @param calculatedScoreMap
     * @param grade
     * @return
     */
    public Integer countByGrade(TreeMap<Integer, CalculatedScore> calculatedScoreMap, Grade grade) {
        Integer count = 0;

        for (CalculatedScore calculatedScore : calculatedScoreMap.values()) {
            if (calculatedScore.getGrade().equals(grade)) count++;
        }

        return count;
    }
}

package gammaaex.domain.service.other;

import gammaaex.domain.model.value_object.Assignments;
import gammaaex.domain.model.value_object.Exam;
import gammaaex.domain.model.value_object.MiniExam;
import gammaaex.domain.model.value_object.ScoreSet;

import java.util.TreeMap;

/**
 * MiniExamのビジネスロジックを司るクラス
 */
public class ScoreSetService {

    /**
     * ScoreSet用のMapを作成する。
     *
     * @param filledExamMap  ID飛びが無いテスト結果
     * @param assignmentsMap 課題
     * @param filledMiniExam ID飛びがない小テスト
     * @return ScoreSet用のMap
     */
    public TreeMap<Integer, ScoreSet> createScoreSetMap(TreeMap<Integer, Exam> filledExamMap, TreeMap<Integer, Assignments> assignmentsMap, TreeMap<Integer, MiniExam> filledMiniExam) {
        this.validateMapBySize(filledExamMap, assignmentsMap, filledMiniExam);

        TreeMap<Integer, ScoreSet> scoreSetMap = new TreeMap<>();
        for (Integer index = 1; index <= filledExamMap.size(); index++) {
            scoreSetMap.put(index, new ScoreSet(filledExamMap.get(index), assignmentsMap.get(index), filledMiniExam.get(index)));
        }

        return scoreSetMap;
    }

    /**
     * サイズによるバリデーションを行う。
     *
     * @param examMap テスト結果のMap
     * @param assignmentsMap 課題のMap
     * @param miniExamMap 小テストのMap
     */
    public void validateMapBySize(TreeMap<Integer, Exam> examMap, TreeMap<Integer, Assignments> assignmentsMap, TreeMap<Integer, MiniExam> miniExamMap) {
        if (examMap.size() != assignmentsMap.size() || examMap.size() != miniExamMap.size())
            throw new RuntimeException("3つのファイルのidが一致しません。");
    }
}

package gammaaex.domain.service;

import gammaaex.domain.model.aggregate.ScoreSet;
import gammaaex.domain.model.entity.Assignments;
import gammaaex.domain.model.entity.Exam;
import gammaaex.domain.model.entity.MiniExam;

import java.util.ArrayList;
import java.util.List;

/**
 * 変換を司るクラス
 */
public class ConvertingService {

    /**
     * ScoreSet用のListを作成する。
     *
     * @param filledExamList  ID飛びが無いテスト結果
     * @param assignmentsList 課題
     * @param miniExamList    ID飛びがない小テスト
     * @return ScoreSet用のList
     */
    public List<ScoreSet> createScoreSetList(
            List<Exam> filledExamList,
            List<Assignments> assignmentsList,
            List<MiniExam> miniExamList
    ) {
        if (filledExamList.size() != assignmentsList.size()) {
            throw new RuntimeException("3つのidが一致しません。");
        }
        if (filledExamList.size() != miniExamList.size()) {
            throw new RuntimeException("3つのidが一致しません。");
        }

        List<ScoreSet> scoreSetList = new ArrayList<>();

        for (Integer index = 0; index < filledExamList.size(); index++) {
            scoreSetList.add(
                    index,
                    new ScoreSet(
                            filledExamList.get(index),
                            assignmentsList.get(index),
                            miniExamList.get(index)
                    )
            );
        }

        return scoreSetList;
    }
}

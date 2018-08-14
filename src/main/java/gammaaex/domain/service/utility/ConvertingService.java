package gammaaex.domain.service.utility;

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
     * nullを整数値に変換する
     *
     * @param number Integerオブジェクト
     * @return nullでないIntegerオブジェクト
     */
    public Integer convertNullToInteger(Integer number) {
        return number == null ? 0 : number;
    }

    /**
     * nullを整数値に変換する
     *
     * @param number Doubleオブジェクト
     * @return nullでないDoubleオブジェクト
     */
    public Double convertNullToDouble(Double number) {
        return number == null ? 0.0 : number;
    }

    /**
     * Stringの配列をIntegerの配列に変換する。
     *
     * @param stringArray 変換元のString配列
     * @return 変換後のInteger配列
     */
    public Integer[] convertArrayToArray(String[] stringArray) {
        Integer[] integerArray = new Integer[stringArray.length];

        for (Integer index = 0; index < stringArray.length; index++) {
            try {
                integerArray[index] = Integer.parseInt(stringArray[index]);
            } catch (NumberFormatException e) {
                integerArray[index] = null;
            }
        }

        return integerArray;
    }

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

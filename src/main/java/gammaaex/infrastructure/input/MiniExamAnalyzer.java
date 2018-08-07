package gammaaex.infrastructure.input;

import gammaaex.domain.model.value_object.MiniExam;

import java.nio.file.Path;
import java.util.List;
import java.util.TreeMap;

/**
 * miniexam.csvを解析するクラス
 */
public class MiniExamAnalyzer extends FileAnalyzer {

    /**
     * コンストラクタ
     */
    public MiniExamAnalyzer() {

    }

    /**
     * exam用のTreeMapを連番（番号飛びなし）で生成する。
     *
     * @param resource 対象ファイルへのパス
     * @return TreeMap
     */
    public TreeMap<Integer, MiniExam> createExamMapFillId(Path resource) {
        TreeMap<Integer, MiniExam> treeMap = this.createExamMap(resource);

        for (Integer index = treeMap.firstKey(); index <= treeMap.size(); index++) {
            if (treeMap.containsKey(index)) continue;

            treeMap.put(index, new MiniExam(index,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null
            ));
        }

        return treeMap;
    }

    /**
     * exam用のTreeMapを生成する。
     *
     * @param resource 対象ファイルへのpath
     * @return TreeMap
     */
    public TreeMap<Integer, MiniExam> createExamMap(Path resource) {
        TreeMap<Integer, MiniExam> treeMap = new TreeMap<>();
        List<String> lines = this.fileToList(resource);

        for (String line : lines) {
            Integer[] miniExamArray = this.convertArrayToArray(parseCSVLine(line));
            MiniExam miniExam = new MiniExam(
                    miniExamArray[0],
                    miniExamArray[1],
                    miniExamArray[2],
                    miniExamArray[3],
                    miniExamArray[4],
                    miniExamArray[5],
                    miniExamArray[6],
                    miniExamArray[7],
                    miniExamArray[8],
                    miniExamArray[9],
                    miniExamArray[10],
                    miniExamArray[11],
                    miniExamArray[12],
                    miniExamArray[13],
                    miniExamArray[14]
            );

            treeMap.put(miniExam.id, miniExam);
        }

        return treeMap;
    }

    /**
     * Stringの配列をIntegerの配列に変換する。
     *
     * @param stringArray 変換元のString配列
     * @return 変換後のInteger配列
     */
    private Integer[] convertArrayToArray(String[] stringArray) {
        Integer[] integerArray = null;

        for (Integer index = 0; index < stringArray.length; index++) {
            try {
                integerArray[index] = Integer.parseInt(stringArray[index]);
            } catch (NumberFormatException numberFormatException) {
                integerArray[index] = null;
            }
        }

        return integerArray;
    }
}

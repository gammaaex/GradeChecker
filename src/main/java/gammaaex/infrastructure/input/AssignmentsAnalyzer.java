package gammaaex.infrastructure.input;

import gammaaex.domain.model.value_object.Assignments;

import java.nio.file.Path;
import java.util.List;
import java.util.TreeMap;

/**
 * assignments.csvを解析するクラス
 */
public class AssignmentsAnalyzer extends FileAnalyzer {

    /**
     * コンストラクタ
     */
    public AssignmentsAnalyzer() {

    }

    /**
     * assignments用のTreeMapを生成する。
     *
     * @param resource 対象ファイルへのパス
     * @return assignments用のTreeMap
     */
    public TreeMap<Integer, Assignments> createAssignmentsMap(Path resource) {
        TreeMap<Integer, Assignments> treeMap = new TreeMap<>();
        List<String> lines = this.fileToList(resource);

        for (String line : lines) {
            Integer[] assignmentsArray = this.convertArrayToArray(parseCSVLine(line));
            Assignments assignments = new Assignments(
                    assignmentsArray[0],
                    assignmentsArray[1],
                    assignmentsArray[2],
                    assignmentsArray[3],
                    assignmentsArray[4],
                    assignmentsArray[5],
                    assignmentsArray[6]
            );

            treeMap.put(assignments.id, assignments);
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

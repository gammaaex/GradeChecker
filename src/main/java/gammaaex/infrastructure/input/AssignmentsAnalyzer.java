package gammaaex.infrastructure.input;

import gammaaex.domain.model.value_object.Assignments;
import gammaaex.domain.service.ConvertingService;

import java.nio.file.Path;
import java.util.List;
import java.util.TreeMap;

/**
 * assignments.csvを解析するクラス
 */
public class AssignmentsAnalyzer extends FileAnalyzer {

    /**
     * Service変数
     */
    private final ConvertingService convertingService;

    /**
     * コンストラクタ
     */
    public AssignmentsAnalyzer() {
        this.convertingService = new ConvertingService();
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
            Integer[] assignmentsArray = this.convertingService.convertArrayToArray(parseCSVLine(line));
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
}

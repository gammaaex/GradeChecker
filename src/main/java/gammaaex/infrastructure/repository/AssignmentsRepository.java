package gammaaex.infrastructure.repository;

import gammaaex.domain.model.value_object.Assignments;
import gammaaex.infrastructure.dao.FileDAO;
import gammaaex.infrastructure.service.ConvertingService;

import java.nio.file.Path;
import java.util.List;
import java.util.TreeMap;

/**
 * assignments.csvを操作するクラス
 */
public class AssignmentsRepository extends FileDAO {

    /**
     * コンストラクタ
     */
    public AssignmentsRepository() {
        super();
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
            Integer[] assignmentsArray = new ConvertingService().convertArrayToArray(this.parseCSVLine(line));
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

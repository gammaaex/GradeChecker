package gammaaex.infrastructure.repository;

import gammaaex.domain.model.value_object.Exam;
import gammaaex.infrastructure.dao.FileDAO;

import java.nio.file.Path;
import java.util.List;
import java.util.TreeMap;

/**
 * exam.csvを操作するクラス
 */
public class ExamRepository extends FileDAO {

    /**
     * コンストラクタ
     */
    public ExamRepository() {
        super();
    }

    /**
     * exam用のTreeMapを連番（番号飛びなし）で生成する。
     *
     * @param resource 対象ファイルへのパス
     * @return TreeMap
     */
    public TreeMap<Integer, Exam> createExamMapFillId(Path resource) {
        TreeMap<Integer, Exam> treeMap = this.createExamMap(resource);

        for (Integer index = treeMap.firstKey(); index <= treeMap.size(); index++) {
            if (treeMap.containsKey(index)) continue;

            treeMap.put(index, new Exam(index, null));
        }

        return treeMap;
    }

    /**
     * exam用のTreeMapを生成する。
     *
     * @param resource 対象ファイルへのpath
     * @return TreeMap
     */
    public TreeMap<Integer, Exam> createExamMap(Path resource) {
        TreeMap<Integer, Exam> treeMap = new TreeMap<>();
        List<String> lines = this.fileToList(resource);

        for (String line : lines) {
            String[] examArray = parseCSVLine(line);
            Exam exam = new Exam(Integer.parseInt(examArray[0]), Double.parseDouble(examArray[1]));

            treeMap.put(exam.id, exam);
        }

        return treeMap;
    }
}

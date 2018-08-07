package gammaaex.infrastructure.input;

import gammaaex.domain.model.value_object.Exam;

import java.nio.file.Path;
import java.util.List;
import java.util.TreeMap;

/**
 * exam.csvを解析するクラス
 */
public class ExamAnalyzer extends FileAnalyzer {

    /**
     * コンストラクタ
     */
    public ExamAnalyzer() {

    }

    /**
     * exam用のTreeMapを連番（番号飛びなし）で生成する
     *
     * @param path 対象ファイルへのパス
     * @return TreeMap
     */
    public TreeMap<Integer, Exam> createExamMapFillId(Path path) {
        TreeMap<Integer, Exam> treeMap = this.createExamMap(path);

        for (Integer index = treeMap.firstKey(); index <= treeMap.size(); index++) {
            if (treeMap.containsKey(index)) continue;

            treeMap.put(index, new Exam(index, null));
        }

        return treeMap;
    }

    /**
     * exam用のTreeMapを生成する
     *
     * @param path 対象ファイルへのpath
     * @return TreeMap
     */
    public TreeMap<Integer, Exam> createExamMap(Path path) {
        TreeMap<Integer, Exam> treeMap = new TreeMap<>();

        List<String> lines = this.fileToList(path);

        for (String line : lines) {
            String[] examArray = parseCSVLine(line);
            Exam exam = new Exam(Integer.parseInt(examArray[0]), Double.parseDouble(examArray[1]));

            treeMap.put(exam.id, exam);
        }

        return treeMap;
    }
}

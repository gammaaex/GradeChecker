package gammaaex.domain.service;

import gammaaex.domain.model.entity.Exam;
import gammaaex.domain.repository.AbstractExamRepository;

import java.util.List;
import java.util.TreeMap;

/**
 * Examのビジネスロジックを司るクラス
 */
public class ExamService {

    /**
     * リポジトリ
     */
    private final AbstractExamRepository repository;

    /**
     * コンストラクタ
     */
    public ExamService(AbstractExamRepository repository) {
        this.repository = repository;
    }

    /**
     * exam用のTreeMapを連番（番号飛びなし）で生成する。
     *
     * @param fileName 対象ファイルへのパス
     * @return TreeMap
     */
    public TreeMap<Integer, Exam> createMapFillId(String fileName) {
        TreeMap<Integer, Exam> treeMap = this.createMap(fileName);

        for (Integer index = treeMap.firstKey(); index <= treeMap.size(); index++) {
            if (treeMap.containsKey(index)) continue;

            treeMap.put(index, new Exam(index, null));
        }

        return treeMap;
    }

    /**
     * exam用のTreeMapを生成する。
     *
     * @param fileName 対象ファイルへのpath
     * @return TreeMap
     */
    public TreeMap<Integer, Exam> createMap(String fileName) {
        TreeMap<Integer, Exam> treeMap = new TreeMap<>();
        List<String> lines = this.repository.fileToList(this.repository.getResource(fileName));

        for (String line : lines) {
            String[] examArray = this.repository.parseCSVLine(line);
            Exam exam = new Exam(Integer.parseInt(examArray[0]), Double.parseDouble(examArray[1]));

            treeMap.put(exam.getId(), exam);
        }

        return treeMap;
    }
}

package gammaaex.domain.service;

import gammaaex.domain.model.entity.Assignments;
import gammaaex.domain.repository.AbstractAssignmentsRepository;
import gammaaex.domain.service.utility.ConvertingService;

import java.util.List;
import java.util.TreeMap;

/**
 * Assignmentsのビジネスロジックを司るクラス
 */
public class AssignmentsService {

    /**
     * リポジトリ
     */
    private final AbstractAssignmentsRepository repository;

    /**
     * Service変数
     */
    private final ConvertingService convertingService;

    /**
     * コンストラクタ
     */
    public AssignmentsService(AbstractAssignmentsRepository repository) {
        this.repository = repository;
        this.convertingService = new ConvertingService();
    }

    /**
     * 課題の合計点を計算する。
     *
     * @param assignments 課題
     * @return 合計点
     */
    public Integer calculateTotalScore(Assignments assignments) {
        Integer totalScore = 0;

        totalScore += this.convertingService.convertNullToInteger(assignments.getScore1());
        totalScore += this.convertingService.convertNullToInteger(assignments.getScore2());
        totalScore += this.convertingService.convertNullToInteger(assignments.getScore3());
        totalScore += this.convertingService.convertNullToInteger(assignments.getScore4());
        totalScore += this.convertingService.convertNullToInteger(assignments.getScore5());
        totalScore += this.convertingService.convertNullToInteger(assignments.getScore6());

        return totalScore;
    }

    /**
     * assignments用のTreeMapを生成する。
     *
     * @param fileName 対象ファイルの名前
     * @return assignments用のTreeMap
     */
    public TreeMap<Integer, Assignments> createMap(String fileName) {
        TreeMap<Integer, Assignments> treeMap = new TreeMap<>();
        List<String> lines = this.repository.fileToList(this.repository.getResource(fileName));

        for (String line : lines) {
            Integer[] assignmentsArray = new ConvertingService().convertArrayToArray(this.repository.parseCSVLine(line));
            Assignments assignments = new Assignments(
                    assignmentsArray[0],
                    assignmentsArray[1],
                    assignmentsArray[2],
                    assignmentsArray[3],
                    assignmentsArray[4],
                    assignmentsArray[5],
                    assignmentsArray[6]
            );

            treeMap.put(assignments.getIdentifier(), assignments);
        }

        return treeMap;
    }
}

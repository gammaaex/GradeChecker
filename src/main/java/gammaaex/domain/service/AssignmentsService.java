package gammaaex.domain.service;

import gammaaex.domain.model.entity.Assignments;
import gammaaex.domain.model.value_object.NormalScore;
import gammaaex.domain.repository.AbstractAssignmentsRepository;
import gammaaex.domain.service.utility.ConvertingService;

import java.util.List;
import java.util.TreeMap;

/**
 * Assignmentsのビジネスロジックを司るクラス
 */
public class AssignmentsService {

    /**
     * AssignmentsのRepository
     */
    private final AbstractAssignmentsRepository repository;

    /**
     * {@link ConvertingService ConvertingServiceを参照}
     */
    private final ConvertingService convertingService;

    /**
     * コンストラクタ
     *
     * @param repository        AssignmentsのRepository
     * @param convertingService ConvertingServiceのインスタンス
     */
    public AssignmentsService(AbstractAssignmentsRepository repository, ConvertingService convertingService) {
        this.repository = repository;
        this.convertingService = convertingService;
    }

    /**
     * 課題の合計点を計算する。
     *
     * @param assignments 課題
     * @return 合計点
     */
    public Integer calculateTotalScore(Assignments assignments) {
        Integer totalScore = 0;

        totalScore += this.convertingService.convertNullToInteger(assignments.getScore1().getScore());
        totalScore += this.convertingService.convertNullToInteger(assignments.getScore2().getScore());
        totalScore += this.convertingService.convertNullToInteger(assignments.getScore3().getScore());
        totalScore += this.convertingService.convertNullToInteger(assignments.getScore4().getScore());
        totalScore += this.convertingService.convertNullToInteger(assignments.getScore5().getScore());
        totalScore += this.convertingService.convertNullToInteger(assignments.getScore6().getScore());

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
                    new NormalScore(assignmentsArray[1]),
                    new NormalScore(assignmentsArray[2]),
                    new NormalScore(assignmentsArray[3]),
                    new NormalScore(assignmentsArray[4]),
                    new NormalScore(assignmentsArray[5]),
                    new NormalScore(assignmentsArray[6])
            );

            treeMap.put(assignments.getIdentifier(), assignments);
        }

        return treeMap;
    }
}

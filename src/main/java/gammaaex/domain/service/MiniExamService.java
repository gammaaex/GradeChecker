package gammaaex.domain.service;

import gammaaex.domain.model.entity.MiniExam;
import gammaaex.domain.model.value_object.MiniExamScore;
import gammaaex.domain.repository.AbstractMiniExamRepository;
import gammaaex.domain.service.utility.ConvertingService;

import java.util.List;
import java.util.TreeMap;

/**
 * MiniExamのビジネスロジックを司るクラス
 */
public class MiniExamService {

    /**
     * MiniExamのRepository
     */
    private final AbstractMiniExamRepository repository;

    /**
     * コンストラクタ
     *
     * @param repository MiniExamのRepository
     */
    public MiniExamService(AbstractMiniExamRepository repository) {
        this.repository = repository;
    }

    /**
     * 小テストの受験率を計算する。
     *
     * @param miniExam 小テスト
     * @return 受験率
     */
    public Double calculateAdmissionRate(MiniExam miniExam) {
        Integer totalScore = this.calculateNumberOfAdmission(miniExam);
        Integer numberOfMaxMiniExam = 14;
        Double rate = totalScore.doubleValue() / numberOfMaxMiniExam.doubleValue();

        if (rate < 0.0 && rate > 1.0) throw new RuntimeException("受験率の値が不正です。");

        return rate;
    }

    /**
     * 小テストの回数を計算する。
     *
     * @param miniExam 小テスト
     * @return 受験
     */
    public Integer calculateNumberOfAdmission(MiniExam miniExam) {
        Integer count = 0;

        count += getCount(miniExam.getScore1());
        count += getCount(miniExam.getScore2());
        count += getCount(miniExam.getScore3());
        count += getCount(miniExam.getScore4());
        count += getCount(miniExam.getScore5());
        count += getCount(miniExam.getScore6());
        count += getCount(miniExam.getScore7());
        count += getCount(miniExam.getScore8());
        count += getCount(miniExam.getScore9());
        count += getCount(miniExam.getScore10());
        count += getCount(miniExam.getScore11());
        count += getCount(miniExam.getScore12());
        count += getCount(miniExam.getScore13());
        count += getCount(miniExam.getScore14());

        return count;
    }

    /**
     * Integerオブジェクトがnullかどうか判断し、結果によって0か1を返す。
     *
     * @param score 対象のIntegerオブジェクト
     * @return Integer 0か1
     */
    private Integer getCount(MiniExamScore score) {
        return score.getScore() != null ? 1 : 0;
    }

    /**
     * exam用のTreeMapを連番（番号飛びなし）で生成する。
     *
     * @param fileName 対象ファイルへのパス
     * @return TreeMap
     */
    public TreeMap<Integer, MiniExam> createMapFillId(String fileName) {
        TreeMap<Integer, MiniExam> treeMap = this.createMap(fileName);

        for (Integer index = treeMap.firstKey(); index <= treeMap.size(); index++) {
            if (treeMap.containsKey(index)) continue;

            treeMap.put(index, new MiniExam(index,
                    new MiniExamScore(null),
                    new MiniExamScore(null),
                    new MiniExamScore(null),
                    new MiniExamScore(null),
                    new MiniExamScore(null),
                    new MiniExamScore(null),
                    new MiniExamScore(null),
                    new MiniExamScore(null),
                    new MiniExamScore(null),
                    new MiniExamScore(null),
                    new MiniExamScore(null),
                    new MiniExamScore(null),
                    new MiniExamScore(null),
                    new MiniExamScore(null)
            ));
        }

        return treeMap;
    }

    /**
     * exam用のTreeMapを生成する。
     *
     * @param fileName 対象ファイルへのpath
     * @return TreeMap
     */
    public TreeMap<Integer, MiniExam> createMap(String fileName) {
        TreeMap<Integer, MiniExam> treeMap = new TreeMap<>();
        List<String> lines = this.repository.fileToList(this.repository.getResource(fileName));

        for (String line : lines) {
            Integer[] miniExamArray = new ConvertingService().convertArrayToArray(this.repository.parseCSVLine(line));
            MiniExam miniExam = new MiniExam(
                    miniExamArray[0],
                    new MiniExamScore(miniExamArray[1]),
                    new MiniExamScore(miniExamArray[2]),
                    new MiniExamScore(miniExamArray[3]),
                    new MiniExamScore(miniExamArray[4]),
                    new MiniExamScore(miniExamArray[5]),
                    new MiniExamScore(miniExamArray[6]),
                    new MiniExamScore(miniExamArray[7]),
                    new MiniExamScore(miniExamArray[8]),
                    new MiniExamScore(miniExamArray[9]),
                    new MiniExamScore(miniExamArray[10]),
                    new MiniExamScore(miniExamArray[11]),
                    new MiniExamScore(miniExamArray[12]),
                    new MiniExamScore(miniExamArray[13]),
                    new MiniExamScore(miniExamArray[14])
            );

            treeMap.put(miniExam.getIdentifier(), miniExam);
        }

        return treeMap;
    }
}

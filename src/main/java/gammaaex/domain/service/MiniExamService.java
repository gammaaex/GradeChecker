package gammaaex.domain.service;

import gammaaex.domain.model.entity.MiniExam;
import gammaaex.domain.repository.AbstractMiniExamRepository;
import gammaaex.domain.service.other.ConvertingService;

import java.util.List;
import java.util.TreeMap;

/**
 * MiniExamのビジネスロジックを司るクラス
 */
public class MiniExamService {

    /**
     * リポジトリ
     */
    private final AbstractMiniExamRepository repository;

    /**
     * コンストラクタ
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
     * @param number 対象のIntegerオブジェクト
     * @return Integer 0か1
     */
    private Integer getCount(Integer number) {
        return number != null ? 1 : 0;
    }


    /**
     * exam用のTreeMapを連番（番号飛びなし）で生成する。
     *
     * @param fileName 対象ファイルへのパス
     * @return TreeMap
     */
    public TreeMap<Integer, MiniExam> createExamMapFillId(String fileName) {
        TreeMap<Integer, MiniExam> treeMap = this.createMap(fileName);

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

            treeMap.put(miniExam.getId(), miniExam);
        }

        return treeMap;
    }
}

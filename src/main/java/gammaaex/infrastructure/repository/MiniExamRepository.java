package gammaaex.infrastructure.repository;

import gammaaex.domain.model.entity.MiniExam;
import gammaaex.domain.model.value_object.NormalScore;
import gammaaex.domain.repository.MiniExamRepositoryInterface;
import gammaaex.infrastructure.dao.DaoConvertingService;
import gammaaex.infrastructure.dao.FileDao;

import java.util.ArrayList;
import java.util.List;

/**
 * MiniExamのRepository
 */
public class MiniExamRepository implements MiniExamRepositoryInterface {

    /**
     * リソースにアクセスするためのDAO
     */
    private FileDao fileDao = new FileDao();

    /**
     * 対象ファイルのファイル名
     */
    private String fileName;

    /**
     * コンストラクタ
     *
     * @param fileName ファイル名
     */
    public MiniExamRepository(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<MiniExam> findAll() {
        List<String> lines = this.fileDao.fileToList(this.fileDao.getResource(fileName));
        List<MiniExam> resultSet = new ArrayList<>();

        for (String line : lines) {
            Integer[] miniExamArray = new DaoConvertingService().convertArrayToArray(this.fileDao.parseCSVLine(line));
            MiniExam miniExam = new MiniExam(
                    miniExamArray[0],
                    new NormalScore(miniExamArray[1]),
                    new NormalScore(miniExamArray[2]),
                    new NormalScore(miniExamArray[3]),
                    new NormalScore(miniExamArray[4]),
                    new NormalScore(miniExamArray[5]),
                    new NormalScore(miniExamArray[6]),
                    new NormalScore(miniExamArray[7]),
                    new NormalScore(miniExamArray[8]),
                    new NormalScore(miniExamArray[9]),
                    new NormalScore(miniExamArray[10]),
                    new NormalScore(miniExamArray[11]),
                    new NormalScore(miniExamArray[12]),
                    new NormalScore(miniExamArray[13]),
                    new NormalScore(miniExamArray[14])
            );

            resultSet.add(miniExam);
        }

        return resultSet;
    }

    @Override
    public List<MiniExam> findAllByFillId() {
        List<MiniExam> resultSet = this.findAll();

        resultSet.add(0, null);
        for (Integer index = 1; index < resultSet.get(resultSet.size() - 1).getIdentifier(); index++) {
            if (resultSet.get(index).getIdentifier().equals(index)) continue;

            resultSet.add(index, new MiniExam(index,
                    new NormalScore(null),
                    new NormalScore(null),
                    new NormalScore(null),
                    new NormalScore(null),
                    new NormalScore(null),
                    new NormalScore(null),
                    new NormalScore(null),
                    new NormalScore(null),
                    new NormalScore(null),
                    new NormalScore(null),
                    new NormalScore(null),
                    new NormalScore(null),
                    new NormalScore(null),
                    new NormalScore(null)
            ));
        }
        resultSet.remove(0);

        return resultSet;
    }
}

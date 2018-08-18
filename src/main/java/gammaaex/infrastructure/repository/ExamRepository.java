package gammaaex.infrastructure.repository;

import gammaaex.domain.model.entity.Exam;
import gammaaex.domain.model.value_object.DetailScore;
import gammaaex.domain.repository.ExamRepositoryInterface;
import gammaaex.infrastructure.dao.FileDao;

import java.util.ArrayList;
import java.util.List;

/**
 * ExamのRepository
 */
public class ExamRepository implements ExamRepositoryInterface {

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
    public ExamRepository(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Exam> findAll() {
        List<String> lines = this.fileDao.fileToList(this.fileDao.getResource(fileName));
        List<Exam> resultSet = new ArrayList<>();

        for (String line : lines) {
            String[] examArray = this.fileDao.parseCSVLine(line);
            Exam exam = new Exam(
                    Integer.parseInt(examArray[0]),
                    new DetailScore(Double.parseDouble(examArray[1]))
            );

            resultSet.add(exam);
        }

        return resultSet;
    }

    @Override
    public List<Exam> findAllByFillId() {
        List<Exam> resultSet = this.findAll();

        resultSet.add(0, null);
        for (Integer index = 1; index < resultSet.get(resultSet.size() - 1).getIdentifier(); index++) {
            if (index.equals(0)) continue;
            if (resultSet.get(index).getIdentifier().equals(index)) continue;

            resultSet.add(index, new Exam(index, new DetailScore(null)));
        }
        resultSet.remove(0);

        return resultSet;
    }
}

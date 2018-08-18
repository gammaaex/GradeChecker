package gammaaex.infrastructure.repository;

import gammaaex.domain.model.entity.Assignments;
import gammaaex.domain.model.value_object.NormalScore;
import gammaaex.domain.repository.AssignmentsRepositoryInterface;
import gammaaex.infrastructure.dao.DaoConvertingService;
import gammaaex.infrastructure.dao.FileDao;

import java.util.ArrayList;
import java.util.List;

/**
 * AssignmentsのRepository
 */
public class AssignmentsRepository implements AssignmentsRepositoryInterface {

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
    public AssignmentsRepository(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Assignments> findAll() {
        List<String> lines = this.fileDao.fileToList(this.fileDao.getResource(this.fileName));
        List<Assignments> resultSet = new ArrayList<>();

        for (String line : lines) {
            Integer[] assignmentsArray = new DaoConvertingService().convertArrayToArray(this.fileDao.parseCSVLine(line));
            Assignments assignments = new Assignments(
                    assignmentsArray[0],
                    new NormalScore(assignmentsArray[1]),
                    new NormalScore(assignmentsArray[2]),
                    new NormalScore(assignmentsArray[3]),
                    new NormalScore(assignmentsArray[4]),
                    new NormalScore(assignmentsArray[5]),
                    new NormalScore(assignmentsArray[6])
            );

            resultSet.add(assignments);
        }

        return resultSet;
    }
}

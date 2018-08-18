package gammaaex.domain.repository;


import gammaaex.domain.model.entity.Exam;

import java.util.List;

/**
 * ExamのRepositoryのインタフェース
 */
public interface ExamRepositoryInterface extends RepositoryInterface<Exam> {

    /**
     * id埋めがされたListを返す。
     *
     * @return id埋めがされたList
     */
    List<Exam> findAllByFillId();

}

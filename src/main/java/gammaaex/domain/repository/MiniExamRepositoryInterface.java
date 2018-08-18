package gammaaex.domain.repository;


import gammaaex.domain.model.entity.MiniExam;

import java.util.List;

/**
 * MiniExamのRepositoryのインタフェース
 */
public interface MiniExamRepositoryInterface extends RepositoryInterface<MiniExam> {

    /**
     * id埋めがされたListを返す。
     *
     * @return id埋めがされたList
     */
    List<MiniExam> findAllByFillId();

}

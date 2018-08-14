package gammaaex.domain.repository;


import gammaaex.domain.model.entity.MiniExam;

import java.util.List;

/**
 * MiniExamのRepositoryのインタフェース
 */
public interface MiniExamRepositoryInterface extends RepositoryInterface<MiniExam> {

    List<MiniExam> findAllByFillId();

}

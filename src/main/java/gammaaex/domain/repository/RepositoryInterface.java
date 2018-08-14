package gammaaex.domain.repository;

import java.util.List;

/**
 * Repositoryのインタフェース
 */
public interface RepositoryInterface<Type> {

    List<Type> findAll();

}

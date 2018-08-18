package gammaaex.domain.repository;

import java.util.List;

/**
 * Repositoryのインタフェース
 */
public interface RepositoryInterface<Type> {

    /**
     * リソースをEntityのListに変換して返す。
     *
     * @return EntityのList
     */
    List<Type> findAll();

}

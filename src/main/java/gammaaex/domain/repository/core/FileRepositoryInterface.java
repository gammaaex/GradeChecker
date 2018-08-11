package gammaaex.domain.repository.core;

import java.nio.file.Path;
import java.util.List;

/**
 * ファイル操作クラスのインタフェース
 */
public interface FileRepositoryInterface extends Repository {

    /**
     * CSV形式の行を文字列型配列に変換する。
     *
     * @param line 対象の行
     * @return 文字列配列
     */
    String[] parseCSVLine(String line);

    /**
     * ファイルを行ごとのListに変換する。
     *
     * @param path 対象ファイルへのpath
     * @return List
     */
    List<String> fileToList(Path path);

    /**
     * リソースとなるファイルを取得する。
     *
     * @param fileName ファイル名
     * @return ファイルのPath
     */
    Path getResource(String fileName);
}

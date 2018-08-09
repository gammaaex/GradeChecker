package gammaaex.infrastructure.core;


import gammaaex.Main;
import gammaaex.domain.repository.core.FileRepositoryInterface;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ファイル解析の基底クラス
 * 個別のファイル解析クラスを実装する場合はこのクラスを継承すること
 */
public class FileRepository implements FileRepositoryInterface {

    /**
     * コンストラクタ
     */
    public FileRepository() {

    }

    /**
     * CSV形式の行を文字列型配列に変換する。
     *
     * @param line 対象の行
     * @return 文字列配列
     */
    @Override
    public String[] parseCSVLine(String line) {
        return line.split(",", -1);
    }

    /**
     * ファイルを行ごとのListに変換する。
     *
     * @param path 対象ファイルへのpath
     * @return List
     */
    @Override
    public List<String> fileToList(Path path) {
        try {
            return Files.lines(path, StandardCharsets.UTF_8).collect(Collectors.toList());
        } catch (IOException exception) {
            exception.printStackTrace();
            throw new RuntimeException(exception);
        }
    }

    /**
     * リソースとなるファイルを取得する。
     *
     * @param fileName resource file name.
     * @return get resource path.
     */
    @Override
    public Path getResource(String fileName) {
        Path resource = null;

        try {
            resource = Paths.get(Main.class.getResource(fileName).getPath());
        } catch (NullPointerException nullPointerException) {
            throw new RuntimeException("課題データファイルが見つかりません。");
        }

        return resource;
    }
}

package gammaaex.Analyzer;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ファイル解析の基底クラス
 * 個別のファイル解析クラスを実装する場合、
 * このクラスを継承することを推奨する
 */
public class FileAnalyzer {

    /**
     * コンストラクタ
     */
    public FileAnalyzer() {

    }

    /**
     * CSV形式の行を文字列型配列に変換する
     *
     * @param line 対象の行
     * @return 文字列配列
     */
    public String[] parseCSVLine(String line) {
        return line.split(",");
    }

    /**
     * ファイルを行ごとのListに変換する
     *
     * @param path 対象ファイルへのpath
     * @return List
     */
    public List<String> fileToList(Path path) {
        List<String> list = null;

        try {
            list = Files.lines(path, StandardCharsets.UTF_8).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (list == null) throw new NullPointerException();

        return list;
    }
}

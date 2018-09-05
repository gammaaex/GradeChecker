package gammaaex;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Arguments {

    /**
     * 引数のコレクション
     */
    private final List<String> argList;

    /**
     * コンストラクタ
     *
     * @param args
     */
    public Arguments(String[] args) {
        this.argList = Arrays.asList(args);
    }

    /**
     * 文字列の引数から型を検出しその連想配列を生成する
     *
     * @return Optionとファイル名の連想配列
     */
    public Map<Option, String> create() {
        Iterator<String> argIterator = this.argList.iterator();
        Map<Option, String> argMap = new HashMap<>();

        while (argIterator.hasNext()) {
            String option = argIterator.next();
            if (!Option.isOption(option)) continue;

            String fileName = argIterator.next();
            if (Option.isOption(fileName)) {
                // ファイル名が空ということ。このオプションで渡されたファイルは0点。
            } else {
                argMap.put(Option.getByName(Option.removePrefix(option)), fileName);
            }
        }

        return argMap;
    }
}

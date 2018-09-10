package gammaaex.domain.model.value_object;

import gammaaex.domain.model.AbstractValueObject;
import gammaaex.domain.model.type.Option;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class Arguments extends AbstractValueObject {

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

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;

        if (object == null) return false;

        if (this.getClass() != object.getClass()) return false;

        Arguments that = (Arguments) object;

        if (!this.argList.equals(that.argList)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.argList);
    }
}

package gammaaex.presentation.print;

/**
 * 標準出力を司るクラス
 * 個別のPrinterクラスを実装する際はこのクラスを継承すること
 */
public class Printer {

    public static final String ARGUMENT_NOT_FOUND = "ERROR: 試験の成績ファイルが指定されていません．";

    /**
     * コンストラクタ
     */
    public Printer() {

    }

    /**
     * CSV形式でPrintする
     *
     * @param arguments 文字列の可変長引数
     */
    public void printCSVLine(String... arguments) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String argument : arguments) {
            stringBuilder.append(argument).append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        System.out.println(stringBuilder);
    }

    /**
     * Error文を出力する
     */
    public void printError() {
        System.err.println(ARGUMENT_NOT_FOUND);
    }
}

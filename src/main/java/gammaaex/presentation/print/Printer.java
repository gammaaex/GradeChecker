package gammaaex.presentation.print;

import gammaaex.domain.model.entity.Exam;

/**
 * 標準出力を司るクラス
 * 個別のPrinterクラスを実装する際はこのクラスを継承すること
 */
public class Printer {

    /**
     * CSV形式でPrintする。
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
     * ファイルが指定されていない場合のError文を出力する。
     */
    public void printErrorByArgumentNotFound(String rightCommand) {
        System.err.println("ERROR: 試験の成績ファイルが指定されていません．");
        System.err.println(rightCommand);
    }
}

package gammaaex.presentation.print;

import gammaaex.domain.model.entity.Exam;

/**
 * 標準出力を司るクラス
 * 個別のPrinterクラスを実装する際はこのクラスを継承すること
 */
public class Printer {

    /**
     * コンストラクタ
     */
    public Printer() {

    }

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

    /**
     * 全ての情報を一度に出力する。
     * 表示内容：ID，最終成績，試験の点数，課題の合計点，小テストの受験回数，グレード
     *
     * @param exam            テスト結果
     * @param finalScore      最終成績
     * @param assignmentScore 課題の合計点
     * @param admissionRate   小テストの受験回数
     * @param grade           グレードのテキスト表現
     */
    public void printAll(Exam exam, Double finalScore, Integer assignmentScore, Double admissionRate, String grade) {
        System.out.printf("%d, %f, %f, %d, %f, %s\n",
                exam.getIdentifier(),
                finalScore != null ? finalScore : 0.0,
                exam.getExamScore().getScore() != null ? exam.getExamScore().getScore() : 0,
                assignmentScore,
                admissionRate,
                grade
        );
    }
}

package gammaaex.analyzer;


import gammaaex.printer.Printer;

import java.nio.file.Path;

/**
 * 引数を解析するクラス
 */
public class ArgumentAnalyzer {

    /**
     * exam.csvのパス
     */
    private Path exam;

    /**
     * assignments.csvのパス
     */
    private Path assignments;

    /**
     * miniExam.csvのパス
     */
    private Path miniExam;

//    /**
//     * コンストラクタ
//     *
//     * @param examFileName exam.csvに相当するファイルのファイル名
//     * @param assignmentsFileName assignments.csvに相当するファイルのファイル名
//     * @param miniExamFileName miniExam.csvに相当するファイルのファイル名
//     */
//    public ArgumentAnalyzer(String examFileName, String assignmentsFileName, String miniExamFileName) {
//        FileAnalyzer fileAnalyzer = new FileAnalyzer();
//
//        this.setExam(fileAnalyzer.getResource(examFileName));
//        this.setAssignments(fileAnalyzer.getResource(assignmentsFileName));
//        this.setMiniExam(fileAnalyzer.getResource(miniExamFileName));
//    }

    /**
     * コンストラクタ
     */
    public ArgumentAnalyzer() {

    }

    /**
     * @return get exam.
     */
    public Path getExam() {
        return exam;
    }

    /**
     * @param exam set exam.
     */
    public void setExam(Path exam) {
        this.exam = exam;
    }

    /**
     * @return get assignments.
     */
    public Path getAssignments() {
        return assignments;
    }

    /**
     * @param assignments set assignments.
     */
    public void setAssignments(Path assignments) {
        this.assignments = assignments;
    }

    /**
     * @return get miniExam.
     */
    public Path getMiniExam() {
        return miniExam;
    }

    /**
     * @param miniExam set miniExam.
     */
    public void setMiniExam(Path miniExam) {
        this.miniExam = miniExam;
    }

    /**
     * コマンドライン引数が1つのアプリケーションのための検証メソッド
     * 引数が2つ以上あった場合にエラー終了する
     *
     * @param arguments コマンドライン引数
     */
    public void validateForOne(String[] arguments) {
        if (arguments.length >= 2) {
            new Printer().printError();
            System.exit(-1);
        }
    }

    /**
     * コマンドライン引数が複数のアプリケーションのための検証メソッド
     * 引数がなかった場合にエラー終了する
     *
     * @param arguments コマンドライン引数
     */
    public void validateForMany(String[] arguments) {
        if (arguments.length == 0) {
            new Printer().printError();
            System.exit(-1);
        }
    }

    /**
     * コマンドライン引数が複数のアプリケーションのための検証メソッド
     * 引数が指定された数と一致しなかった場合にエラー終了する
     *
     * @param arguments コマンドライン引数
     * @param length    検証したい引数の数
     */
    public void validateForMany(String[] arguments, Integer length) {
        if (arguments.length == length) {
            new Printer().printError();
            System.exit(-1);
        }
    }
}

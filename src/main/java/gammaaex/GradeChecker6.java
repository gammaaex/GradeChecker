package gammaaex;

import gammaaex.Analyzer.ExamAnalyzer;
import gammaaex.Entity.Exam;
import gammaaex.Printer.Printer;
import gammaaex.Analyzer.ArgumentAnalyzer;

import java.util.TreeMap;

/**
 * ステップ6に相当するクラス
 */
public class GradeChecker6 {

    /**
     * 問題を解くメソッド
     *
     * @param args 実行時引数
     */
    public void run(String[] args) {
        ArgumentAnalyzer argumentAnalyzer = new ArgumentAnalyzer(args[0], args[1], args[2]);
        ExamAnalyzer examAnalyzer = new ExamAnalyzer();
        TreeMap<Integer, Exam> examTreeMap = examAnalyzer.getExamMapFillId(argumentAnalyzer.getExam());

        Printer printer = new Printer();
        printer.printExam(examTreeMap);
    }

}
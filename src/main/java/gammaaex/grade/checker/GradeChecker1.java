package gammaaex.grade.checker;

import gammaaex.analyzer.ExamAnalyzer;
import gammaaex.entity.Exam;
import gammaaex.printer.ExamPrinter;
import gammaaex.analyzer.ArgumentAnalyzer;

import java.util.TreeMap;

/**
 * ステップ1に相当するクラス
 *
 * @see <a href="https://ksuap.github.io/2018spring/lesson14/assignments/#%E3%82%B9%E3%83%86%E3%83%83%E3%83%971">課題ページを参照</a>
 */
public class GradeChecker1 {

    /**
     * 問題を解くメソッド
     *
     * @param args 実行時引数
     */
    public void run(String[] args) {
        ArgumentAnalyzer argumentAnalyzer = new ArgumentAnalyzer(args[0], args[1], args[2]);
        ExamAnalyzer examAnalyzer = new ExamAnalyzer();
        TreeMap<Integer, Exam> examTreeMap = examAnalyzer.getExamMapFillId(argumentAnalyzer.getExam());

        ExamPrinter examPrinter = new ExamPrinter();
        examPrinter.print(examTreeMap);
    }

}
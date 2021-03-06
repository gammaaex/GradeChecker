package gammaaex.presentation.print;

import gammaaex.domain.model.entity.CalculatedScore;
import gammaaex.domain.model.entity.CalculatedScoreList;
import gammaaex.domain.model.type.Grade;

import java.util.List;

/**
 * CalculatedScoreの標準出力を司るクラス
 */
public class CalculatedScorePrinter extends Printer {

    /**
     * コンストラクタ
     */
    public CalculatedScorePrinter() {
        super();
    }

    /**
     * CalculatedScoreのデータを全て標準出力する
     *
     * @param calculatedScoreList CalculatedScoreのコレクション
     */
    public void printCalculatedScore(CalculatedScoreList calculatedScoreList) {
        calculatedScoreList.getCalculatedScoreList().forEach(calculatedScore -> {
            this.printAll(
                    calculatedScore.getIdentifier(),
                    calculatedScore.getFinalScore().getZeroOrScore(),
                    calculatedScore.getExamScore().getZeroOrScore(),
                    calculatedScore.getAssignmentsTotalScore().getZeroOrScore(),
                    calculatedScore.getMiniExamAdmissionRate().getZeroOrScore(),
                    calculatedScore.getGrade()
            );
        });
    }

    /**
     * 全ての情報を一度に出力する。
     * 表示内容：ID，最終成績，試験の点数，課題の合計点，小テストの受験回数，グレード
     *
     * @param id              識別子
     * @param finalScore      最終成績
     * @param examScore       試験の点数
     * @param assignmentScore 課題の合計点
     * @param admissionRate   小テストの受験回数
     * @param grade           グレード
     * @see <a href="https://ksuap.github.io/2018spring/lesson14/assignments/#2-b-実行例">出力仕様</a>
     */
    public void printAll(
            Integer id,
            Double finalScore,
            Double examScore,
            Double assignmentScore,
            Double admissionRate,
            Grade grade
    ) {
        System.out.printf("%d, %.1f, %.8f, %.4f, %f, %s\n",
                id,
                finalScore,
                examScore,
                assignmentScore,
                admissionRate,
                grade.getText()
        );
    }

    /**
     * 平均点を出力する。
     *
     * @param all          対象を全てとした場合の平均点
     * @param creditGetter 対象を単位取得者に限った場合の平均点
     */
    public void printAverage(Double all, Double creditGetter) {
        System.out.printf("Avg: %.4f (%.4f)\n", all, creditGetter);
    }

    /**
     * 最高点を出力する。
     *
     * @param all          対象を全てとした場合の最高点
     * @param creditGetter 対象を単位取得者に限った場合の最高点
     */
    public void printMaximize(Double all, Double creditGetter) {
        System.out.printf("Max: %.4f (%.4f)\n", all, creditGetter);
    }

    /**
     * 最低点を出力する。
     *
     * @param all          対象を全てとした場合の最低点
     * @param creditGetter 対象を単位取得者に限った場合の最低点
     */
    public void printMinimum(Double all, Double creditGetter) {
        System.out.printf("Min: %.4f (%.4f)\n", all, creditGetter);
    }

    /**
     * 成績の統計を出力する。
     *
     * @param gradeA {@code Grade.A} の数
     * @param gradeB {@code Grade.B} の数
     * @param gradeC {@code Grade.C} の数
     * @param gradeD {@code Grade.D} の数
     * @param gradeE {@code Grade.E} の数
     * @param gradeK {@code Grade.K} の数
     */
    public void printGradeStats(
            Integer gradeA,
            Integer gradeB,
            Integer gradeC,
            Integer gradeD,
            Integer gradeE,
            Integer gradeK
    ) {
        System.out.println(Grade.A.getText() + ":  " + gradeA);
        System.out.println(Grade.B.getText() + ":  " + gradeB);
        System.out.println(Grade.C.getText() + ":  " + gradeC);
        System.out.println(Grade.D.getText() + ":  " + gradeD);
        System.out.println(Grade.E.getText() + ":  " + gradeE);
        System.out.println(Grade.K.getText() + ":  " + gradeK);
    }

    /**
     * 成績の統計を出力する。
     *
     * @param gradeA {@code Grade.A} の数
     * @param gradeB {@code Grade.B} の数
     * @param gradeC {@code Grade.C} の数
     * @param gradeD {@code Grade.D} の数
     * @param gradeE {@code Grade.E} の数
     * @param gradeK {@code Grade.K} の数
     * @param gradeL {@code Grade.K} の数
     */
    public void printGradeStatsForAttendance(
            Integer gradeA,
            Integer gradeB,
            Integer gradeC,
            Integer gradeD,
            Integer gradeE,
            Integer gradeK,
            Integer gradeL
    ) {
        System.out.println(Grade.A.getText() + ":  " + gradeA);
        System.out.println(Grade.B.getText() + ":  " + gradeB);
        System.out.println(Grade.C.getText() + ":  " + gradeC);
        System.out.println(Grade.D.getText() + ":  " + gradeD);
        System.out.println(Grade.E.getText() + ":  " + gradeE);
        System.out.println(Grade.K.getText() + ":  " + gradeK);
        System.out.println(Grade.L.getText() + ":  " + gradeL);
    }
}

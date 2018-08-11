package gammaaex.presentation.print;

import gammaaex.domain.model.type.Grade;
import gammaaex.domain.model.value_object.CalculatedScore;

import java.util.TreeMap;

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
     * @param calculatedScoreMap CalculatedScoreのコレクション
     */
    public void printCalculatedScore(TreeMap<Integer, CalculatedScore> calculatedScoreMap) {
        calculatedScoreMap.forEach((index, calculatedScore) -> {
            this.printAll(
                    calculatedScore.getId(),
                    calculatedScore.getFinalScore(),
                    calculatedScore.getExamScore(),
                    calculatedScore.getAssignmentsTotalScore(),
                    calculatedScore.getMiniExamAdmissionRate(),
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
                finalScore != null ? finalScore : 0.0,
                examScore != null ? examScore : 0,
                assignmentScore,
                admissionRate,
                grade.getText()
        );
    }
}

package gammaaex.presentation.print;

import gammaaex.domain.model.value_object.Assignments;
import gammaaex.domain.model.value_object.Exam;
import gammaaex.domain.model.value_object.MiniExam;
import gammaaex.domain.model.value_object.ScoreSet;
import gammaaex.domain.service.AssignmentsService;
import gammaaex.domain.service.MiniExamService;
import gammaaex.domain.service.other.GradeCalculatingService;
import gammaaex.infrastructure.repository.AssignmentsRepository;
import gammaaex.infrastructure.repository.MiniExamRepository;

/**
 * 標準出力を司るクラス
 * 個別のPrinterクラスを実装する際はこのクラスを継承すること
 */
public class Printer {

    /**
     * ファイルが指定されていない場合のエラーメッセージ
     */
    public static final String ARGUMENT_NOT_FOUND = "ERROR: 試験の成績ファイルが指定されていません．";

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
     * Error文を出力する。
     */
    public void printError() {
        System.err.println(ARGUMENT_NOT_FOUND);
    }

    /**
     * 全ての情報を一度に出力する。
     * 表示内容：ID，最終成績，試験の点数，課題の合計点，小テストの受験回数，グレード
     *
     * @param scoreSet nullがないScoreSet
     */
    public void printAll(ScoreSet scoreSet) {
        Exam exam = scoreSet.getExam();
        Assignments assignments = scoreSet.getAssignments();
        MiniExam miniExam = scoreSet.getMiniExam();

        GradeCalculatingService gradeCalculatingService = new GradeCalculatingService();
        Double finalScore = gradeCalculatingService.calculateFinalScore(exam, assignments, miniExam);

        System.out.printf("%d, %f, %f, %d, %f, %s\n",
                exam.id,
                finalScore != null ? finalScore : 0.0,
                exam.point != null ? exam.point : 0,
                new AssignmentsService(new AssignmentsRepository()).calculateTotalScore(assignments),
                new MiniExamService(new MiniExamRepository()).calculateAdmissionRate(miniExam),
                gradeCalculatingService.convertPointToGrade(finalScore).getText()
        );
    }
}

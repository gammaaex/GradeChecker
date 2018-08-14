package gammaaex.application;

import gammaaex.domain.model.entity.Exam;
import gammaaex.domain.repository.ExamRepositoryInterface;
import gammaaex.domain.service.ArgumentValidatorService;
import gammaaex.domain.service.GradeCalculatingService;
import gammaaex.presentation.print.ExamPrinter;
import gammaaex.presentation.print.Printer;

import java.util.List;

/**
 * ステップ1に相当するクラス
 *
 * @see <a href="https://ksuap.github.io/2018spring/lesson14/assignments/#ステップ1">課題ページを参照</a>
 */
public class GradeChecker1 {

    /**
     * ExamのRepository
     */
    private final ExamRepositoryInterface examRepository;

    /**
     * コンストラクタ
     *
     * @param examRepository ExamのRepository
     */
    public GradeChecker1(
            ExamRepositoryInterface examRepository
    ) {
        this.examRepository = examRepository;
    }

    /**
     * 問題を解くメソッド
     *
     * @param arguments 実行時引数
     */
    public void run(String[] arguments) {
        if (!new ArgumentValidatorService().validateForOne(arguments)) {
            new Printer().printErrorByArgumentNotFound("java GradeChecker1 <EXAM.CSV>");
            return;
        }

        List<Exam> examList = this.examRepository.findAllByFillId();
        GradeCalculatingService gradeCalculatingService = new GradeCalculatingService();
        ExamPrinter examPrinter = new ExamPrinter();

        examList.forEach(exam -> {
            examPrinter.print(exam, gradeCalculatingService.convertPointToGrade(exam.getDetailScore().getNullOrScore()));
        });
    }
}
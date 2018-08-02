package gammaaex.analyzer;


import gammaaex.Main;

import java.nio.file.Path;
import java.nio.file.Paths;

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

    /**
     * コンストラクタ
     *
     * @param examFileName exam.csvに相当するファイルのファイル名
     * @param assignmentsFileName assignments.csvに相当するファイルのファイル名
     * @param miniExamFileName miniExam.csvに相当するファイルのファイル名
     */
    public ArgumentAnalyzer(String examFileName, String assignmentsFileName, String miniExamFileName) {
        this.setExam(this.getResource(examFileName));
        this.setAssignments(this.getResource(assignmentsFileName));
        this.setMiniExam(this.getResource(miniExamFileName));
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
     * @param fileName resource file name.
     * @return get resource path.
     */
    public Path getResource(String fileName) {
        return Paths.get(Main.class.getResource(fileName).getPath());
    }
}

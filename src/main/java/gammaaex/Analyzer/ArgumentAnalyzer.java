package gammaaex.Analyzer;


import gammaaex.Main;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ArgumentAnalyzer {
    private Path assignments;
    private Path exam;
    private Path miniExam;

    public ArgumentAnalyzer(String assignmentsFileName, String examFileName, String miniExamFileName) {
        this.setAssignments(this.getResource(assignmentsFileName));
        this.setExam(this.getResource(examFileName));
        this.setMiniExam(this.getResource(miniExamFileName));
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

package gammaaex.Analyzer;

import gammaaex.Entity.Exam;

import java.nio.file.Path;
import java.util.List;
import java.util.TreeMap;

public class ExamAnalyzer extends FileAnalyzer {

    public ExamAnalyzer() {

    }

    public TreeMap<Integer, Exam> getExamMapFillId(Path path) {
        TreeMap<Integer, Exam> treeMap = this.getExamMap(path);

        for (Integer index = treeMap.firstKey(); index <= treeMap.size(); index++) {
            if (treeMap.containsKey(index)) continue;

            treeMap.put(index, new Exam(index, null));
        }

        return treeMap;
    }

    public TreeMap<Integer, Exam> getExamMap(Path path) {
        TreeMap<Integer, Exam> treeMap = new TreeMap<>();

        List<String> lines = this.fileToList(path);

        for (String line : lines) {
            String[] examArray = parseCSVLine(line);
            Exam exam = new Exam(Integer.parseInt(examArray[0]), Double.parseDouble(examArray[1]));

            treeMap.put(exam.id, exam);
        }

        return treeMap;
    }
}

package gammaaex.Analyzer;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FileAnalyzer {

    public FileAnalyzer() {

    }

    public String[] parseCSVLine(String line) {
        return line.split(",");
    }

    public List<String> fileToList(Path path) {
        List<String> list = null;

        try {
            list = Files.lines(path, StandardCharsets.UTF_8).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (list == null) throw new NullPointerException();

        return list;
    }
}

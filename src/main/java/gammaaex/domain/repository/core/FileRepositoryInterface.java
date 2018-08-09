package gammaaex.domain.repository.core;

import java.nio.file.Path;
import java.util.List;

public interface FileRepositoryInterface extends Repository {
    String[] parseCSVLine(String line);

    List<String> fileToList(Path path);

    Path getResource(String fileName);
}

package gammaaex.presentation.renderer;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class File implements RendererInterface {

    private Path outFile;

    public File(String path) {
        try {
            this.outFile = Files.createFile(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void render(String text) {
        try {
            Files.write(this.outFile, text.getBytes(Charset.forName("UTF-8")),
                    StandardOpenOption.WRITE,
                    StandardOpenOption.TRUNCATE_EXISTING
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

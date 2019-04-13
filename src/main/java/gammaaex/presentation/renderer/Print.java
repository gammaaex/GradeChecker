package gammaaex.presentation.renderer;

public class Print implements RendererInterface {
    @Override
    public void render(String text) {
        System.out.println(text);
    }
}

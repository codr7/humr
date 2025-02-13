package codr7.humr.html;

public record Text(String content) implements Node {
    @Override
    public void writeHtml(final StringBuilder out) {
        out.append(content);
    }
}

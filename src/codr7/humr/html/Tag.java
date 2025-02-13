package codr7.humr.html;

import java.util.stream.Stream;

public interface Tag extends Node {
    interface Attribute {
        record Value(Attribute type, Object value) {
            public void writeHtml(StringBuilder out) {
                type.writeHtml(value, out);
            }
        }

        void writeHtml(Object value, StringBuilder out);
    }

    Stream<Attribute.Value> attributes();
    Stream<Node> childNodes();
    boolean hasChildNodes();
    String tagName();

    @Override
    default void writeHtml(final StringBuilder out) {
        out.append('<').append(tagName());

        attributes().forEach(a -> {
            out.append(' ');
            a.writeHtml(out);
        });

        if (hasChildNodes()) {
            out.append('>');

            childNodes().forEach(n -> {
                n.writeHtml(out);
            });

            out.append("</").append(tagName()).append('>');
        }
    }
}

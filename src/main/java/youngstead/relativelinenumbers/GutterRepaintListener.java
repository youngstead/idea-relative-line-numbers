package youngstead.relativelinenumbers;

import com.intellij.openapi.editor.event.CaretEvent;
import com.intellij.openapi.editor.event.CaretListener;
import com.intellij.openapi.editor.ex.EditorGutterComponentEx;
import org.jetbrains.annotations.NotNull;

/**
 * Listens to caret movement to repaint the gutter when the caret has moves between lines.
 */
public class GutterRepaintListener implements CaretListener {

    @Override
    public void caretPositionChanged(@NotNull CaretEvent event) {
        if (didCaretChangeLines(event)) {
            EditorGutterComponentEx gutter = (EditorGutterComponentEx) event
                .getEditor()
                .getGutter();
            gutter.repaint();
        }
    }

    private boolean didCaretChangeLines(@NotNull CaretEvent event) {
        return getNewLine(event) != getOldLine(event);
    }

    private int getNewLine(CaretEvent event) {
        return event.getNewPosition().line;
    }

    private int getOldLine(CaretEvent event) {
        return event.getOldPosition().line;
    }
}

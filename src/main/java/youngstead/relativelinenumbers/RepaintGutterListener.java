package youngstead.relativelinenumbers;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.editor.event.CaretEvent;
import com.intellij.openapi.editor.event.CaretListener;
import com.intellij.openapi.editor.ex.EditorGutterComponentEx;
import org.jetbrains.annotations.NotNull;

/**
 * Listens to caret movement to repaint the gutter when the caret has moves between lines.
 */
public class RepaintGutterListener implements CaretListener {

    final Logger logger = Logger.getInstance(RepaintGutterListener.class);

    @Override
    public void caretPositionChanged(@NotNull CaretEvent event) {
        if (didCaretChangeLines(event)) {
            try {
                EditorGutterComponentEx gutter = (EditorGutterComponentEx) event
                    .getEditor()
                    .getGutter();
                gutter.repaint();
            } catch (Exception e) {
                logger.debug("Could not refresh gutter. Unknown gutter implementation.", e);
            }
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

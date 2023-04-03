package youngstead.relativelinenumbers;

import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.LineNumberConverter;
import com.intellij.openapi.editor.event.CaretListener;
import com.intellij.openapi.editor.event.EditorFactoryEvent;
import com.intellij.openapi.editor.event.EditorFactoryListener;
import org.jetbrains.annotations.NotNull;

/**
 * Listens to Editor creation to show relative numbers in the editor's gutter.
 */
public class EditorFactoryListenerImpl implements EditorFactoryListener {

    private final CaretListener repaintGutterCaretListener = new RepaintGutterListener();

    private final LineNumberConverter relativeLineNumberConverter = new RelativeLineNumberConverter();

    @Override
    public void editorCreated(@NotNull EditorFactoryEvent event) {
        Editor editor = event.getEditor();
        setRelativeLineNumberConverter(editor);
        setRepaintGutterListener(editor);
    }

    private void setRepaintGutterListener(Editor editor) {
        editor
            .getCaretModel()
            .addCaretListener(repaintGutterCaretListener);
    }

    public void setRelativeLineNumberConverter(Editor editor) {
        editor
            .getGutter()
            .setLineNumberConverter(LineNumberConverter.DEFAULT, relativeLineNumberConverter);
    }
}

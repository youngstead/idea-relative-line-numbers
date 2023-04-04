package youngstead.relativelinenumbers;

import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.LineNumberConverter;
import com.intellij.openapi.editor.event.CaretListener;
import com.intellij.openapi.editor.event.EditorFactoryEvent;
import com.intellij.openapi.editor.event.EditorFactoryListener;
import com.intellij.openapi.editor.ex.EditorGutterComponentEx;
import org.jetbrains.annotations.NotNull;
import youngstead.relativelinenumbers.settings.AppSettings;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashSet;
import java.util.Set;

/**
 * Listens to Editor creation and settings updates to display the desired Line Numbers in the Gutter.
 */
public class EditorListener implements EditorFactoryListener, PropertyChangeListener {

    private final CaretListener repaintGutterCaretListener = new GutterRepaintListener();

    private final LineNumberConverter relativeLineNumberConverter = new RelativeLineNumberConverter();

    private final Set<Editor> openEditors = new HashSet<>();

    public EditorListener() {
        AppSettings appSettings = AppSettings.getInstance();
        appSettings.registerListener("displayAbsoluteLineNumbers", this);
    }

    @Override
    public void editorCreated(@NotNull EditorFactoryEvent event) {
        Editor editor = event.getEditor();
        openEditors.add(editor);
        setRelativeLineNumberConverter(editor);
        setRelativeNumbersRepaintListener(editor);
    }

    @Override
    public void editorReleased(@NotNull EditorFactoryEvent event) {
        openEditors.remove(event.getEditor());
    }


    private void setRelativeNumbersRepaintListener(Editor editor) {
        editor
            .getCaretModel()
            .addCaretListener(repaintGutterCaretListener);
    }

    public void setRelativeLineNumberConverter(Editor editor) {
        AppSettings appSettings = AppSettings.getInstance();
        EditorGutterComponentEx editorGutter = (EditorGutterComponentEx) editor.getGutter();
        if (appSettings.shouldDisplayAbsoluteLineNumbers()) {
            editorGutter.setLineNumberConverter(LineNumberConverter.DEFAULT, relativeLineNumberConverter);
        } else {
            editorGutter.setLineNumberConverter(relativeLineNumberConverter);
        }
        editorGutter.repaint();
    }

    @Override
    public void propertyChange(PropertyChangeEvent propChangeEvent) {
        for (Editor editor : openEditors) {
            setRelativeLineNumberConverter(editor);
        }
    }
}

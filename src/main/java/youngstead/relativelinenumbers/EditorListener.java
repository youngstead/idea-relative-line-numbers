package youngstead.relativelinenumbers;

import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.LineNumberConverter;
import com.intellij.openapi.editor.event.CaretListener;
import com.intellij.openapi.editor.event.EditorFactoryEvent;
import com.intellij.openapi.editor.event.EditorFactoryListener;
import com.intellij.openapi.editor.ex.EditorEx;
import com.intellij.openapi.editor.ex.EditorGutterComponentEx;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileEditor.TextEditor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import org.jetbrains.annotations.NotNull;
import youngstead.relativelinenumbers.settings.ApplicationSettings;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Listens to Editor creation and settings update to display the correct Line Numbers in the Gutter.
 */
public class EditorListener implements EditorFactoryListener, PropertyChangeListener {

    private final CaretListener repaintGutterCaretListener = new GutterRepaintListener();

    private final LineNumberConverter relativeLineNumberConverter = new RelativeLineNumberConverter();

    public EditorListener() {
        ApplicationSettings appSettings = ApplicationSettings.getInstance();
        appSettings.registerListener("displayAbsoluteLineNumbers", this);
    }

    @Override
    public void editorCreated(@NotNull EditorFactoryEvent event) {
        EditorEx editor = (EditorEx) event.getEditor();
        setLineNumberConverter(editor);
        setCaretListener(editor);
    }

    private void setCaretListener(Editor editor) {
        editor
            .getCaretModel()
            .addCaretListener(repaintGutterCaretListener);
    }

    public void setLineNumberConverter(EditorEx editor) {
        ApplicationSettings appSettings = ApplicationSettings.getInstance();
        EditorGutterComponentEx editorGutter = editor.getGutterComponentEx();
        if (appSettings.shouldDisplayAbsoluteLineNumbers()) {
            editorGutter.setLineNumberConverter(LineNumberConverter.DEFAULT, relativeLineNumberConverter);
        } else {
            editorGutter.setLineNumberConverter(relativeLineNumberConverter);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent propChangeEvent) {
        ProjectManager projectManager = ProjectManager.getInstance();
        Project[] openProjects = projectManager.getOpenProjects();
        for (Project project : openProjects) {
            FileEditorManager editorManager = FileEditorManager.getInstance(project);
            FileEditor[] fileEditors = editorManager.getAllEditors();
            for (FileEditor fileEditor : fileEditors) {
                if (fileEditor instanceof TextEditor textEditor) {
                    EditorEx editorEx = (EditorEx) textEditor.getEditor();
                    setLineNumberConverter(editorEx);
                    editorEx.reinitSettings();
                }
            }
        }
    }
}

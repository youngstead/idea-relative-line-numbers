package youngstead.relativelinenumbers;

import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.event.CaretListener;
import com.intellij.openapi.editor.event.EditorFactoryEvent;
import com.intellij.openapi.editor.event.EditorFactoryListener;
import org.jetbrains.annotations.NotNull;

public class EditorFactoryListenerImpl implements EditorFactoryListener {

	private final CaretListener caretListener = new RelativeLineNumbersConverterInjector();

	@Override
	public void editorCreated(@NotNull EditorFactoryEvent event) {
		Editor editor = event.getEditor();
		editor.getCaretModel().addCaretListener(caretListener);
	}
}

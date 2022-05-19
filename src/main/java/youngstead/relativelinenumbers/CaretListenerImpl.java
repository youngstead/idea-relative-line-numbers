package youngstead.relativelinenumbers;

import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.EditorGutter;
import com.intellij.openapi.editor.event.CaretEvent;
import com.intellij.openapi.editor.event.CaretListener;

public class CaretListenerImpl implements CaretListener {

	public void caretPositionChanged(CaretEvent caretEvent) {
		Editor editor = caretEvent.getEditor();
		EditorGutter gutter = editor.getGutter();
		gutter.closeAllAnnotations();
		gutter.registerTextAnnotation(new RelativeLineNumbersGutter());
	}
}

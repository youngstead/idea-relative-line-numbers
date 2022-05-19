package youngstead.relativelinenumbers;

import com.intellij.openapi.editor.EditorGutter;
import com.intellij.openapi.editor.LineNumberConverter;
import com.intellij.openapi.editor.event.CaretEvent;
import com.intellij.openapi.editor.event.CaretListener;
import org.jetbrains.annotations.NotNull;

public class RelativeLineNumbersConverterInjector implements CaretListener {

	private final LineNumberConverter relativeLineNumbersConverter
			= new RelativeLineNumbersConverter();

	@Override
	public void caretPositionChanged(@NotNull CaretEvent event) {
		EditorGutter gutter = event.getEditor().getGutter();
		// Reset the lineConverter to trigger a repaint.
		gutter.setLineNumberConverter(relativeLineNumbersConverter);
	}
}

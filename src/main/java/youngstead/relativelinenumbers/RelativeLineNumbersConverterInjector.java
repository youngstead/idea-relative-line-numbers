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
		if (this.didCaretChangeLines(event)) {
			// Reset the lineConverter to trigger a repaint.
			event.getEditor()
					.getGutter()
					.setLineNumberConverter(relativeLineNumbersConverter);
		}
	}
	private boolean didCaretChangeLines(@NotNull CaretEvent event) {
		return this.getNewLine(event) != this.getOldLine(event);
	}

	private int getNewLine(CaretEvent event) {
		return event.getNewPosition().line;
	}

	private int getOldLine(CaretEvent event) {
		return event.getOldPosition().line;
	}
}

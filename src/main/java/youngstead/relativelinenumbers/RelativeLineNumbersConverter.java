package youngstead.relativelinenumbers;

import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.LineNumberConverter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RelativeLineNumbersConverter implements LineNumberConverter {

	@Override
	public @Nullable Integer convert(@NotNull Editor editor, int lineNumber) {
		CaretModel caret = editor.getCaretModel();
		return this.isCaretInLine(caret, lineNumber)
				? lineNumber
				: this.getRelativeLineNumber(caret, lineNumber);
	}

	private int getCaretLine(CaretModel caret) {
		return caret.getLogicalPosition().line + 1;
	}

	private boolean isCaretInLine(CaretModel caret, int lineNumber) {
		return this.getCaretLine(caret) == lineNumber;
	}

	private int getRelativeLineNumber(CaretModel caret, int lineNumber) {
		return Math.abs(this.getCaretLine(caret) - lineNumber);
	}

	@Override
	public @Nullable Integer getMaxLineNumber(@NotNull Editor editor) {
		return LineNumberConverter.DEFAULT.getMaxLineNumber(editor);
	}
}

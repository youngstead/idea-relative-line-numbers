package youngstead.relativelinenumbers;

import com.intellij.openapi.editor.Editor;
import org.jetbrains.annotations.Nullable;

public class RelativeLineNumbersGutter implements DefaultTextAnnotationGutterProvider {

	@Override
	@Nullable
	public String getLineText(int line, Editor editor) {
		return this.isCaretInLine(line, editor)
				? this.getLineNumberText(line)
				: this.getRelativeLineNumberText(line, editor);
	}

	private boolean isCaretInLine(int line, Editor editor) {
		int caretLine = this.getCaretLine(editor);
		return caretLine - line == 0;
	}

	private int getCaretLine(Editor editor) {
		return editor.getCaretModel().getLogicalPosition().line;
	}

	private String getLineNumberText(int line) {
		return Integer.toString(line + 1);
	}

	private String getRelativeLineNumberText(int line, Editor editor) {
		int currentLine = this.getCaretLine(editor);
		int lineDiff = Math.abs(currentLine - line);
		return Integer.toString(lineDiff);
	}
}

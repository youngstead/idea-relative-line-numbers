package youngstead.relativelinenumbers;

import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.LineNumberConverter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Converts line numbers to numbers relative to the caret's position.
 */
public class RelativeLineNumberConverter implements LineNumberConverter {

    @Override
    public @Nullable Integer convert(@NotNull Editor editor, int lineNumber) {
        CaretModel caret = editor.getCaretModel();
        return isCaretInLine(caret, lineNumber)
            ? lineNumber
            : getRelativeLineNumber(caret, lineNumber);
    }

    private boolean isCaretInLine(CaretModel caret, int lineNumber) {
        return getCaretLine(caret) == lineNumber;
    }

    private int getCaretLine(CaretModel caret) {
        return caret.getLogicalPosition().line + 1;
    }

    private int getRelativeLineNumber(CaretModel caret, int lineNumber) {
        return Math.abs(getCaretLine(caret) - lineNumber);
    }

    @Override
    public @Nullable Integer getMaxLineNumber(@NotNull Editor editor) {
        return LineNumberConverter.DEFAULT.getMaxLineNumber(editor);
    }
}

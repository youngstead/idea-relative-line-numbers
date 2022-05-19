package youngstead.relativelinenumbers;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.TextAnnotationGutterProvider;
import com.intellij.openapi.editor.colors.ColorKey;
import com.intellij.openapi.editor.colors.EditorFontType;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.List;

public interface DefaultTextAnnotationGutterProvider extends TextAnnotationGutterProvider {
	@Override
	@Nullable
	default String getLineText(int line, Editor editor) {
		return null;
	}

	@Override
	@Nullable
	default String getToolTip(int line, Editor editor) {
		return null;
	}

	@Override
	default EditorFontType getStyle(int line, Editor editor) {
		return null;
	}

	@Override
	@Nullable
	default ColorKey getColor(int line, Editor editor) {
		return null;
	}

	@Override
	@Nullable
	default Color getBgColor(int line, Editor editor) {
		return null;
	}

	@Override
	default List<AnAction> getPopupActions(int line, Editor editor) {
		return null;
	}

	@Override
	default void gutterClosed() {}

}

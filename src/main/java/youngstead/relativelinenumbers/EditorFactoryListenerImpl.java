package youngstead.relativelinenumbers;

import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.EditorGutter;
import com.intellij.openapi.editor.event.EditorFactoryEvent;
import com.intellij.openapi.editor.event.EditorFactoryListener;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.testFramework.LightVirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class EditorFactoryListenerImpl implements EditorFactoryListener {

	@Override
	public void editorCreated(@NotNull EditorFactoryEvent event) {
		Editor editor = event.getEditor();
		if (this.isFileEditor(editor)) {
			EditorGutter gutter = editor.getGutter();
			gutter.registerTextAnnotation(new RelativeLineNumbersGutter());
		}
	}

	private boolean isFileEditor(@NotNull Editor editor) {
		VirtualFile virtualFile = getVirtualFile(editor);
		return virtualFile != null && !(virtualFile instanceof LightVirtualFile);
	}

	@Nullable
	private static VirtualFile getVirtualFile(@NotNull Editor editor) {
		return FileDocumentManager.getInstance().getFile(editor.getDocument());
	}

	@Override
	public void editorReleased(@NotNull EditorFactoryEvent event) {
		EditorFactoryListener.super.editorReleased(event);
	}
}

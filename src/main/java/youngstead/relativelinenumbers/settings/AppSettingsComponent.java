package youngstead.relativelinenumbers.settings;

import com.intellij.ui.components.JBCheckBox;
import com.intellij.util.ui.FormBuilder;

import javax.swing.*;

public class AppSettingsComponent {
    private final JBCheckBox absLineNumbersOption = new JBCheckBox("Show absolute numbers");

    public JPanel buildPanel() {
        return FormBuilder.createFormBuilder()
            .addComponent(absLineNumbersOption, 1)
            .addComponentFillVertically(new JPanel(), 0)
            .getPanel();
    }

    public boolean getAbsLineNumbersStatus() {
        return absLineNumbersOption.isSelected();
    }

    public void setAbsLineNumbersOption(boolean enabled) {
        absLineNumbersOption.setSelected(enabled);
    }
}

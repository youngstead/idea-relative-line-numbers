package youngstead.relativelinenumbers.settings;

import com.intellij.ui.components.JBCheckBox;
import com.intellij.util.ui.FormBuilder;

import javax.swing.*;

public class SettingsPanel {
    private final JBCheckBox absLineNumbersOption = new JBCheckBox("Show absolute numbers");

    public JPanel build() {
        return FormBuilder.createFormBuilder()
            .addComponent(absLineNumbersOption, 1)
            .addComponentFillVertically(new JPanel(), 0)
            .getPanel();
    }

    public boolean getDisplayAbsoluteLineNumbersOption() {
        return absLineNumbersOption.isSelected();
    }

    public void setDisplayAbsoluteLineNumbersOption(boolean enabled) {
        absLineNumbersOption.setSelected(enabled);
    }
}

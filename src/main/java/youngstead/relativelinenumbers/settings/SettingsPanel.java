package youngstead.relativelinenumbers.settings;

import com.intellij.ui.components.JBCheckBox;
import com.intellij.util.ui.FormBuilder;

import javax.swing.*;

public class SettingsPanel {
    private final JBCheckBox absoluteLineNumbersOption = new JBCheckBox("Absolute values");

    public JPanel build() {
        JBCheckBox relativeLineNumbersOption = new JBCheckBox("Relative values");
        relativeLineNumbersOption.setSelected(true);
        // TODO: add option to disable relative numbers
        relativeLineNumbersOption.setEnabled(false);

        return FormBuilder.createFormBuilder()
            .addComponent(relativeLineNumbersOption, 0)
            .addComponent(absoluteLineNumbersOption, 0)
            .addComponentFillVertically(new JPanel(), 0)
            .getPanel();
    }

    public boolean getDisplayAbsoluteLineNumbersOption() {
        return absoluteLineNumbersOption.isSelected();
    }

    public void setDisplayAbsoluteLineNumbersOption(boolean enabled) {
        absoluteLineNumbersOption.setSelected(enabled);
    }
}

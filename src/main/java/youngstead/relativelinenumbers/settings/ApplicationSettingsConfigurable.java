package youngstead.relativelinenumbers.settings;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.util.NlsContexts;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class ApplicationSettingsConfigurable implements Configurable {

    private SettingsPanel settingsPanel;

    @Override
    public @NlsContexts.ConfigurableName String getDisplayName() {
        return "Line Numbers Settings";
    }

    @Override
    public @Nullable JComponent createComponent() {
        settingsPanel = new SettingsPanel();
        return settingsPanel.build();
    }

    @Override
    public boolean isModified() {
        AppSettings appSettings = AppSettings.getInstance();
        return settingsPanel.getDisplayAbsoluteLineNumbersOption() != appSettings.shouldDisplayAbsoluteLineNumbers();
    }

    @Override
    public void apply() {
        AppSettings appSettings = AppSettings.getInstance();
        appSettings.setDisplayAbsoluteLineNumbers(settingsPanel.getDisplayAbsoluteLineNumbersOption());
    }

    @Override
    public void reset() {
        AppSettings appSettings = AppSettings.getInstance();
        settingsPanel.setDisplayAbsoluteLineNumbersOption(appSettings.shouldDisplayAbsoluteLineNumbers());
    }
}

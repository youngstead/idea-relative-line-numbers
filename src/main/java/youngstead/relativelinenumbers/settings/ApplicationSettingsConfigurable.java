package youngstead.relativelinenumbers.settings;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.util.NlsContexts;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Interacts with IntelliJ's platform to manage settings interactions.
 */
public class ApplicationSettingsConfigurable implements Configurable {

    private SettingsPanel settingsPanel;

    @Override
    public @NlsContexts.ConfigurableName String getDisplayName() {
        return "Line Numbers";
    }

    @Override
    public @Nullable JComponent createComponent() {
        settingsPanel = new SettingsPanel();
        return settingsPanel.build();
    }

    @Override
    public boolean isModified() {
        ApplicationSettings appSettings = ApplicationSettings.getInstance();
        return settingsPanel.getDisplayAbsoluteLineNumbersOption() != appSettings.shouldDisplayAbsoluteLineNumbers();
    }

    @Override
    public void apply() {
        ApplicationSettings appSettings = ApplicationSettings.getInstance();
        appSettings.setDisplayAbsoluteLineNumbers(settingsPanel.getDisplayAbsoluteLineNumbersOption());
    }

    @Override
    public void reset() {
        ApplicationSettings appSettings = ApplicationSettings.getInstance();
        settingsPanel.setDisplayAbsoluteLineNumbersOption(appSettings.shouldDisplayAbsoluteLineNumbers());
    }
}

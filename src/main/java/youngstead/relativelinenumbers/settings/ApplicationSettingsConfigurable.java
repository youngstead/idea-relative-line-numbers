package youngstead.relativelinenumbers.settings;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.util.NlsContexts;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class ApplicationSettingsConfigurable implements Configurable {

    private AppSettingsComponent settingsComponent;


    @Override
    public @NlsContexts.ConfigurableName String getDisplayName() {
        return "Line Number Settings";
    }

    @Override
    public @Nullable JComponent createComponent() {
        settingsComponent = new AppSettingsComponent();
        return settingsComponent.buildPanel();
    }

    @Override
    public boolean isModified() {
        AppSettingsState settings = AppSettingsState.getInstance();
        return settingsComponent.getAbsLineNumbersStatus() != settings.absLineNumbersEnabled;
    }

    @Override
    public void apply() throws ConfigurationException {
        AppSettingsState settings = AppSettingsState.getInstance();
        settings.absLineNumbersEnabled = settingsComponent.getAbsLineNumbersStatus();
    }

    @Override
    public void reset() {
        AppSettingsState settings = AppSettingsState.getInstance();
        settingsComponent.setAbsLineNumbersOption(settings.absLineNumbersEnabled);
    }
}

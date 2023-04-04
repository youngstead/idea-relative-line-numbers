package youngstead.relativelinenumbers.settings;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Persists the plugin settings on an Application level.
 */
@State(
    name = "youngstead.relativelinenumbers.settings.ApplicationSettings",
    storages = @Storage("RelativeLineNumbersPlugin.xml")
)
public class ApplicationSettings implements PersistentStateComponent<ApplicationSettings> {

    private final PropertyChangeSupport propChangeSupport = new PropertyChangeSupport(this);

    private boolean displayAbsoluteLineNumbers = false;

    public static ApplicationSettings getInstance() {
        return ApplicationManager.getApplication()
            .getService(ApplicationSettings.class);
    }

    @Nullable
    @Override
    public ApplicationSettings getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull ApplicationSettings state) {
        XmlSerializerUtil.copyBean(state, this);
    }

    public boolean shouldDisplayAbsoluteLineNumbers() {
        return displayAbsoluteLineNumbers;
    }

    public void setDisplayAbsoluteLineNumbers(boolean displayAbsoluteLineNumbers) {
        boolean oldValue = this.displayAbsoluteLineNumbers;
        this.displayAbsoluteLineNumbers = displayAbsoluteLineNumbers;
        propChangeSupport.firePropertyChange("displayAbsoluteLineNumbers", oldValue, displayAbsoluteLineNumbers);
    }

    public void registerListener(String propertyName, PropertyChangeListener changeListener) {
        propChangeSupport.addPropertyChangeListener(propertyName, changeListener);
    }
}

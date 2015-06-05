package pl.theboxingnights.app.start;

import com.jme3.app.SimpleApplication;
import pl.theboxingnights.app.settings.DisplaySettings;

import java.util.prefs.BackingStoreException;

/**
 * Created by filip on 05.06.15.
 */
public class Start extends SimpleApplication {

    public Start () throws BackingStoreException {
        initDisplaySettings();
    }

    public static void main (String [] args) throws BackingStoreException {
        Start app = new Start();
        app.start();
    }

    private void initDisplaySettings() throws BackingStoreException {
        DisplaySettings displaySettings = new DisplaySettings(this);
        displaySettings.load();
        displaySettings.getSettings();
        displaySettings.save();
        displaySettings.setSettings();
    }


    @Override
    public void simpleInitApp() {

    }

}

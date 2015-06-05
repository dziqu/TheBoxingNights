package pl.theboxingnights.app.settings;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by filip / 05.06.15 / 10:13
 */
public class DisplaySettingsTest extends AbstractAppState {

    private SimpleApplication application;

    @Override
    public void initialize(AppStateManager appStateManager, Application application) {
        super.initialize(appStateManager, application);
        this.setApplication((SimpleApplication) application);

    }

    private DisplaySettings getDisplaySettings() {
        return new DisplaySettings(getApplication());
    }


    @Test
    public void testGetApp() throws Exception {
        assertNotNull(getDisplaySettings().getApp());
    }

    @Test
    public void testGetAppSettings() throws Exception {
        assertNotNull(getDisplaySettings().getAppSettings());
    }

    @Test
    public void testGetRenderer() throws Exception {
        assertNotNull(getDisplaySettings().getRenderer());
    }

    @Test
    public void testSetRenderer() throws Exception {

    }

    @Test
    public void testGetColorDepth() throws Exception {

    }

    @Test
    public void testSetColorDepth() throws Exception {

    }

    @Test
    public void testGetFrames() throws Exception {

    }

    @Test
    public void testSetFrames() throws Exception {

    }

    @Test
    public void testIsFullScreen() throws Exception {

    }

    @Test
    public void testSetFullScreen() throws Exception {

    }

    @Test
    public void testGetHeight() throws Exception {

    }

    @Test
    public void testSetHeight() throws Exception {

    }

    @Test
    public void testGetWidth() throws Exception {

    }

    @Test
    public void testSetWidth() throws Exception {

    }

    @Test
    public void testGetSamples() throws Exception {

    }

    @Test
    public void testSetSamples() throws Exception {

    }

    @Test
    public void testIsvSync() throws Exception {

    }

    @Test
    public void testSetvSync() throws Exception {

    }

    @Test
    public void testGetFrequency() throws Exception {

    }

    @Test
    public void testSetFrequency() throws Exception {

    }

    @Test
    public void testGetStencilBits() throws Exception {

    }

    @Test
    public void testSetStencilBits() throws Exception {

    }

    @Test
    public void testGetDepthBits() throws Exception {

    }

    @Test
    public void testSetDepthBits() throws Exception {

    }

    @Test
    public void testGetSettings() throws Exception {

    }

    @Test
    public void testSetSettings() throws Exception {

    }

    @Test
    public void testSave() throws Exception {

    }

    @Test
    public void testLoad() throws Exception {

    }

    public SimpleApplication getApplication() {
        return application;
    }

    public void setApplication(SimpleApplication application) {
        this.application = application;
    }
}
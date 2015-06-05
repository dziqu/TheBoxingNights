package pl.theboxingnights.app.settings;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.system.AppSettings;

import java.util.prefs.BackingStoreException;

/**
 * Created by filip on 05.06.15.
 */
public class DisplaySettings {

    private final SimpleApplication app;
    private AppSettings appSettings = null;
    private String renderer = AppSettings.LWJGL_OPENGL2;
    private int colorDepth = 32;
    private int frames = 60;
    private boolean fullScreen = false;
    private int height = 768;
    private int width = 1024;
    private int samples = 4;
    private boolean vSync = false;
    private int frequency = 60;
    private int stencilBits = 8;
    private int depthBits = 16;

    private final String pathToSettings = "pl.theboxingnights.displaySettings";
    private final String title = "The Boxing Nights";

    public DisplaySettings(Application app) {
        this.app = (SimpleApplication) app;
        if (isAppSettingsNull()) {
            appSettings = new AppSettings(true);
        }
    }

    private boolean isAppSettingsNull() {
        boolean isAppSettingsNull = true;
        if (!(appSettings == null)) {
            isAppSettingsNull = false;
        }
        return isAppSettingsNull;
    }

    public SimpleApplication getApp() {
        return app;
    }

    public AppSettings getAppSettings() {
        return appSettings;
    }

    public String getRenderer() {
        return renderer;
    }

    public void setRenderer(String renderer) {
        this.renderer = renderer;
    }

    public int getColorDepth() {
        return colorDepth;
    }

    public void setColorDepth(int colorDepth) {
        this.colorDepth = colorDepth;
    }

    public int getFrames() {
        return frames;
    }

    public void setFrames(int frames) {
        this.frames = frames;
    }

    public boolean isFullScreen() {
        return fullScreen;
    }

    public void setFullScreen(boolean fullScreen) {
        this.fullScreen = fullScreen;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getSamples() {
        return samples;
    }

    public void setSamples(int samples) {
        this.samples = samples;
    }

    public boolean isvSync() {
        return vSync;
    }

    public void setvSync(boolean vSync) {
        this.vSync = vSync;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getStencilBits() {
        return stencilBits;
    }

    public void setStencilBits(int stencilBits) {
        this.stencilBits = stencilBits;
    }

    public int getDepthBits() {
        return depthBits;
    }

    public void setDepthBits(int depthBits) {
        this.depthBits = depthBits;
    }

    public void getSettings() {
        renderer = appSettings.getRenderer();
        colorDepth = appSettings.getBitsPerPixel();
        frames = appSettings.getFrameRate();
        height = appSettings.getHeight();
        width = appSettings.getWidth();
        samples = appSettings.getSamples();
        frequency = appSettings.getFrequency();
        stencilBits = appSettings.getStencilBits();
        depthBits = appSettings.getDepthBits();
    }

    public void setSettings() {
        appSettings.setRenderer(renderer);
        appSettings.setBitsPerPixel(colorDepth);
        appSettings.setFrameRate(frames);
        appSettings.setFullscreen(fullScreen);
        appSettings.setHeight(height);
        appSettings.setWidth(width);
        appSettings.setSamples(samples);
        appSettings.setVSync(vSync);
        appSettings.setFrequency(frequency);
        appSettings.setStencilBits(stencilBits);
        appSettings.setDepthBits(depthBits);
        appSettings.setTitle("The Boxing Nights");
        app.setSettings(appSettings);
    }

    public void save() throws BackingStoreException {
        appSettings.save(pathToSettings);
    }

    public void load() throws BackingStoreException {
        appSettings.load(pathToSettings);
    }
}

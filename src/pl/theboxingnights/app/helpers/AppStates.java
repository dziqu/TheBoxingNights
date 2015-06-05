package pl.theboxingnights.app.helpers;

import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.input.FlyByCamera;
import com.jme3.input.InputManager;
import com.jme3.renderer.Camera;
import com.jme3.scene.Node;

/**
 * Created by filip / 05.06.15 / 11:04
 */
public class AppStates {

    private final SimpleApplication simpleApplication;

    public AppStates(SimpleApplication simpleApplication) {
        this.simpleApplication = (SimpleApplication) simpleApplication;
    }

    public SimpleApplication getApplication() {
        return simpleApplication;
    }

    public Node getRootNode() {
        return getApplication().getRootNode();
    }

    public AppStateManager getStateManager() {
        return getApplication().getStateManager();
    }

    public InputManager getInputManager() {
        return getApplication().getInputManager();
    }

    public AssetManager getAsstetManager() {
        return getApplication().getAssetManager();
    }

    private Camera getCamera() {
        return getApplication().getCamera();
    }

    public FlyByCamera getFlyByCamera() {
        return getApplication().getFlyByCamera();
    }
}

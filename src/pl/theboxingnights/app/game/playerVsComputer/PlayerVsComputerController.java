package pl.theboxingnights.app.game.playerVsComputer;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.input.FlyByCamera;
import com.jme3.input.InputManager;
import com.jme3.renderer.Camera;
import com.jme3.scene.CameraNode;
import com.jme3.scene.Node;
import com.jme3.scene.plugins.blender.BlenderModelLoader;

/**
 * Created by filip / 05.06.15 / 05:42
 */
public class PlayerVsComputerController extends AbstractAppState {

    private SimpleApplication application;
    private Node scene;

    @Override
    public void initialize(AppStateManager appStateManager, Application application) {
        super.initialize(appStateManager, application);
        this.setApplication((SimpleApplication) application);
        getFlyByCamera().setMoveSpeed(50f);

        getAsstetManager().registerLoader(BlenderModelLoader.class, getBlendExtension());
        loadModel(getRingPath());
    }

    public void loadModel(String source) {
        setScene((Node) getAsstetManager().loadModel(source));
        getRootNode().attachChild(getScene());
    }

    private String getBlendExtension() {
        return "blend";
    }

    private String getRingPath() {
        return "pl/theboxingnights/app/assets/models/ring/ring.blend";
    }

    public SimpleApplication getApplication() {
        return application;
    }

    public void setApplication(SimpleApplication application) {
        this.application = application;
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

    private FlyByCamera getFlyByCamera() {
        return getApplication().getFlyByCamera();
    }

    public Node getScene() {
        return scene;
    }

    public void setScene(Node scene) {
        this.scene = scene;
    }
}

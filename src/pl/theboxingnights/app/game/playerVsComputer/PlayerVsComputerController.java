package pl.theboxingnights.app.game.playerVsComputer;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.bullet.control.BetterCharacterControl;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.plugins.blender.BlenderModelLoader;
import pl.theboxingnights.app.helpers.AppStates;

/**
 * Created by filip / 05.06.15 / 05:42
 */
public class PlayerVsComputerController extends AbstractAppState {

    private AppStates appStates;

    @Override
    public void initialize(AppStateManager appStateManager, Application application) {
        super.initialize(appStateManager, application);
        setAppStates(new AppStates((SimpleApplication)application));
        getAppStates().getFlyByCamera().setMoveSpeed(50f);
        getAppStates().getStateManager().attach(getAppStates().getBulletAppState());
        getAppStates().getAsstetManager().registerLoader(BlenderModelLoader.class, getBlendExtension());

        loadScene(getRingPath(), getSceneName());
        loadPlayer(getPlayerPath(), "player1", 0.03f, new Vector3f(0, 1, 0));
        loadPlayer(getPlayerPath(), "player2", 0.03f, new Vector3f(0, 1, 0));
    }

    public void loadScene(String locationInProject, String name) {
        Node sceneNode = (Node) getAppStates().getAsstetManager().loadModel(locationInProject);
        sceneNode.setName(name);
        sceneNode.addControl(new RigidBodyControl(0f));
        getAppStates().getBulletAppState().getPhysicsSpace().add(sceneNode);
        getAppStates().getRootNode().attachChild(sceneNode);
    }

    public void loadPlayer(String locationInProject, String name, float scale, Vector3f locationInScene) {
        Node playerNode = (Node) getAppStates().getAsstetManager().loadModel(locationInProject);
        playerNode.setName(name);
        playerNode.setLocalScale(scale);
        playerNode.setLocalTranslation(locationInScene);
        BetterCharacterControl playerControl = new BetterCharacterControl(0.3f, 2.5f, 8f);
        playerControl.setGravity(new Vector3f(0, -10, 0));
        playerNode.addControl(playerControl);
        getAppStates().getBulletAppState().getPhysicsSpace().add(playerNode);
        getAppStates().getRootNode().attachChild(playerNode);
    }

    private String getSceneName() {
        return "ring";
    }

    private String getBlendExtension() {
        return "blend";
    }

    private String getRingPath() {
        return "pl/theboxingnights/app/assets/models/ring/ring.blend";
    }

    private String getPlayerPath() {
        return "pl/theboxingnights/app/assets/models/player/player.blend";
    }

    public AppStates getAppStates() {
        return appStates;
    }

    public void setAppStates(AppStates appStates) {
        this.appStates = appStates;
    }
}

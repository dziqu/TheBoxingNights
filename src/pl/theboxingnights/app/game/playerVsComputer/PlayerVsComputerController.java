package pl.theboxingnights.app.game.playerVsComputer;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
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

        getAppStates().getAsstetManager().registerLoader(BlenderModelLoader.class, getBlendExtension());
        loadModel(getRingPath(), "ring");
        loadModel(getPlayerPath(), "player1", 0.3f);
    }

    public void loadModel(String source, String name) {
        Node node = (Node) getAppStates().getAsstetManager().loadModel(source);
        node.setName(name);
        getAppStates().getRootNode().attachChild(node);
    }

    public void loadModel(String source, String name, float localScale) {
        Node node = (Node) getAppStates().getAsstetManager().loadModel(source);
        node.setName(name);
        node.setLocalScale(localScale);
        getAppStates().getRootNode().attachChild(node);
    }

    public void loadModel(String source, String name, float localScale, Vector3f localTranslation) {
        Node node = (Node) getAppStates().getAsstetManager().loadModel(source);
        node.setName(name);
        node.setLocalScale(localScale);
        node.setLocalTranslation(localTranslation);
        getAppStates().getRootNode().attachChild(node);
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

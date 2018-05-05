package view;

import controller.GameController;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * This class represents the GameScreen class
 */
public class GameScreen extends BorderPane {


    /**
     * Creates a new view into the game. this layout should include
     * the rescource bar, grid map, and action menus
     *
     */
    private static VBox vBox = new VBox();
    private static ResourcesMenu rMenu = new ResourcesMenu();
    private static StatusMenu sMenu = new StatusMenu();
    private static GameScreen instance = new GameScreen();
    private static MilitaryMenu mMenu = new MilitaryMenu();
    private static WorkerMenu wMenu = new WorkerMenu();
    private static BuildingMenu bMenu = new BuildingMenu();

    public GameScreen() {
        setTop(rMenu.getRootNode());
        setCenter(GridFX.getInstance());
        setLeft(vBox);
        this.update();
    }

    /**
     * This method should update the gridfx and the resouce bar
     */
    public void update() {
        rMenu.update();
        GridFX.getInstance().update();
    }
    /**
    * this method should return the resource menu
    * @return reosuce menu
    */
    public static ResourcesMenu getResources() {
        return rMenu;
    }

    public static GameScreen getInstance() {
        return instance;
    }

    /**
     * This method switches menus based on passed in game state.
     * Game.java calls this to selectively control which menus are displayed
     * @param state
     */

    public static void switchMenu(GameController.GameState state) {
        RecruitMenu reMenu = new RecruitMenu();
        switch (state) {
        case NEUTRAL :
            vBox.getChildren().setAll(sMenu.getRootNode());
            break;
        case MILITARY :
            vBox.getChildren().setAll(mMenu.getRootNode());
            break;
        case WORKER :
            vBox.getChildren().setAll(wMenu.getRootNode());
            break;
        case BUILDING :
            vBox.getChildren().setAll(bMenu.getRootNode());
            break;
        case RECRUITING :
            vBox.getChildren().setAll(reMenu.getRootNode());
            break;
        default :
            vBox.getChildren().setAll(sMenu.getRootNode());
            break;
        }
    }
}

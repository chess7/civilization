package runner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import controller.GameController;
import view.StartScreen;
import view.GameScreen;
import view.GridFX;
import model.Map;
import model.QinDynasty;
import model.RomanEmpire;
import model.Egypt;
import model.Babylon;
import model.Greece;
import model.Persia;
import model.Bandit;
import javafx.scene.control.TextInputDialog;

public class CivilizationGame extends Application {

    /**
     * this method is called upon running/launching the application
     * this method should display a scene on the stage
     */
    private StartScreen start = new StartScreen();
    private String sName = new String();

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Civilization");
        Scene scene = new Scene(start); //600, 550
        primaryStage.setScene(scene);
        primaryStage.show();
        Map map = GridFX.getMap();
        start.getStartButton().setOnAction((event) -> {
                if (start.getCivList().getSelectionModel().getSelectedItem()
                    != null) {
                    switch (start.getCivList().getSelectionModel()
                        .getSelectedItem()) {
                    case ANCIENT_EGYPT:
                        Egypt egypt = new Egypt();
                        GameController.setCivilization(egypt);
                        map.putSettlement(sName, egypt, 0, 9);
                        break;
                    case QIN_DYNASTY :
                        QinDynasty qin = new QinDynasty();
                        GameController.setCivilization(qin);
                        map.putSettlement(sName, qin, 0, 9);
                        break;
                    case ROMAN_EMPIRE :
                        RomanEmpire rome = new RomanEmpire();
                        GameController.setCivilization(rome);
                        map.putSettlement(sName, rome, 0, 9);
                        break;
                    case BABYLON :
                        Babylon babylon = new Babylon();
                        GameController.setCivilization(babylon);
                        map.putSettlement(sName, babylon, 0, 9);
                        break;
                    case ANCIENT_GREECE :
                        Greece greece = new Greece();
                        GameController.setCivilization(greece);
                        map.putSettlement(sName, greece, 0, 9);
                        break;
                    case PERSIA :
                        Persia persia = new Persia();
                        GameController.setCivilization(persia);
                        map.putSettlement(sName, persia, 0, 9);
                        break;
                    default :
                        break;
                    }
                    map.addEnemies(new Bandit(), 1);
                    TextInputDialog textInputDialog = new TextInputDialog();
                    textInputDialog.setContentText(
                        "Enter the name of your first town:");
                    textInputDialog.setTitle("A New Settlement");
                    textInputDialog.setHeaderText("You have built a"
                        + " Settlement!");
                    textInputDialog.showAndWait();
                    if (!textInputDialog.getResult().isEmpty()) {
                        sName = textInputDialog.getResult();
                        primaryStage.setScene(startGame());
                        primaryStage.show();
                    }
                }
            });
    }
    /**
     * This is the main method that launches the javafx application
     */
    public static void main(String[] args) {
        launch(args);
    }
    /**
    * This method is responsible for setting the scene to the corresponding
    * layout.
    * and returning the scene.
    * @return Scene
    */

    public Scene startGame() {
        GameScreen game = new GameScreen();
        game.update();
        Scene scene = new Scene(game);
        return scene;
    }




}

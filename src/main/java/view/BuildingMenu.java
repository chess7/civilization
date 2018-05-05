package view;

import controller.GameController;
import model.Building;
import model.Settlement;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

/**
 * This class should represents the bulding menu
 */
public class BuildingMenu extends AbstractMenu {
    private Button investButton = new Button("Invest");
    private Button demolishButton = new Button("Demolish");
    /**
    * there should be an invest and demolish button for this menu
    * as well as functions associated with the buttons
    */
    public BuildingMenu() {
        super.addMenuItem(investButton);
        super.addMenuItem(demolishButton);
        investButton.setOnMousePressed(e -> {
                if (GameController.getCivilization().getTreasury()
                    .getCoins() >= 25) {
                    GameController.getCivilization().getTreasury().spend(25);
                    Building building = (Building) GameController
                        .getLastClicked().getTile().getOccupant();
                    building.invest();
                    Media sound = new Media(new File("cha-ching.mp3")
                        .toURI().toString());
                    MediaPlayer mediaPlayer = new MediaPlayer(sound);
                    mediaPlayer.play();
                    GameController.updateResourcesBar();
                } else {
                    Alert alert2 = new Alert(AlertType.INFORMATION);
                    alert2.setTitle("Action Failed");
                    alert2.setHeaderText(null);
                    alert2.setContentText("Unable to invest");
                    alert2.showAndWait();
                }
            });

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Action Failed");
        alert.setHeaderText(null);
        alert.setContentText("Unable to demolish");
        demolishButton.setOnMousePressed(e -> {
                if (GameController.getLastClicked().getTile()
                    .getOccupant() instanceof Settlement) {
                    if (GameController.getCivilization()
                            .getNumSettlements() > 1) {
                        GameController.getLastClicked().getTile()
                            .setOccupant(null);
                        GameController.getCivilization()
                            .decrementNumSettlements();
                        GameController.updateResourcesBar();
                    } else {
                        alert.showAndWait();
                    }
                } else if (GameController.getLastClicked().getTile()
                    .getOccupant().isBuilding()) {
                    GameController.getLastClicked().getTile()
                        .setOccupant(null);
                    GameController.updateResourcesBar();
                } else {
                    alert.showAndWait();
                }
            });
    }
}

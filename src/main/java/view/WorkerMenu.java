package view;

import controller.GameController;
import model.Convertable;
import model.TerrainTile;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class WorkerMenu extends AbstractMenu {
    private Button moveButton = new Button("Move");
    private Button convertButton = new Button("Convert");

    /**
    * Implement the buttons and actions associated with
    * the buttons for the military menu
    */
    public WorkerMenu() {
        super.addMenuItem(moveButton);
        super.addMenuItem(convertButton);
        moveButton.setOnMousePressed(e -> {
                GameController.moving();
            });

        convertButton.setOnMousePressed(e -> {
                Convertable object = (Convertable) GameController
                    .getLastClicked().getTile().getOccupant();
                TerrainTile tile = GameController.getLastClicked().getTile();
                if (object.canConvert(tile.getType())) {
                    GameController.getLastClicked().getTile().setOccupant(
                        object.convert());
                    GameController.updateResourcesBar();
                } else {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Action Failed");
                    alert.setHeaderText(null);
                    alert.setContentText("Unable to convert!");
                    alert.showAndWait();
                }
            });
    }
}

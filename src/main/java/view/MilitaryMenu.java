package view;

import controller.GameController;
import javafx.scene.control.Button;

public class MilitaryMenu extends AbstractMenu {
    private Button attackButton = new Button("Attack");
    private Button moveButton = new Button("Move");

    /**
    * Implement the buttons and actions associated with
    * the buttons for the military menu
    */
    public MilitaryMenu() {
        super.addMenuItem(attackButton);
        super.addMenuItem(moveButton);
        attackButton.setOnMousePressed(e -> {
                GameController.attacking();
                GameController.updateResourcesBar();
            });

        moveButton.setOnMousePressed(e -> {
                GameController.moving();
            });
    }
}

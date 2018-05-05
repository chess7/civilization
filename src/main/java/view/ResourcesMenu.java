package view;

import controller.GameController;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import model.Civilization;
import javafx.geometry.Pos;

public class ResourcesMenu {
    private int strat;
    private int resources;
    private int numSettlements;
    private int money;
    private int food;
    private int happiness;
    private HBox hBox = new HBox(25);

    /**
    * creates a resource bar and display the current state of
    * your civilization's resouces
    */
    public ResourcesMenu() {
        update();
    }
    /**
    * should update all the resouce values to the current
    * state of your resource values
    */
    public void update() {
        Civilization civ = GameController.getCivilization();
        if (civ != null) {
            strat = civ.getStrategy().getStrategyLevel();
            resources = civ.getResources();
            numSettlements = civ.getNumSettlements();
            money = civ.getTreasury().getCoins();
            food = civ.getFood();
            happiness = civ.getHappiness();
            Text tstrat = new Text("Strategy Level: " + strat);
            Text tresources = new Text("Resources: " + resources);
            Text tnumSettlements = new Text("Settlements: " + numSettlements);
            Text tmoney = new Text("Money: " + money);
            Text tfood = new Text("Food: " + food);
            Text thappiness = new Text("Happiness: " + happiness);
            hBox.getChildren().setAll(tstrat, tresources, tnumSettlements,
                tmoney, tfood, thappiness);
            hBox.setAlignment(Pos.CENTER);
        }
    }
    /**
    * updates the resource bar and returns the resource bar
    * @return a hbox representation of the resource bar
    */
    public HBox getRootNode() {
        update();
        return hBox;
    }
}

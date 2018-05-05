package view;

import controller.GameController;
import model.Civilization;
import model.Unit;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.TerrainTile;
import controller.TileType;

public class RecruitMenu extends AbstractMenu {
    private TerrainTile tTile = new TerrainTile(TileType.DESERT, 0, 0);
    private TerrainTileFX tTileFX = new TerrainTileFX(tTile);
    //^^ prevents nullpointerexception with getLastClicked(), if I had more
    //time I'd find a better way to fix this issue

    private Civilization civ = GameController.getCivilization();
    private Unit melee = civ.getMeleeUnit();
    private Unit ranged = civ.getRangedUnit();
    private Unit hybrid = civ.getHybridUnit();
    private Unit siege = civ.getSiegeUnit();
    private Unit settlers = civ.getSettlerUnit("Placeholder");
    private Unit farmers = civ.getFarmerUnit();
    private Unit coalminers = civ.getCoalMinerUnit();
    private Unit anglers = civ.getAnglerUnit();
    private Unit masterbuilders = civ.getMasterBuilderUnit();

    private ListView<String> listView = new ListView<>(
        FXCollections.observableArrayList("Melee Unit", "Ranged Unit",
            "Hybrid Unit", "Siege Unit", "Settlers", "Farmers",
            "Coal Miners", "Anglers", "Master Builders"));
    private Button selectButton = new Button("Select");
    /**
    * recuit menu should have a list of worker/units
    * to choose from. There should also be a select button
    * and the function of the button should be implemented
    *here
    */
    public RecruitMenu() {
        super.addMenuItem(listView);
        super.addMenuItem(selectButton);
        if (GameController.getLastClicked() == null) {
            GameController.setLastClicked(tTileFX);
        }
        TerrainTile tile = GameController.getLastClicked().getTile();
        Alert alert2 = new Alert(AlertType.INFORMATION);
        alert2.setTitle("Action Failed");
        alert2.setHeaderText(null);
        alert2.setContentText("Not enough money to recruit!");
        selectButton.setOnAction((event) -> {
                if (tile.isEmpty()) {
                    switch (listView.getSelectionModel().getSelectedItem()) {
                    case "Melee Unit" :
                        if (melee.isAffordable()) {
                            melee.applyInitialCosts();
                            tile.setOccupant(melee);
                            GameController.updateResourcesBar();
                        } else {
                            alert2.showAndWait();
                        }
                        break;
                    case "Ranged Unit" :
                        if (melee.isAffordable()) {
                            ranged.applyInitialCosts();
                            tile.setOccupant(ranged);
                            GameController.updateResourcesBar();
                        } else {
                            alert2.showAndWait();
                        }
                        break;
                    case "Hybrid Unit" :
                        if (melee.isAffordable()) {
                            hybrid.applyInitialCosts();
                            tile.setOccupant(hybrid);
                            GameController.updateResourcesBar();
                        } else {
                            alert2.showAndWait();
                        }
                        break;
                    case "Siege Unit" :
                        if (melee.isAffordable()) {
                            siege.applyInitialCosts();
                            tile.setOccupant(siege);
                            GameController.updateResourcesBar();
                        } else {
                            alert2.showAndWait();
                        }
                        break;
                    case "Settlers" :
                        if (melee.isAffordable()) {
                            settlers.applyInitialCosts();
                            tile.setOccupant(settlers);
                            GameController.updateResourcesBar();
                        } else {
                            alert2.showAndWait();
                        }
                        break;
                    case "Farmers" :
                        if (melee.isAffordable()) {
                            farmers.applyInitialCosts();
                            tile.setOccupant(farmers);
                            GameController.updateResourcesBar();
                        } else {
                            alert2.showAndWait();
                        }
                        break;
                    case "Coal Miners" :
                        if (melee.isAffordable()) {
                            coalminers.applyInitialCosts();
                            tile.setOccupant(coalminers);
                            GameController.updateResourcesBar();
                        } else {
                            alert2.showAndWait();
                        }
                        break;
                    case "Anglers" :
                        if (melee.isAffordable()) {
                            anglers.applyInitialCosts();
                            tile.setOccupant(anglers);
                            GameController.updateResourcesBar();
                        } else {
                            alert2.showAndWait();
                        }
                        break;
                    case "Master Builders" :
                        if (melee.isAffordable()) {
                            masterbuilders.applyInitialCosts();
                            tile.setOccupant(masterbuilders);
                            GameController.updateResourcesBar();
                        } else {
                            alert2.showAndWait();
                        }
                        break;
                    default :
                        break;
                    }
                } else {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Action Failed");
                    alert.setHeaderText(null);
                    alert.setContentText("This tile is occupied!");
                    alert.showAndWait();
                }
            });
    }
}

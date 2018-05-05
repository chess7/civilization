package view;

import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;

/**
 * This class represents the Start Screen for the Civ applicatios. This is the
 * layout that should be displayed upon running the Civ application.
 *
 * This class should have and display
 * 1. a background
 * 2. a list of Civilizations
 * 3. a Start button
 */
public class StartScreen extends StackPane {
    private Button startButton = new Button("Start");
    private ListView listView = new ListView(
        FXCollections.observableArrayList(CivEnum.values()));
    private ImageView background = new ImageView(
        new Image("/view/civ_background.png"));
    private VBox vBox = new VBox();

    /**
    * constuctor of the start screen. Should set the background
    * image and display a list of civilizations and a start button
    */
    public StartScreen() {
        listView.setMaxHeight(100);
        listView.setMaxWidth(150);
        vBox.getChildren().addAll(listView, startButton);
        vBox.setAlignment(Pos.CENTER);
        vBox.setTranslateY(150);
        vBox.setSpacing(10);
        getChildren().addAll(background, vBox);
    }
    /**
    * gets the start button
    * @return the start button
    */
    public Button getStartButton() {
        return this.startButton;
    }

    /**
    * return a ListView of CivEnums representing the list of
    * available civilizations to choose from
    * @return listview of CivEnum
    */
    public ListView<CivEnum> getCivList() {
        return listView;
    }
}

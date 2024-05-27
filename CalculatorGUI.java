package pokemonGoCalc;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


/**
 * Graphical User Interface for the Pokémon Go Calculator.
 * 
 * @author BRENDAN DILEO (@DRENDOS)
 */
public class CalculatorGUI extends Application {

    // Instance Variables
    private Canvas canvas;
    private GraphicsContext gc;
    private Label mainLabel;
    private Label mainLabelTwo;
    private Label pokemonOneLabel;
    private TextField pokemonOneType;
    private Label pokemonTwoLabel;
    private TextField pokemonTwoType;
    private TextField friendshipLevel;
    private Button calculateButton;
    private Label legendaryLabel;
    private RadioButton legendaryYes;
    private RadioButton legendaryNo;
    private Label shinyLabel;
    private RadioButton shinyYes;
    private RadioButton shinyNo;
    private Label dexLabel;
    private RadioButton dexYes;
    private RadioButton dexNo;
    private Label costLabel;
    private Image pokeball;
    private Image pokemonGoLogo;
    private Image stardust;


    // TODO: Private Event Handlers and Helper Methods

    // Event Handlers & Methods

    /**
     *
     * @param friendshipLevel
     * @return
     */
    private int friendshipLevelCheck(String friendshipLevel) {
        switch (friendshipLevel.toLowerCase()) {
            case "good":
                return 1;
            case "great":
                return 2;
            case "ultra":
                return 3;
            case "best":
                return 4;
            default:
                return 0;
        }
    }

    /**
     *
     * @param event
     */
    private void calculateTradeCost(ActionEvent event) {
        String pokemonOne = pokemonOneType.getText();
        String pokemonTwo = pokemonTwoType.getText();
        String friendship = friendshipLevel.getText().toLowerCase();
        boolean isLegendary = legendaryYes.isSelected();
        boolean isShiny = shinyYes.isSelected();
        boolean isInDex = dexYes.isSelected();
        int friendshipLevel = friendshipLevelCheck(friendship);

        int cost = 0;

        if (isInDex) {
            if (isLegendary || isShiny) {
                switch (friendshipLevel) {
                    case 1:
                        cost = 20000;
                        break;
                    case 2:
                        cost = 16000;
                        break;
                    case 3:
                        cost = 1600;
                        break;
                    case 4:
                        cost = 800;
                }
            }
        } else {
            if (isLegendary || isShiny) {
                switch (friendshipLevel) {
                    case 1:
                        cost = 1000000;
                        break;
                    case 2:
                        cost = 800000;
                        break;
                    case 3:
                        cost = 80000;
                        break;
                    case 4:
                        cost = 40000;
                        break;
                }
            } else {
                switch (friendshipLevel) {
                    case 1:
                        cost = 20000;
                        break;
                    case 2:
                        cost = 16000;
                        break;
                    case 3:
                        cost = 1600;
                        break;
                    case 4:
                        cost = 800;
                        break;
                }
            }
        }
        costLabel.setText("Stardust Cost: " + cost);
    }

    /**
     * This is where you create your components and the model and add event
     * handlers.
     *
     * @param stage The main stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root, 400, 600);
        stage.setTitle("Pokemon Go Trade Calculator");
        stage.getIcons().add(new Image("pokemonGoCalc/assets/images/go.png"));
        stage.setScene(scene);
        Font pokeFont = Font.loadFont(getClass().getResourceAsStream("/pokemonGoCalc/assets/fonts/PocketMonk-15ze.ttf"), 40);
        Font pokeFontTwo = Font.loadFont(getClass().getResourceAsStream("/pokemonGoCalc/assets/fonts/PokemonSolidNormal-xyWR.ttf"), 20);
        Font buttonFont = Font.loadFont(getClass().getResourceAsStream("/pokemonGoCalc/assets/fonts/PokemonSolidNormal-xyWR.ttf"), 15);



        // CREATING MODEL

        canvas = new Canvas(400, 600);
        gc = canvas.getGraphicsContext2D();

        // CREATING GUI COMPONENTS

        mainLabel = new Label("Trade Calculator!");
        mainLabel.setFont(pokeFont);

        mainLabelTwo = new Label("Pokemon Go");
        mainLabelTwo.setFont(pokeFont);

        pokemonOneLabel = new Label("Pokemon 1: ");
        pokemonOneLabel.setFont(pokeFontTwo);
        pokemonOneType = new TextField("");

        pokemonTwoLabel = new Label("Pokemon 2: ");
        pokemonTwoLabel.setFont(pokeFontTwo);
        pokemonTwoType = new TextField("");

        friendshipLevel = new TextField("Friendship Type: ");

        calculateButton = new Button("Calculate");

        legendaryLabel = new Label("Legendary?");
        legendaryLabel.setFont(pokeFontTwo);
        legendaryYes = new RadioButton("Yes");
        legendaryNo = new RadioButton("No");
        ToggleGroup legendaryGroup = new ToggleGroup();
        legendaryYes.setToggleGroup(legendaryGroup);
        legendaryNo.setToggleGroup(legendaryGroup);

        shinyLabel = new Label("Shiny?");
        shinyLabel.setFont(pokeFontTwo);
        shinyYes = new RadioButton("Yes");
        shinyNo = new RadioButton("No");
        ToggleGroup shinyGroup = new ToggleGroup();
        shinyYes.setToggleGroup(shinyGroup);
        shinyNo.setToggleGroup(shinyGroup);

        dexLabel = new Label("In Dex?");
        dexLabel.setFont(pokeFontTwo);
        dexYes = new RadioButton("Yes");
        dexNo = new RadioButton("No");
        ToggleGroup dexGroup = new ToggleGroup();
        dexYes.setToggleGroup(dexGroup);
        dexNo.setToggleGroup(dexGroup);

        costLabel = new Label("Stardust Cost: ");

        pokeball = new Image("pokemonGoCalc/assets/images/pokeball.png");
        ImageView pokeballImage = new ImageView(pokeball);

        stardust = new Image("pokemonGoCalc/assets/images/stardust.png");
        ImageView stardustImage = new ImageView(stardust);

        // COMPONENTS ADDED TO ROOT

        root.getChildren().addAll(mainLabel, mainLabelTwo, pokemonOneLabel, pokemonOneType, pokemonTwoLabel, pokemonTwoType,
                friendshipLevel, calculateButton, legendaryLabel, legendaryYes, legendaryNo, shinyLabel, shinyYes, shinyNo,
                dexLabel, dexYes, dexNo, costLabel, pokeballImage, stardustImage);

        // CONFIGURING COMPONENTS

        mainLabel.setLayoutX(60);
        mainLabel.setLayoutY(50);

        mainLabelTwo.setLayoutX(110);
        mainLabelTwo.setLayoutY(80);

        pokemonOneLabel.relocate(10, 200);
        pokemonOneType.relocate(10, 240);

        pokemonTwoLabel.relocate(200, 200);
        pokemonTwoType.relocate(200, 240);

        shinyLabel.relocate(10, 300);
        shinyYes.relocate(80, 315);
        shinyNo.relocate(130, 315);

        legendaryLabel.relocate(190, 300);
        legendaryYes.relocate(310, 315);
        legendaryNo.relocate(350, 315);

        friendshipLevel.relocate(190, 350);

        dexLabel.relocate(10, 340);
        dexYes.relocate(100, 355);
        dexNo.relocate(150, 355);

        calculateButton.relocate(100, 410);
        calculateButton.setPrefWidth(100);
        calculateButton.setPrefHeight(50);
        calculateButton.setFont(buttonFont);

        costLabel.relocate(100, 500);

        pokeballImage.setLayoutX(5);
        pokeballImage.setLayoutY(1);



        // EVENT HANDLERS
        calculateButton.setOnAction(this::calculateTradeCost);

        // SHOW STAGE
        stage.show();
    }

    /**
     * Make no changes here.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}

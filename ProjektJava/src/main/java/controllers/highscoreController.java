package controllers;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class highscoreController extends AbstractController {

    public void start(Stage primaryStage) throws Exception {
    }

    public void backToMainMenu(Event actionEvent){
        clip.play(sfxVolume);
        createWindow(actionEvent,"Main Menu");
    }

    public void backButtonChange(Event e){
        ImageView im = (ImageView) e.getSource();
        Image image = new Image(getClass().getResource("/icons/backButton2.png").toExternalForm());
        im.setImage(image);
    }

    public void backButtonReset(Event e){
        ImageView im = (ImageView) e.getSource();
        Image image = new Image(getClass().getResource("/icons/backButton.png").toExternalForm());
        im.setImage(image);
    }

}

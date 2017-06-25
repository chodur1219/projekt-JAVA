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

public class optionsController extends AbstractController {

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

    public void changeSfx(Event e){
        ImageView im = (ImageView) e.getSource();
        Image imageSfx;
        if(sfxSound){
            sfxVolume=0;
            imageSfx = new Image(getClass().getResource("/icons/sfx2.png").toExternalForm());
        }else{
            sfxVolume=0.1;
            imageSfx = new Image(getClass().getResource("/icons/sfx.png").toExternalForm());
        }
        im.setImage(imageSfx);
        sfxSound=!sfxSound;
    }

    public void changeMusic(Event e){
        ImageView im = (ImageView) e.getSource();
        Image imageMusic;

        if(musicSound){
            mainMusic.stop();
            imageMusic = new Image(getClass().getResource("/icons/music2.png").toExternalForm());
        }else{
            mainMusic.play(0.1);
            imageMusic = new Image(getClass().getResource("/icons/music.png").toExternalForm());
        }
        im.setImage(imageMusic);
        musicSound=!musicSound;
    }
}

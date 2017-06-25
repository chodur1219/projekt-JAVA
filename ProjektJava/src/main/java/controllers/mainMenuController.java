package controllers;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class mainMenuController extends AbstractController {
    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/layouts/mainMenuLayout.fxml"));
        primaryStage.setTitle("mainmenu");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        Scene scene = new Scene(root);

        mainMusic.play(0.1);
        mainMusic.setCycleCount(AudioClip.INDEFINITE);

        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void startGame(Event e){
        clip.play(sfxVolume);
        createWindow(e,"NewGame");
    }

    public void options(Event e){
        clip.play(sfxVolume);
        createWindow(e,"Options");
    }

    public void highscores(Event e){
        clip.play(sfxVolume);
        createWindow(e,"Highscores");
    }

    public void exitGame(Event e){
        clip.play(sfxVolume);
        System.exit(0);
    }

    public void info(Event e){
        clip.play(sfxVolume);
        Scene scene = ((Node)(e.getSource())).getScene();
        ImageView helpImageView = (ImageView) scene.lookup("#help");
        visibility = !visibility;
        helpImageView.setVisible(visibility);
    }

    public void infoButtonChange(Event e){
        ImageView im = (ImageView) e.getSource();
        Image image = new Image(getClass().getResource("/icons/infobutton2.png").toExternalForm());
        im.setImage(image);

    }

    public void infoButtonReset(Event e){
        ImageView im = (ImageView) e.getSource();
        Image image = new Image(getClass().getResource("/icons/infobutton.png").toExternalForm());
        im.setImage(image);

    }

    public void startButtonChange(Event e){
        ImageView im = (ImageView) e.getSource();
        Image image = new Image(getClass().getResource("/icons/startgame2.png").toExternalForm());
        im.setImage(image);

    }

    public void startButtonReset(Event e){
        ImageView im = (ImageView) e.getSource();
        Image image = new Image(getClass().getResource("/icons/startgame.png").toExternalForm());
        im.setImage(image);

    }

    public void optionsButtonChange(Event e){
        ImageView im = (ImageView) e.getSource();
        Image image = new Image(getClass().getResource("/icons/options2.png").toExternalForm());
        im.setImage(image);

    }

    public void optionsButtonReset(Event e){
        ImageView im = (ImageView) e.getSource();
        Image image = new Image(getClass().getResource("/icons/options.png").toExternalForm());
        im.setImage(image);

    }

    public void highscoresButtonChange(Event e){
        ImageView im = (ImageView) e.getSource();
        Image image = new Image(getClass().getResource("/icons/highscores2.png").toExternalForm());
        im.setImage(image);

    }

    public void highscoresButtonReset(Event e){
        ImageView im = (ImageView) e.getSource();
        Image image = new Image(getClass().getResource("/icons/highscores.png").toExternalForm());
        im.setImage(image);

    }

    public void exitButtonChange(Event e){
        ImageView im = (ImageView) e.getSource();
        Image image = new Image(getClass().getResource("/icons/exitbt2.png").toExternalForm());
        im.setImage(image);

    }

    public void exitButtonReset(Event e){
        ImageView im = (ImageView) e.getSource();
        Image image = new Image(getClass().getResource("/icons/exitbt.png").toExternalForm());
        im.setImage(image);

    }


}

package controllers;

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.Random;

public abstract class AbstractController extends Application {

    final private URL resource = getClass().getResource("/sounds/mainmenumusic.mp3");
    final  AudioClip mainMusic = new AudioClip(resource.toString());

    final private URL res = getClass().getResource("/sounds/beep.mp3");
    final  AudioClip clip = new AudioClip(res.toString());

    final private URL res2 = getClass().getResource("/sounds/error.mp3");
    final  AudioClip err = new AudioClip(res2.toString());

    static double sfxVolume = 0.1;
    static Boolean sfxSound = true, musicSound = true, visibility = false;
    static String code = "0000";
    private static char[] chars = "123456".toCharArray();

    static Label[] attArr = new Label[9];
    static ImageView[] corrArr = new ImageView[9], wrongArr = new ImageView[9];

    private static MyDataBaseConnectionController myDataBaseConnectionController = MyDataBaseConnectionController.getInstance();

    void createWindow(Event actionEvent, String name) {
        Parent root;
        try {
            if (name.equals("NewGame")) {
                System.out.println(name);
                root = FXMLLoader.load(getClass().getClassLoader().getResource("layouts/gameLayout.fxml"));
            } else if (name.equals("Main Menu")) {
                System.out.println(name);
                root = FXMLLoader.load(getClass().getClassLoader().getResource("layouts/mainMenuLayout.fxml"));
            } else if (name.equals("Options")) {
                System.out.println(name);
                root = FXMLLoader.load(getClass().getClassLoader().getResource("layouts/optionsLayout.fxml"));
            } else {
                System.out.println(name);
                root = FXMLLoader.load(getClass().getClassLoader().getResource("layouts/highscoresLayout.fxml"));
            }

            Stage stage = new Stage();
            stage.setTitle(name);
            Scene scene = new Scene(root);
            stage.initStyle(StageStyle.UNDECORATED);

            if (name.equals("NewGame")) {
                generateNewCode();
                Label attempt1 = (Label) scene.lookup("#att1");
                Label attempt2 = (Label) scene.lookup("#att2");
                Label attempt3 = (Label) scene.lookup("#att3");
                Label attempt4 = (Label) scene.lookup("#att4");
                Label attempt5 = (Label) scene.lookup("#att5");
                Label attempt6 = (Label) scene.lookup("#att6");
                Label attempt7 = (Label) scene.lookup("#att7");
                Label attempt8 = (Label) scene.lookup("#att8");
                Label attempt9 = (Label) scene.lookup("#att9");

                ImageView correct1 = (ImageView) scene.lookup("#corr1");
                ImageView correct2 = (ImageView) scene.lookup("#corr2");
                ImageView correct3 = (ImageView) scene.lookup("#corr3");
                ImageView correct4 = (ImageView) scene.lookup("#corr4");
                ImageView correct5 = (ImageView) scene.lookup("#corr5");
                ImageView correct6 = (ImageView) scene.lookup("#corr6");
                ImageView correct7 = (ImageView) scene.lookup("#corr7");
                ImageView correct8 = (ImageView) scene.lookup("#corr8");
                ImageView correct9 = (ImageView) scene.lookup("#corr9");

                ImageView wrong1 = (ImageView) scene.lookup("#wrong1");
                ImageView wrong2 = (ImageView) scene.lookup("#wrong2");
                ImageView wrong3 = (ImageView) scene.lookup("#wrong3");
                ImageView wrong4 = (ImageView) scene.lookup("#wrong4");
                ImageView wrong5 = (ImageView) scene.lookup("#wrong5");
                ImageView wrong6 = (ImageView) scene.lookup("#wrong6");
                ImageView wrong7 = (ImageView) scene.lookup("#wrong7");
                ImageView wrong8 = (ImageView) scene.lookup("#wrong8");
                ImageView wrong9 = (ImageView) scene.lookup("#wrong9");

                attArr[0] = attempt1;
                attArr[1] = attempt2;
                attArr[2] = attempt3;
                attArr[3] = attempt4;
                attArr[4] = attempt5;
                attArr[5] = attempt6;
                attArr[6] = attempt7;
                attArr[7] = attempt8;
                attArr[8] = attempt9;

                corrArr[0] = correct1;
                corrArr[1] = correct2;
                corrArr[2] = correct3;
                corrArr[3] = correct4;
                corrArr[4] = correct5;
                corrArr[5] = correct6;
                corrArr[6] = correct7;
                corrArr[7] = correct8;
                corrArr[8] = correct9;

                wrongArr[0] = wrong1;
                wrongArr[1] = wrong2;
                wrongArr[2] = wrong3;
                wrongArr[3] = wrong4;
                wrongArr[4] = wrong5;
                wrongArr[5] = wrong6;
                wrongArr[6] = wrong7;
                wrongArr[7] = wrong8;
                wrongArr[8] = wrong9;

            }

            if (name.equals("Options")) {
                if (!musicSound) {
                    ImageView musicImageView = (ImageView) scene.lookup("#mus");
                    Image imageMusic = new Image(getClass().getResource("/icons/music2.png").toExternalForm());
                    musicImageView.setImage(imageMusic);
                }

                if (!sfxSound) {
                    ImageView sfxImageView = (ImageView) scene.lookup("#sf");
                    Image imageSfx = new Image(getClass().getResource("/icons/sfx2.png").toExternalForm());
                    sfxImageView.setImage(imageSfx);
                }
            }

            if (name.equals("Highscores")) {
                //myDataBaseConnectionController.openDatabaseConnection();
            }

            stage.setScene(scene);
            stage.show();
            ((Node) (actionEvent.getSource())).getScene().getWindow().hide();


        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void generateNewCode(){
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        code = sb.toString();
        System.out.println(code);
    }


}

package controllers;

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
import java.util.Random;

public class gameController extends AbstractController {

    private int attempt = 0;
    private int current = 0;

    public void start(Stage primaryStage) throws Exception {
          System.out.println("aaa");
    }

    public void oneC(Event e){
        Scene scene = ((Node)(e.getSource())).getScene();
        Label text = (Label) scene.lookup("#playersGuess");
        text.setText(text.getText()+"1");

    }

    public void twoC(Event e){
        Scene scene = ((Node)(e.getSource())).getScene();
        Label text = (Label) scene.lookup("#playersGuess");
        text.setText(text.getText()+"2");
    }

    public void threeC(Event e){
        Scene scene = ((Node)(e.getSource())).getScene();
        Label text = (Label) scene.lookup("#playersGuess");
        text.setText(text.getText()+"3");
    }

    public void fourC(Event e){
        Scene scene = ((Node)(e.getSource())).getScene();
        Label text = (Label) scene.lookup("#playersGuess");
        text.setText(text.getText()+"4");
    }

    public void fiveC(Event e){
        Scene scene = ((Node)(e.getSource())).getScene();
        Label text = (Label) scene.lookup("#playersGuess");
        text.setText(text.getText()+"5");
    }

    public void sixC(Event e){
        Scene scene = ((Node)(e.getSource())).getScene();
        Label text = (Label) scene.lookup("#playersGuess");
        text.setText(text.getText()+"6");
    }

    public void backC(Event e){
        Scene scene = ((Node)(e.getSource())).getScene();
        Label text = (Label) scene.lookup("#playersGuess");
        text.setText("");
    }

    public void reset(Event e){

        Scene scene = ((Node)(e.getSource())).getScene();
        ImageView win = (ImageView) scene.lookup("#winScreen");
        ImageView lose = (ImageView) scene.lookup("#loseScreen");

        win.setVisible(false);
        lose.setVisible(false);
        clip.play(sfxVolume);
        attempt=0;
        current=0;
        generateNewCode();
        backC(e);
        Image image1= new Image(getClass().getResource("/icons/digits/zeroGood.png").toExternalForm());
        Image image2= new Image(getClass().getResource("/icons/digits/zeroClose.png").toExternalForm());
        for (int i=0; i<9; i++){
            attArr[i].setText("");
            corrArr[i].setImage(image1);
            wrongArr[i].setImage(image2);
        }
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

    public void checkButtonChange(Event e){
        ImageView im = (ImageView) e.getSource();
        Image image = new Image(getClass().getResource("/icons/checkButton2.png").toExternalForm());
        im.setImage(image);
    }

    public void checkButtonReset(Event e){
        ImageView im = (ImageView) e.getSource();
        Image image = new Image(getClass().getResource("/icons/checkButton.png").toExternalForm());
        im.setImage(image);
    }

    public void resetButtonChange(Event e){
        ImageView im = (ImageView) e.getSource();
        Image image = new Image(getClass().getResource("/icons/resetButton2.png").toExternalForm());
        im.setImage(image);
    }

    public void resetButtonReset(Event e){
        ImageView im = (ImageView) e.getSource();
        Image image = new Image(getClass().getResource("/icons/resetButton.png").toExternalForm());
        im.setImage(image);
    }

    public Boolean checkIfIncorrectLength(Scene scene){
        Label text = (Label) scene.lookup("#playersGuess");
        if(text.getText().length()==4)
            return false;
        else
            return true;
    }

    public void addAttemptToList(String guess, int good, int close){
        attArr[current].setText(guess);
        Image image;

        switch (good){
            case 0:
                image = new Image(getClass().getResource("/icons/digits/zeroGood.png").toExternalForm());
                corrArr[current].setImage(image);
                break;
            case 1:
                image = new Image(getClass().getResource("/icons/digits/oneGood.png").toExternalForm());
                corrArr[current].setImage(image);
                break;
            case 2:
                image = new Image(getClass().getResource("/icons/digits/twoGood.png").toExternalForm());
                corrArr[current].setImage(image);
                break;
            case 3:
                image = new Image(getClass().getResource("/icons/digits/threeGood.png").toExternalForm());
                corrArr[current].setImage(image);
                break;
            case 4:
                image = new Image(getClass().getResource("/icons/digits/fourGood.png").toExternalForm());
                corrArr[current].setImage(image);
                break;
            default:
                break;
        }

        switch (close){
            case 0:
                image = new Image(getClass().getResource("/icons/digits/zeroClose.png").toExternalForm());
                wrongArr[current].setImage(image);
                break;
            case 1:
                image = new Image(getClass().getResource("/icons/digits/oneClose.png").toExternalForm());
                wrongArr[current].setImage(image);
                break;
            case 2:
                image = new Image(getClass().getResource("/icons/digits/twoClose.png").toExternalForm());
                wrongArr[current].setImage(image);
                break;
            case 3:
                image = new Image(getClass().getResource("/icons/digits/threeClose.png").toExternalForm());
                wrongArr[current].setImage(image);
                break;
            case 4:
                image = new Image(getClass().getResource("/icons/digits/fourClose.png").toExternalForm());
                wrongArr[current].setImage(image);
                break;
            default:
                break;
        }
        current++;
    }

    public void checkAnswer(Event e) throws InterruptedException {

        Scene scene = ((Node)(e.getSource())).getScene();
        Label text = (Label) scene.lookup("#playersGuess");
        ImageView win = (ImageView) scene.lookup("#winScreen");
        ImageView lose = (ImageView) scene.lookup("#loseScreen");

        if(checkIfIncorrectLength(scene)) {
            err.play(sfxVolume);
            return;
        }
        attempt++;
        int good = 0;
        int close = 0;
        clip.play(sfxVolume);


        String[] ary = text.getText().split("");
        String[] cod = code.split("");

        for(int i=0; i<4; i++){

            if (ary[i].equals(cod[i]))
                good += 1;
            if ((!ary[i].equals(cod[i])) && (code.contains(ary[i])))
                close += 1;
        }
        addAttemptToList(text.getText(), good, close);
        System.out.println(attempt);


        if(attempt>9)
            reset(e);

        if(good ==4){
            System.out.println("Wygrales");
            win.setVisible(true);
            return;
        }

        if(attempt==9){
            if(good != 4) {
                System.out.println("Przegrales");
                lose.setVisible(true);
            }
            return;
        }

    }
}

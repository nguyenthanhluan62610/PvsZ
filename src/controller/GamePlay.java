package controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javafx.util.Duration;
import model.Zombie;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class GamePlay {

    @FXML
    private AnchorPane GamePlayRoot;
    @FXML
    private ImageView lawnImage;
    @FXML
    private ImageView peaShooterBuy;
    @FXML
    private ImageView repeaterBuy;
    @FXML
    private Label sunCountLabel;
    @FXML
    private ImageView GameMenuLoaderButton;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private int levelNumber;
    @FXML
    private GridPane lawn_grid;
    /**
     * Set lanes in the yard
     */
    private static int sunCount;
    public static final int LANE1 = 50;
    public static final int LANE2 = 150;
    public static final int LANE3 = 250;
    public static final int LANE4 = 350;
    public static final int LANE5 = 450;
    public static boolean gameStatus;
    public static Timeline sunTimeline;
    public static Timeline spZ1;
    public static Timeline spZ2;
    private static Label sunCountDisplay;
    private static double timeElapsed;

    public static List allZombies;
    public static List allPlants;
    public static List allMowers;
    public static ArrayList<Integer> zombieList1;
    public static ArrayList<Integer> zombieList2;
    //public static ArrayList<Zombie> allZombies = new ArrayList<Zombie>();

    public static int wonGame = 0;
    private volatile int spawnedZombies = 0;
    public static double numZombiesKilled = 0;
    public static ArrayList<Timeline> animationTimelines;


    public void initialize() throws Exception {

        String waveFile = "src/resource/sound/zombies_coming.wav";
        Media wave = new Media(new File(waveFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(wave);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setStartTime(Duration.seconds(0));
        mediaPlayer.setStopTime(Duration.seconds(5));
        mediaPlayer.play();

        gameStatus = true;
        sunCountDisplay = sunCountLabel;
        allZombies = Collections.synchronizedList(new ArrayList<Zombie>());
        //allPlants = Collections.synchronizedList(new ArrayList<Plant>());

    }


    @FXML
    void loadGameMenu(MouseEvent event) throws IOException {
    }


    @FXML
    void getGridPosition(MouseEvent event) throws IOException {
    }

}

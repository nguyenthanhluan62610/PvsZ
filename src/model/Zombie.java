package model;

import controller.GamePlay;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;

public abstract class Zombie extends GameElements {
    public int health;
    public int damage;
    public int lane;
    public int x, y;
    public int deltaX = -1;
    public transient Timeline zombieAnimation;
    public transient ImageView image;
    public boolean isMoving = true;
    public static int numberOfZombie = 0;
    public String imagePath = null;


    public Zombie(int x, int y, String imagePath,  int health, int damage, int lane, int width, int height) {
        super(x, y, imagePath, width, height);
        this.health = health;
        this.damage = damage;
        this.lane = lane;

    }


    public void moveZombie() {
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(70), e -> zombieWalk()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
        this.zombieAnimation = animation;
        GamePlay.animationTimelines.add(animation);
    }

    public void zombieWalk() {
        if(getX()>220 && this.health>0) {
            //Update the location of the zombie
            setX(getX() + deltaX);
            checkReachedHouse();
           // System.out.println("The zombie has moved");
        }
    }

    public void checkReachedHouse() {
        //System.out.println(getX());
        if (getX() <= 220) { //reach the house
            String eatingBrainFile = "src/resource/sound/eatingbrain.wav";
            Media eatingBrain = new Media(new File(eatingBrainFile).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(eatingBrain);
            mediaPlayer.setAutoPlay(true);
            mediaPlayer.play();
        }
    }

    public void chompingPlantSound() {
        String chompFile = "src/resource/sound/chomp.wav";
        Media chomp = new Media(new File(chompFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(chomp);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setStartTime(Duration.seconds(0));
        mediaPlayer.setStopTime(Duration.seconds(1));
        mediaPlayer.setCycleCount(1);
        mediaPlayer.play();
    }

    public Timeline getZombieAnimation() {
        return zombieAnimation;
    }

    public int getHealth() {
        return health;
    }

    public int getLane() {
        return lane;
    }

    public int setHealth(int health) {
        return health;
    }
}

package com.example.assignment4;


import java.util.Random;

        import javafx.application.Application;
        import javafx.geometry.Insets;
        import javafx.geometry.Pos;
        import javafx.scene.Scene;
        import javafx.scene.control.Label;
        import javafx.scene.image.Image;
        import javafx.scene.image.ImageView;
        import javafx.scene.layout.BorderPane;
        import javafx.scene.layout.FlowPane;
        import javafx.scene.layout.HBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class TestAssignment4 extends Application {
    final int NUM_CARDS_PER_HAND = 7;
    final int NUM_PLAYERS = 2;
    Image[] humanImages = new Image[NUM_CARDS_PER_HAND];
    ImageView[] humanViews = new ImageView[NUM_CARDS_PER_HAND];
    Image[] computerImages = new Image[NUM_CARDS_PER_HAND];
    ImageView[] computerViews = new ImageView[NUM_CARDS_PER_HAND];
    Image[] playedImages = new Image[NUM_CARDS_PER_HAND];
    ImageView[] playedViews = new ImageView[NUM_CARDS_PER_HAND];
    Label[] playLaberText = new Label[NUM_PLAYERS+1];

    public static void main(String[] args) {
        launch(args);
    }

    static Random r = new Random();

    static Card generateRandomCard() {
        Card randomCard = new Card(GUICard.turnIntIntoCardValueChar
                (r.nextInt(14)), GUICard.turnIntIntoCardSuit(r.nextInt(4)));
        return randomCard;
    }

    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        Scene scene = new Scene(pane, 800, 600);
        primaryStage.setTitle("Card Table");
        primaryStage.setScene(scene);
        CardTable ct = new CardTable();

        for (int i = 0; i < 7; i++) {
            Card randomCard = generateRandomCard();
            humanImages[i] = GUICard.getImage(randomCard);
            humanViews[i] = new ImageView(humanImages[i]);
            ct.getHumanPane().getChildren().add(humanViews[i]);

            Card randomCard2 = generateRandomCard();
            computerImages[i] = GUICard.getImage(randomCard2);
            computerViews[i] = new ImageView(computerImages[i]);
            ct.getComputerPane().getChildren().add(new ImageView(GUICard.imageBack()));
        }
        Card randomCard3 = generateRandomCard();
        playedImages[0]=GUICard.getImage(randomCard3);
        playedViews[0]=new ImageView(playedImages[0]);
        ct.getPlayedPane().getChildren().add(playedViews[0]);


        Card randomCard4 = generateRandomCard();
        playedImages[1]=GUICard.getImage(randomCard4);
        playedViews[1]=new ImageView(playedImages[1]);
        ct.getPlayedPane().getChildren().add(playedViews[1]);

        playLaberText[0]=new Label("You");
        ct.getPlayedPane().getChildren().add(playLaberText[0]);
        playLaberText[1]=new Label("Computer");
        ct.getPlayedPane().getChildren().add(playLaberText[1]);

//        Card randomCard5 = generateRandomCard();
//        playedImages[2]=GUICard.getImage(randomCard5);
//        playedViews[2]=new ImageView(playedImages[2]);
//        ct.getPlayedPane().getChildren().add(playedViews[2]);
//        playLaberText[2]=new Label("Another");
//        ct.getPlayedPane().getChildren().add(playLaberText[2]);



        pane.setTop(ct.getComputerPane());
        pane.setCenter(ct.getPlayedPane());
        pane.setBottom(ct.getHumanPane());
        primaryStage.show();
    }
}


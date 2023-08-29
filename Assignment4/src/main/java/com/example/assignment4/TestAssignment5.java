package com.example.assignment4;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.Random;

public class TestAssignment5 extends Application {
    final int NUM_CARDS_PER_HAND = 7;
    final int NUM_PLAYERS = 2;
    Image[] humanImages = new Image[NUM_CARDS_PER_HAND];
    ImageView[] humanViews = new ImageView[NUM_CARDS_PER_HAND];
    Image[] computerImages = new Image[NUM_CARDS_PER_HAND];
    ImageView[] computerViews = new ImageView[NUM_CARDS_PER_HAND];
    Image[] playedImages = new Image[NUM_CARDS_PER_HAND];
    ImageView[] playedViews = new ImageView[NUM_CARDS_PER_HAND];
    Label[] playLabelText = new Label[NUM_PLAYERS];

    public static void main(String[] args) {
        launch(args);
    }
    static Random r=new Random();
    static Card generateRandomCard(){
        Card card=new Card(GUICard.turnIntIntoCardValueChar(r.nextInt(14)), GUICard.turnIntIntoSuit(r.nextInt(4)));
        return card;
    }
    public void start(Stage primaryStage) {
        // Create the scene and place it in the stage
        BorderPane pane = new BorderPane();
        Scene scene = new Scene(pane, 800, 600);
        primaryStage.setTitle("Card Table");
        primaryStage.setScene(scene);
        CardTable ct=new CardTable();



        for (int i = 0; i < NUM_CARDS_PER_HAND; i++) {
            Button btn=new Button();
            Card hcard = generateRandomCard();
            humanImages[i] = GUICard.getImage(hcard);
            humanViews[i] = new ImageView(humanImages[i]);


            btn.setGraphic(humanViews[i]);
            ct.getHumanPane().getChildren().add(btn);

            Card ccard = generateRandomCard();
            computerImages[i] = GUICard.getImage(ccard);
            computerViews[i] = new ImageView(computerImages[i]);

            ct.getComputerPane().getChildren().add(new ImageView(computerImages[i]));

            //ct.getComputerPane().getChildren().add(new ImageView(GUICard.imageBack()));

            Image hTemp =humanImages[i];
            Image cTemp =computerImages[i];
            btn.setOnAction(new EventHandler<ActionEvent>() {

                public void handle(ActionEvent arg0) {
                    moveCard(cTemp,
                            hTemp, ct.getPlayedPane());
//                    moveCard(computerImages[i]),
//                            humanImages[i]);
                }
            });
        }

//        for (int i = 0; i < NUM_CARDS_PER_HAND; i++) {
//            playedImages[i]=GUICard.getImage(generateRandomCard());
//            playedViews[i]=new ImageView(playedImages[i]);
//        }


//        ct.getPlayedPane().getChildren().add(playLabelText[0]);
//        ct.getPlayedPane().getChildren().add(playLabelText[1]);

       moveCard(computerImages[r.nextInt(NUM_CARDS_PER_HAND)], humanImages[r.nextInt(NUM_CARDS_PER_HAND)], ct.getPlayedPane());



        pane.setTop(ct.getComputerPane());
        pane.setCenter(ct.getPlayedPane());
        pane.setBottom(ct.getHumanPane());
        // show everything to the user
        primaryStage.show();
    }
    private void moveCard(Image cTemp, Image hTemp, FlowPane pPane){
        pPane.getChildren().clear();

        ImageView humanIv=new ImageView(hTemp);
        pPane.getChildren().add(humanIv);
        ImageView computerIv=new ImageView(cTemp);
        pPane.getChildren().add(computerIv);
        playLabelText[0]=new Label("you");
        playLabelText[1]=new Label("	  computer");

        pPane.getChildren().add(playLabelText[0]);
        pPane.getChildren().add(playLabelText[1]);
    }
}




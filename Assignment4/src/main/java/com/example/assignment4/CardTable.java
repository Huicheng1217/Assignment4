package com.example.assignment4;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

public class CardTable {
    HBox computerPane=new HBox(500);
    HBox humanPane=new HBox();
    FlowPane playedPane=new FlowPane(150,15);

    public CardTable(){
        playedPane.setPadding(new Insets(100,200,100,200));
        playedPane.setAlignment(Pos.CENTER);
        playedPane.setStyle("-fx-border-color:blue");
    }
    public HBox getComputerPane(){
        computerPane.setSpacing(10);
        return computerPane;
    }
    public void setComputerPane(HBox computerPane){
        this.computerPane=computerPane;
    }
    public HBox getHumanPane(){
        humanPane.setSpacing(10);
        return humanPane;
    }
    public void setHumanPane(HBox humanPane){
        this.humanPane=humanPane;
    }
    public FlowPane getPlayedPane(){
        return playedPane;
    }
    public void setPlayedPane(FlowPane playedPane){
        this.playedPane=playedPane;
    }

}

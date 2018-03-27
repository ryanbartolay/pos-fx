package com.ryan.pos.pane;

import java.util.ArrayList;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class GUI extends Pane {

    private boolean up = false;
    private boolean down = false;
    private boolean left = false;
    private boolean right = false;
    private boolean spacebar = false;
    private boolean shift = false;
    private boolean ctrl = false;

    private double mouseX;
    private double mouseY;

    public GUI(int width, int height) {
        super();
        setStyle("-fx-background-color: black;");
        setPrefSize(width, height);

        ArrayList<Node> things = new ArrayList<>();
        getChildren().addAll(things);

//        setOnKeyPressed(this);
//        setOnKeyTyped(this);
//        setOnKeyReleased(this);
    }
}
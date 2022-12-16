package gameOfCraps;

import eightQueens.Run;
import processing.core.PApplet;

public class Test_RollDice_001 extends PApplet {

    RollDice r;

    public static void main(String[] args) {
        PApplet.main("gameOfCraps.Test_RollDice_001", args);
    }

    public void settings(){
        size(800, 800);
    }

    public void setup(){
        r = new RollDice();
        r.diceRoll();
    }

    public void draw(){
        background(255);
        r.display(this);
    }

    public void mousePressed(){
        r.diceRoll();
    }

}

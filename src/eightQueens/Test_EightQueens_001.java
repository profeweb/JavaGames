package eightQueens;

import processing.core.PApplet;

public class Test_EightQueens_001 extends PApplet {

    Run r;

    public static void main(String[] args) {
        PApplet.main("eightQueens.Test_EightQueens_001", args);
    }

    public void settings(){
        size(800, 800);
    }

    public void setup(){
        r = new Run();
        r.PlaceQueens();
        r.display(this);
    }

}

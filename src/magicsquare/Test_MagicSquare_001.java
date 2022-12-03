package magicsquare;


import processing.core.PApplet;

public class Test_MagicSquare_001 extends PApplet {

    MagicSquare m;

    public static void main(String[] args) {
        PApplet.main("magicsquare.Test_MagicSquare_001", args);
    }

    public void settings(){
        size(800, 800);
    }

    public void setup(){
        background(255);
        m = new MagicSquare();

        while(!m.IsMagicSquare()) {
            m.nextTry();
        }
        m.displayBoard(this, 50, 50, width - 100, height - 100);
        m.displayTries(this, 50, 30);
        noLoop();
    }

}
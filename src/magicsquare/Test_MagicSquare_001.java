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
        frameRate(120);
        background(255);
        m = new MagicSquare();
    }

    public void draw(){
        background(255);
        m.displayBoard(this, 50, 50, width-100, height-100);
        m.displayTries(this, 50, 30);
        m.displayMagicSquare(this, width-50, 30);
        if(!m.IsMagicSquare() && m.nextTry){
            m.nextTry();
        }
    }

    public void keyPressed(){
        if(key=='n' || key=='N'){
            m.nextTry = !m.nextTry;
        }
    }

}
package magicsquare;

import processing.core.PApplet;

public class Test_MagicSquare_002 extends PApplet {

    MagicSquareN m;

    int[][] ok4 = {{1, 15, 14, 4},
                   {10, 11, 8, 5},
                   {7, 6, 9, 12},
                   {16, 2, 3, 13}};

    int[][] ok5 = {{17, 24, 1, 8, 15},
                   {23, 5, 7, 14, 16},
                   {4, 6, 13, 20, 22},
                   {10, 12, 19, 21,3},
                   {11, 18, 25, 2, 9}};

    public static void main(String[] args) {
        PApplet.main("magicsquare.Test_MagicSquare_002", args);
    }

    public void settings(){
        size(800, 800);
    }

    public void setup(){
        background(255);
        m = new MagicSquareN(5);  //3, 4, 5, ...
        m.setInitial(ok5);

        while(!m.IsMagicSquare()) {
           m.nextTry();
           m.displayBoard();
        }

        m.displayBoard(this, 50, 50, width - 100, height - 100);
        m.displayTries(this, 50, 30);
        noLoop();
    }

}
package knightTour;

import processing.core.PApplet;

public class Test_KnighTourBT extends PApplet {

    public static void main(String[] args) {
        PApplet.main("knightTour.Test_KnighTourBT", args);
    }

    public void settings(){
        size(800, 800);
    }

    public void setup(){

        KnightBT.solveKT();
        KnightBT.display(this);

    }

}

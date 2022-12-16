package gameOfCraps;

import processing.core.PApplet;
import processing.core.PShape;

import java.util.Random;

import static processing.core.PConstants.CENTER;

public class RollDice {

	private Random rand = new Random();
	private int die1;
    private int die2;
    
    public int diceRoll() {
    	die1 = rand.nextInt(6) + 1;
        die2 = rand.nextInt(6) + 1;
        
        return die1 + die2;
    }

    public void display(PApplet p5){
        PShape d1 = p5.loadShape("dados-0"+die1+".svg");
        PShape d2 = p5.loadShape("dados-0"+die2+".svg");
        float size = 250;
        p5.shapeMode(CENTER);
        p5.shape(d1, p5.width/4, p5.height/2, size, size);
        p5.shape(d2, 3*p5.width/4, p5.height/2, size, size);
    }
}

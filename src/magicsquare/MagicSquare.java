package magicsquare;

import processing.core.PApplet;

import java.util.Random;

import static processing.core.PConstants.*;

public class MagicSquare {

    private static Random rand = new Random();
    int[][] numbers = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    int counter;

    public MagicSquare(){
        this.counter = 0;
    }

    public void nextTry(){
        counter++;
        SwitchCells();
    }

    public boolean IsMagicSquare() {

        int tempSum = numbers[0][0] + numbers[0][1] + numbers[0][2];

        for (int i = 1; i < 3; i++) {
            if (numbers[i][0] + numbers[i][1] + numbers[i][2] != tempSum)
                return false;
        }

        for (int i = 0; i < 3; i++) {
            if (numbers[0][i] + numbers[1][i] + numbers[2][i] != tempSum)
                return false;
        }

        return numbers[0][0] + numbers[1][1] + numbers[2][2] == tempSum &&
                numbers[0][2] + numbers[1][1] + numbers[2][0] == tempSum;
    }

    private void SwitchCells() {

        int[] number1 = new int[2];
        int[] number2 = new int[2];

        number1[0] = rand.nextInt(3);
        number1[1] = rand.nextInt(3);
        number2[0] = rand.nextInt(3);
        number2[1] = rand.nextInt(3);

        int temp = numbers[number1[0]][number1[1]];
        numbers[number1[0]][number1[1]] = numbers[number2[0]][number2[1]];
        numbers[number2[0]][number2[1]] = temp;
    }

    public void displayBoard(PApplet p5, float x, float y, float w, float h){

        float wCell = w / 3;
        float hCell = h / 3;

        for (int f = 0; f < 3; f++) {
            for (int c = 0; c < 3; c++) {
                p5.fill(200);
                p5.rect(x + c*wCell, y + f*hCell, wCell, hCell);
                p5.fill(0); p5.textAlign(CENTER); p5.textSize(54);
                p5.text(numbers[f][c], x + c*wCell + wCell/2, y + f*hCell + hCell/2);
            }
        }
    }

    public void displayTries(PApplet p5, float x, float y){
        p5.fill(0); p5.textSize(24); p5.textAlign(LEFT);
        p5.text("Tries: "+this.counter, x, y);
    }

}

package magicsquare;

import processing.core.PApplet;
import java.util.Random;

import static processing.core.PConstants.CENTER;
import static processing.core.PConstants.LEFT;

public class MagicSquareN {

    private static Random rand = new Random();
    int[][] numbers;
    int counter;

    public MagicSquareN(int n){
        this.counter = 0;
        numbers = new int[n][n];
        int i=1;
        for(int f=0; f<n; f++){
            for(int c=0; c<n; c++){
                numbers[f][c]=i;
                i++;
            }
        }
    }

    public void setInitial(int[][] initial){
        numbers = initial;
    }

    public void nextTry(){
        counter++;
        SwitchCells();
    }

    public boolean IsMagicSquare() {

        int tempSum = 0;
        for(int c=0; c<numbers.length; c++) {
            tempSum += numbers[0][c];
        }


        for (int i = 1; i < numbers.length; i++) {
            int tempLine = 0;
            for(int c=0; c<numbers.length; c++) {
                tempLine += numbers[i][c];
            }
            if(tempLine != tempSum){
                return false;
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            int tempCol = 0;
            for(int l=0; l<numbers.length; l++){
                tempCol += numbers[l][i];
            }
            if (tempCol != tempSum) {
                return false;
            }
        }

        int diagonal1 =0;
        for (int i = 0; i < numbers.length; i++) {
            diagonal1 += numbers[i][i];
        }

        int diagonal2 =0;
        for (int i = 0; i < numbers.length; i++) {
            diagonal2 += numbers[i][numbers.length-i-1];
        }

        return diagonal1 == tempSum && diagonal2 == tempSum;
    }

    private void SwitchCells() {

        int[] number1 = new int[numbers.length];
        int[] number2 = new int[numbers.length];

        number1[0] = rand.nextInt(numbers.length);
        number1[1] = rand.nextInt(numbers.length);
        number2[0] = rand.nextInt(numbers.length);
        number2[1] = rand.nextInt(numbers.length);

        int temp = numbers[number1[0]][number1[1]];
        numbers[number1[0]][number1[1]] = numbers[number2[0]][number2[1]];
        numbers[number2[0]][number2[1]] = temp;
    }

    public void displayBoard(PApplet p5, float x, float y, float w, float h){

        float wCell = w / numbers.length;
        float hCell = h / numbers.length;

        for (int f = 0; f < numbers.length; f++) {
            for (int c = 0; c < numbers.length; c++) {
                p5.fill(200);
                p5.rect(x + c*wCell, y + f*hCell, wCell, hCell);
                p5.fill(0); p5.textAlign(CENTER); p5.textSize(54);
                p5.text(numbers[f][c], x + c*wCell + wCell/2, y + f*hCell + hCell/2);
            }
        }
    }

    public void displayBoard() {
        System.out.println("-----------");
        for (int i = 0; i < numbers.length; i++) {
            for (int c = 0; c < numbers.length; c++) {
                System.out.print(numbers[i][c] + " ");
            }
            System.out.println("");
        }
    }

    public void displayTries(PApplet p5, float x, float y){
        p5.fill(0); p5.textSize(24); p5.textAlign(LEFT);
        p5.text("Tries: "+this.counter, x, y);
    }

}

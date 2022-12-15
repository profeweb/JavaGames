package eightQueens;

import processing.core.PApplet;
import processing.core.PShape;

import static processing.core.PConstants.CENTER;

public class Board {

	public static final char BOARD_CHAR = '.';
	public static final char QUEEN_CHAR = 'X';
	public char[][] board;

    PShape queen;
	
	public Board() {
      board = new char[8][8];
    }
	
	public void displayBoard() {
      for (int i = 0; i < 8; i++) {
        for (int c = 0; c < 8; c++) {
        	System.out.print(board[i][c] + "  ");
        }
        System.out.println();
        System.out.println();
      }
    }

    public void displayBoard(PApplet p5, float x, float y, float w, float h){

        float wCell = w / board.length;
        float hCell = h / board[0].length;
        PShape queen = p5.loadShape("queen.svg");

        for(int f=0; f<board.length; f++){
            for(int c=0; c<board[f].length; c++){
                float xc = x + wCell*c;
                float yc = y + hCell*f;
                if((f+c)%2==0) {
                    p5.fill(p5.color(244, 151, 110));
                }
                else {
                    p5.fill(p5.color(42, 64, 137));
                }
                p5.rect(xc, yc, wCell, hCell);
                if(board[f][c]==QUEEN_CHAR){
                    p5.shapeMode(CENTER);
                    p5.shape(queen, xc + wCell/2, yc + hCell/2, wCell*0.7f, hCell*0.7f);
                }

            }
        }
    }
	
	public void init() {
      for (int i = 0; i < 8; i++) {
        for (int c = 0; c < 8; c++) {
          board[i][c] = BOARD_CHAR;
        }
      }
    }
}

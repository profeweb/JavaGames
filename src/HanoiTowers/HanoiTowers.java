package HanoiTowers;

import processing.core.PApplet;

public class HanoiTowers extends PApplet {

    int N = 8;

    char[] noms = {'A', 'B', 'C'};
    Tower[] torres;

    public static int altura = 50;


    public static void main(String[] args) {
        PApplet.main("HanoiTowers.HanoiTowers", args);
    }
    public void settings(){
        size(1800, 800);
    }

    public void setup(){
        colorMode(HSB, 255);
        initTowers(N);
        initDiscs(N);
    }

    public void initTowers(int n){
        torres = new Tower[3];
        for(int i=0; i<torres.length; i++) {
            torres[i] = new Tower(noms[i], n);
        }
    }

    public void initDiscs(int n){
        for(int i=n-1; i>=0; i--){
            torres[0].addDisc(new Disc(i+1, color(i*25, 255, 255)));
        }
    }

    public void draw(){
        background(255);
        int i=0;
        for(Tower t : torres){
            t.display(this, (i+1)*width/4, 200);
            i++;
        }
    }

    public void keyPressed(){

    }

}

package HanoiTowers;

import processing.core.PApplet;

public class HanoiTowers extends PApplet {

    int N = 3;
    int step = N;

    char[] noms = {'A', 'B', 'C'};
    Tower[] torres;

    int numMoviments=0;
    Moviment[] moviments;
    int movimentActual = -1;

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
        initMoviments(N);
        hanoi(N, torres[0], torres[2], torres[1]);
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

    public void initMoviments(int n){
        moviments = new Moviment[(int) (pow(2, n)+1)];
    }

    public void moviment(Tower tOrigen, Tower tDesti){
        System.out.println("Mou disc de " + tOrigen.nom + " a " + tDesti.nom);
        moviments[numMoviments] = new Moviment(tOrigen, tDesti);
        numMoviments++;
    }

    public void mou(Moviment m){
        Disc d = m.tOrigen.extractDisc();
        m.tDesti.addDisc(d);
    }

    public void draw(){
        background(255);
        int i=0;
        for(Tower t : torres){
            t.display(this, (i+1)*width/4, 200);
            i++;
        }

        fill(0); textSize(18);
        text("Num Moviments: "+ (movimentActual+1)+ "/" + numMoviments, width/2, height -100);
    }

    public void hanoi(int n, Tower tOrigen, Tower tDesti, Tower tAuxiliar){
        if(n==0){
            return;
        }
        hanoi(n - 1, tOrigen, tAuxiliar, tDesti);
        moviment(tOrigen, tDesti);
        hanoi(n - 1, tAuxiliar, tDesti, tOrigen);
    }

    public void keyPressed(){
        if(movimentActual<moviments.length-1) {
            movimentActual++;
            mou(moviments[movimentActual]);
        }
    }

}

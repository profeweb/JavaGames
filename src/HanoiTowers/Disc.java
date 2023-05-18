package HanoiTowers;

import processing.core.PApplet;

import static HanoiTowers.HanoiTowers.altura;

public class Disc {

    int mida;
    int color;

    public Disc(int m, int c){
        this.mida = m;
        this.color = c;
    }

    void display(PApplet p5, float x, float y){
        p5.fill(color);
        p5.rectMode(p5.CENTER);
        p5.rect(x, y, mida*50, altura);
    }
}

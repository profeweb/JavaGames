package HanoiTowers;

import processing.core.PApplet;

import static HanoiTowers.HanoiTowers.altura;

public class Tower {

    Disc[] discos;
    char nom;

    public Tower(char nom, int n){
        this.nom = nom;
        this.discos = new Disc[n];
    }

    public void addDisc(Disc d){
        for(int i=discos.length-1; i>=0; i--){
            if(discos[i] == null){
                discos[i] = d;
                break;
            }
        }
    }

    public Disc extractDisc(){
        for(int i=0; i<discos.length; i++){
            if(discos[i] != null){
                Disc d = discos[i];
                discos[i] = null;
                return d;
            }
        }
        return null;
    }

    public void display(PApplet p5, float x, float y){
        p5.fill(0); p5.textSize(48); p5.textAlign(p5.CENTER);
        p5.text(this.nom, x, y - 2*altura);
        p5.stroke(0);
        p5.line(x, y - altura, x, y + discos.length*altura);
        int i=0;
        for(Disc d : discos){
            if(d!=null) {
                d.display(p5, x, y + i * altura);
            }
            i++;
        }
    }
}

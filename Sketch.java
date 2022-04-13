import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
	

  float dvdposx;
  float dvdposy;
  float Xspeed = 15;
  float Yspeed = 0;
  float wave = 0;
  int move = 10;
  


  public void settings() {
	// put your size call here
    size(800, 800);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(255,255,255);
    PImage fabroa = loadImage("Fabroa.jpg");
    fabroa.resize(width, height);
    image(fabroa, 0, 0);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {

    PImage fabroa = loadImage("Fabroa.jpg");
    fabroa.resize(width, height);
    image(fabroa, 0, 0);

    wave += (Math.PI/6);
    Yspeed = (float)(Math.sin(wave)) * 3;

    dvdposx += Xspeed;
    dvdposy += move + Yspeed;

    
    if(dvdposx > width - (width / 3) || dvdposx < 0){
      Xspeed *= -1;
    }
    if(dvdposy < 0 || dvdposy > height - (height /6)){
      Yspeed *= -1;
      move *= -1;
    }






    PImage dvdLogo = loadImage("DVD.png");
    dvdLogo.resize(width / 3, height / 6);
    image(dvdLogo, dvdposx, dvdposy);

  }
  
  // define other methods down here.
}
/**
 * A code to display a picture of Mr fabroa in the backround while a dvd logo bounces around the screen 
 * in a wave pattern 
 * Author: @Jenusan Y
 */

import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
	

  float dvdposx;
  float dvdposy;
  float Xspeed = 15;
  float Yspeed;
  float wave;
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
    // sets up backround image to be Mr.Fabroa 
    PImage fabroa = loadImage("Fabroa.jpg");
    fabroa.resize(width, height);
    image(fabroa, 0, 0);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    // replaces Backround photo every run through so trail is not left behind
    PImage fabroa = loadImage("Fabroa.jpg");
    fabroa.resize(width, height);
    image(fabroa, 0, 0);

    // processes sinocoidal fucntion so that the DVD logo can move in a wave motion
    wave += (Math.PI/6);
    Yspeed = (float)(Math.sin(wave)) * 3;

    // changes the X and Y position of the image each time the method is ran though, so that image can move
    dvdposx += Xspeed;
    dvdposy += move + Yspeed;
    
    // reverses direction of motion of animation once a barrier is reached 
    if(dvdposx > width - (width / 3) || dvdposx < 0){
      Xspeed *= -1;
    }
    if(dvdposy < 0 || dvdposy > height - (height /6)){
      Yspeed *= -1;
      move *= -1;
    }
    
    // prints DVD logo on screen using all past conditions and values
    PImage dvdLogo = loadImage("DVD.png");
    dvdLogo.resize(width / 3, height / 6);
    image(dvdLogo, dvdposx, dvdposy);

  }
  
  // define other methods down here.
}
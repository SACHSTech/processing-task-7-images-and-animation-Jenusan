/**
 * A code to display a picture of Mr fabroa in the backround while a dvd logo bounces around the screen 
 * in a wave pattern 
 * Author: @Jenusan Y
 */

import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
	// initializing varibales
  float fltDVDPosX;
  float fltDVDPosY;
  float fltDVDXSpeed = 15;
  float fltDVDYSpeed;
  float fltWave;
  float fltDVDMove = 10;
  float fltCircPosX = 150;
  float fltCircPosY = 100;
  float fltCircXSpeed = 20;
  float fltCircMove = 18;
  float fltCircYSpeed;
  float fltRed;
  float fltGreen;
  float fltBlue; 

  public void settings() {
	// put your size call here
    size(800, 800);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    // sets up backround image to be Mr.Fabroa, and scales to size of screen
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
    fltWave += (Math.PI/6);
    fltDVDYSpeed = (float)(Math.sin(fltWave)) * 10;
    
    // reverses direction of motion of animation once a barrier is reached 
    if(fltDVDPosX > width - (width / 3) || fltDVDPosX < 0){
      fltDVDXSpeed *= -1;
    }
    if(fltDVDPosY < 0 || fltDVDPosY > height - (height /6)){
      fltDVDYSpeed *= -1;
      fltDVDMove *= -1;
    }

    // adds values to the X and Y position of the image each time the method is ran though, so that image can move
    fltDVDPosX += fltDVDXSpeed;
    fltDVDPosY += fltDVDMove + fltDVDYSpeed;
    
    // prints DVD logo on screen using all above conditions and values
    PImage dvdLogo = loadImage("DVD.png");
    dvdLogo.resize(width / 3, height / 6);
    image(dvdLogo, fltDVDPosX, fltDVDPosY);

    // processes sinocoidal fucntion so that the Circle can move in a wave motion
    fltCircYSpeed = (float)(Math.sin(fltWave)) * 10;
    
    // reverses direction of motion of animation once a barrier is reached, and processes random function to be applied to color of circle 
    if (fltCircPosX - 40 < 0 || fltCircPosX + 40> width) {
      fltCircXSpeed *= -1;
      fltRed = random(0,255);
      fltGreen = random(0,255);
      fltBlue = random(0,255);
    }
    if (fltCircPosY - 40 < 0  || fltCircPosY + 40 > height) {
      fltCircYSpeed *= -1;
      fltCircMove *= -1;
      fltRed = random(0,255);
      fltGreen = random(0,255);
      fltBlue = random(0,255);
  }

  // changes the X and Y position of the image each time the method is ran though, so that image can move through animation path
  fltCircPosX += fltCircXSpeed;
    fltCircPosY += fltCircMove + fltCircYSpeed;

  // prints circle on screen using above values, and inputs values into fill method
  fill(fltRed, fltGreen, fltBlue);
  ellipse(fltCircPosX, fltCircPosY, 80, 80);
}
}
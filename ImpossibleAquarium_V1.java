import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.sound.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class ImpossibleAquarium_V1 extends PApplet {

// Art185AI Final Project
// Daniel Karnofel
// - - - - - - - - - - - - - - - - - - - -
// BigGAN used for image generation 
// - - - - - - - - - - - - - - - - - - - -

// - - - - - - - - - - - - - - - - - - - -

public void setup(){
  
  
  
  createFish();
  
  initializeFish();
  
  createBubbles();
  
  //sound();
  
}

public void draw(){
  
  waterBackground();
  
  drawFish();
  
  drawBubbles();
  
  waterForeground();
  
  //loopSound();
  
}
// - - - - - - - - - - - - - 

int bubbleCount = 50;
Bubble[] bubbles;
float maxSize = 15;

// - - - - - - - - - - - - - 

public void createBubbles(){
    
  bubbles = new Bubble[bubbleCount];
  for(int i = 0; i < bubbleCount; i++){
    bubbles[i] = new Bubble(random(width), random(height), random(maxSize));
  } 
}

public void drawBubbles(){
  
  for(int i = 0; i < bubbles.length; i++){
    bubbles[i].rise();
  }
  
}

// - - - - - - - - - - - - 

class Bubble{

  float x, y, size;
  
  // - - - - - - - - - - - - - 
  
  Bubble(float x_, float y_, float size_){
    x = x_;
    y = y_;
    size = size_;
  }
  
  // - - - - - - - - - - - - - 
  
  public void rise(){
    
    float xoff = 0.1f;
    x += map(noise(xoff), 0, 1, -1, 1);
    y -= 5*(size/maxSize)*(1.5f-y/height);
    
    if(y < 0){
      x = random(width);
      y = height-2*maxSize;
      size = random(maxSize);
    }
    
    stroke(175, 188, 209, 100);
    fill(218, 226, 239, 50);
    ellipse(x, y, size, size);
    
  }
  
}
  
  
// - - - - - - - - - - - - - 

Fish fish1, fish2, fish3, fish4, fish5, fish6, fish7, fish8, fish9, fish10, fish11, fish12, fish13, fish14;
PImage img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12, img13, img14;

// - - - - - - - - - - - - - 

class Fish {
  PImage img;
  float x, y;
  float direction;
  float size, speed;
  
  // - - - - - - - - - - - - 
  
  Fish(PImage img_){ 
    img = img_;
  }
  
  // - - - - - - - - - - - - 
  
  public void initialize(){
    float n = random(1);
    if(n > 0.5f){
      direction = 1;
    } else {
      direction = -1;
    }
    size = random(10, 50);
    x = random(-2*width, 3*width);
    y = random(size, height-size);
    speed = 1;
  }
  
  public void swim(){
    
    float soff = 0;
    soff += 1/size;
    speed = map(noise(soff), 0, 1, 1, 10);
    x += speed*direction;
    y += sin(0.05f*x);
    
    if(x > 3*width){
      x = 3*width;
      direction = -direction;
    } else if(x < -2*width){
      x = -2*width;
      direction = -direction;
    }
    
    imageMode(CENTER);
    if(direction > 0){
      image(img, x, y, size*img.width/512, size*img.height/512);
    } else if(direction < 0){
      pushMatrix();
      scale(-1, 1);
      image(img, -x, y, size*img.width/512, size*img.height/512);
      popMatrix();
    }
       
  }
  
}

// - - - - - - - - - - - - 

public void createFish(){
  
  img1 = loadImage("images/fish1.png");
  fish1 = new Fish(img1);
  
  img2 = loadImage("images/fish2.png");
  fish2 = new Fish(img2);
  
  img3 = loadImage("images/fish3.png");
  fish3 = new Fish(img3);
  
  img4 = loadImage("images/fish4.png");
  fish4 = new Fish(img4);
  
  img5 = loadImage("images/fish5.png");
  fish5 = new Fish(img5);
  
  img6 = loadImage("images/fish6.png");
  fish6 = new Fish(img6);
  
  img7 = loadImage("images/fish7.png");
  fish7 = new Fish(img7);
  
  img8 = loadImage("images/fish8.png");
  fish8 = new Fish(img8);
  
  img9 = loadImage("images/fish9.png");
  fish9 = new Fish(img9);
  
  img10 = loadImage("images/fish10.png");
  fish10 = new Fish(img10);
  
  img11 = loadImage("images/fish11.png");
  fish11 = new Fish(img11);
  
  img12 = loadImage("images/fish12.png");
  fish12 = new Fish(img12);
  
  img13 = loadImage("images/fish13.png");
  fish13 = new Fish(img13);
  
  img14 = loadImage("images/fish14.png");
  fish14 = new Fish(img14);
  
}

// - - - - - - - - - - - - 

public void initializeFish(){
  fish1.initialize();
  fish2.initialize();
  fish3.initialize();
  fish4.initialize();
  fish5.initialize();
  fish6.initialize();
  fish7.initialize();
  fish8.initialize();
  fish9.initialize();
  fish10.initialize();
  fish11.initialize();
  fish12.initialize();
  fish13.initialize();
  fish14.initialize();
}

// - - - - - - - - - - - - 

public void drawFish(){
  fish1.swim();
  fish2.swim();
  fish3.swim();
  fish4.swim();
  fish5.swim();
  fish6.swim();
  fish7.swim();
  fish8.swim();
  fish9.swim();
  fish10.swim();
  fish11.swim();
  fish12.swim();
  fish13.swim();
  fish14.swim();
}

SoundFile sound;

// - - - - - - - - - - - - 

public void sound(){
  
  sound = new SoundFile(this, "sound/classical.mp3");
  sound.play();
  
}

// - - - - - - - - - - - - 

public void loopSound(){
  
  if(!sound.isPlaying()){
    sound.play();
  }
}
// - - - - - - - - - - - - 

public void waterBackground(){

  for(int i = 0; i < height; i++){
    int wColor = 200 - 200*i/height;
    stroke(0, 0, wColor);
    line(0, i, width, i);
  } 
}

// - - - - - - - - - - - - 

public void waterForeground(){
  
  for(int i = 0; i < height; i++){
    int wColor = 255 - 255*i/height;
    stroke(0, 0, wColor, 50);
    line(0, i, width, i);

  } 
}
  
  
  public void settings() {  size(1000, 700); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "ImpossibleAquarium_V1" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}

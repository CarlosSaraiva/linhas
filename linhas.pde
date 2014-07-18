import beads.*;
import java.util.Arrays; 

LThread threads[] = new LThread[12];
int velocity = 1; //int(random(10));
int wait = 10;
int position = 50;
AudioContext ac;

void setup(){
  size(650, 300);
  background(255);
  frameRate(60); 

  ac = new AudioContext();

  Oscilator osc = new Oscilator(ac, 440.);
  ac.start();

    
  for(int i = 0; i < threads.length; i++){
    threads[i] = new LThread(int(random(100)), "linha: " + i, new Linha(position, 0., height, 1, true));
    threads[i].start(); 
    position += 50;
  }
}

void draw(){
  background(255);
  fill(0);
  
  for(int i = 0; i < threads.length; i++){
   threads[i].draw(); 
  }
}

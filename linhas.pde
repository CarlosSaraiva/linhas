import beads.*;
import java.util.Arrays; 

LThread threads[] = new LThread[20];
int velocity = (1); //int(random(10)); 

void setup(){
  size(400, 300);
  background(255);
  frameRate(60); 
    
  for(int i = 0; i < threads.length; i++){
    threads[i] = new LThread(velocity, "linha: " + i, new Linha(random(400), 0., height, 1, true));
    threads[i].start(); 
  }
}

void draw(){
  background(255);
  fill(0);
  
  for(int i = 0; i < threads.length;i++){
   threads[i].draw(); 
  }
}

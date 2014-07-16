import beads.*;
import java.util.Arrays; 

LThread threads[] = new LThread[6];
int time = (1); //int(random(10)); 

void setup(){
  size(400, 300);
  background(255);
  frameRate(60); 
    
  for(int i = 0; i < threads.length; i++){
    threads[i] = new LThread(int(random(4)), "linha: " + i, new Linha(random(400), 0., height, 0.1, true));
    threads[i].start(); 
  }
}

void draw(){
  background(255);
  fill(0);
  
  for(int i = 0; i < threads.length;i++){
   threads[i].draw(); 
  }
  //Desenhar apenas 4 threads. 
  //Quando uma chegar a zero, iniciar outra
}

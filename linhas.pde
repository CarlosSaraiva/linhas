import beads.*;
import java.util.Arrays; 

Linha linha1 = new  Linha(300/2, 400/2, 400, 5, true);
Linha linha2 = new  Linha(200, 300, 400, 5, true);
LThread thread1 = new LThread(100,"linha1", linha1);
LThread thread2 = new LThread(200,"linha1", linha2);


void setup(){
  size(400, 300);
  background(255);
  frameRate(60);
 
  thread1.start();
  thread2.start();

}

void draw(){
  background(255);
  fill(0);

  int a = thread1.getCount();
  text(a,10,50);
  thread1.draw();
  int b = thread2.getCount();
  text(b,10,150);
  thread2.draw();
}

import beads.*;
import java.util.Arrays; 

Linha linha = new  Linha(300/2, 400/2, 400, 5, true);
LThread thread1 = new LThread(100,"linha1", linha);
AudioContext ac;

void setup(){
  size(400, 300);
  background(255);
  frameRate(60);
  // //linha[0] = new Linha(height/2, width/2, width, 5, true);
  // linha[1] = new Linha(height/2, 100, width, 5, true);

  thread1.start();
  //thread2.start();

  //AUDIO
  ac = new  AudioContext();
  
  
  
  
  
  
  
  
  
  
  WavePlayer freqModulator = new WavePlayer(ac, 1000, Buffer.SINE);
  Function function = new Function(freqModulator){
  	public float calculate(){
  		return x[0] * 500.0 + 700.0;
  	}
  };
  WavePlayer wp = new WavePlayer(ac, function, Buffer.SINE);
  Gain g = new Gain(ac, 1, 0.1);
  g.addInput(wp);
  ac.out.addInput(g);
  ac.start();

}

void draw(){
  background(255);
  fill(0);

  int a = thread1.getCount();
  text(a,10,50);
  linha.draw();
  // int b = thread2.getCount();
  // text(b,10,150);
}

import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import beads.*; 
import java.util.Arrays; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class linhas extends PApplet {


 

LThread threads[] = new LThread[12];
int velocity = 1; //int(random(10));
int wait = 10;
int position = 50;
AudioContext ac;

public void setup(){
  size(650, 300);
  background(255);
  frameRate(60); 

  ac = new AudioContext();

  Oscilator osc = new Oscilator(ac, 440.f);
  ac.start();

    
  for(int i = 0; i < threads.length; i++){
    threads[i] = new LThread(PApplet.parseInt(random(100)), "linha: " + i, new Linha(position, 0.f, height, 1, true));
    threads[i].start(); 
    position += 50;
  }
}

public void draw(){
  background(255);
  fill(0);
  
  for(int i = 0; i < threads.length; i++){
   threads[i].draw(); 
  }
}
public interface IDraw{
	public void draw();
}
public interface ISound{
	public void sound();
}
// public interface IUpdate{
// 	public void update();
// }
class LThread extends Thread{
		boolean running;
		int wait;
		String id;
		int count;
		Linha linha;

	LThread(int wait, String id, Linha linha){
		this.wait = wait;
		running = false;
		this.id = id;
		count = 0;
		this.linha = linha;
	}

	public void start(){
		running = true;
		println("Iniciando thread (desenhando " + this.linha + " a cada: " + wait + " ms.");
		super.start();		
	}

	public void run(){
		while(running){
			println(id + ": " + count);
			count++;
			this.linha.update();
	 		try{
	 			sleep((long)(wait));
	 		}catch (Exception e){
	 		}
	 	}
	println("The thread is dead!");

}
	public void draw(){
		this.linha.draw();		
	}

	public void quit(){
		println("Quiting");
		running = false;
		interrupt();
	}

	public int getCount(){
		return count;
	}
}
class Linha{
  
  private float x, y, len;
  private boolean alive;
  private boolean blink;
  private float velocity;
  private float alpha;
  private float aux;
  
  Linha(float x, float y, int len, float velocity){
    this.x = x;
    this.y = y;
    this.len = len;
    this.alive = true;
    this.blink = true;
    this.velocity = velocity;
    this.alpha = 0;
  }
  
  Linha(float x, float y, int len, float velocity, boolean blink){
    this.x = x;
    this.y = y;
    this.len = len;
    this.alive = true;
    this.velocity = velocity;
    this.alpha = 0;
    this.blink = blink;
  }    

  public void setBlink(boolean blink){
    this.blink = blink;  
  }
  
  public boolean getBlink(){
      return this.blink;
  }

  public float getY(){
    return this.y;
  }
  
  public float[] getPosition(){
    return new float[] {this.y};
  }

  public void setAlive(boolean alive){
    this.alive = alive;
  }

  public boolean getAlive(){
    return this.alive;
  }
  
  public float  getVelocity(){
    return this.velocity;
  }

  public void updateY(float y){
        this.y = y;
      
  }

  public void update(){
    if(this.alive){   
      if(this.blink){
        this.aux = blink(this.alpha);
      }
    }
    else{
        this.aux = 255;
    }

  }
   
  public void draw(){
    stroke(0, 0, 0, this.aux);
    line(this.x, 0, this.x, len);
  }
  
  private float blink(float alpha){
    this.alpha += this.velocity;
    if(this.alpha > 255 || this.alpha < 0){    
      this.velocity = -this.velocity;       
    }
  return this.alpha;
  }  
}
class Oscilator{

	private float frequency;
	private WavePlayer tone;
	private Glide frequencyGlide, gainGlide, modulatorGlide;
	private Gain gain;
	private String wave;
	private AudioContext ac;


	Oscilator(AudioContext ac, float frequency){

		this.ac = ac;
		this.frequencyGlide = new Glide(ac, 20, 50);
		this.gainGlide = new Glide(ac, 10.f, 50);
		this.modulatorGlide = new Glide(ac, 0.0f, 50);
		
		WavePlayer tone = new WavePlayer(ac, this.frequencyGlide, Buffer.SINE);  		
  		gain = new Gain(ac, 1, 1);
  		gain.addInput(tone);
  		ac.out.addInput(gain);
	}

	

}	



  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "linhas" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}

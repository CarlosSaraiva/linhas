import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class dis extends PApplet {

Lines[] reta = new Lines[2];
LThread thread1 = new LThread(1000,"linha1");
LThread thread2 = new LThread(1500,"linha 2");

public void setup(){
  size(400, 300);
  background(255);
  frameRate(60);
  reta[0] = new Lines(height/2, width/2, width, 5, true);
  reta[1] = new Lines(height/2, 100, width, 5, true);

  thread1.start();
  thread2.start();

}

public void draw(){
	background(255);
	fill(0);

  int a = thread1.getCount();
  text(a,10,50);
 
  int b = thread2.getCount();
  text(b,10,150);

}
class LThread extends Thread{
		boolean running;
		int wait;
		String id;
		int count;

	LThread(int w, String s){
		wait = w;
		running = false;
		id = s;
		count = 0;
	}

	public void start(){
		running = true;
		println("Starting thread (will execute every " + wait + " milliseconds.");
		println("Linha desenhando");
		super.start();		
	}

	public void run(){
		while(running && count < 10){
			println(id + ": " + count);
			count++;
		
	 		try{
	 			sleep((long)(wait));
	 		}catch (Exception e){
	 		}
	 	}
	println("The thread is dead!");

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
class Lines{
  
  private float y, len;
  private boolean alive;
  private boolean blink;
  private float velocity;
  private float alpha;
  
  Lines(float x, float y, int len, float velocity){
    this.y = y;
    this.len = len;
    this.alive = true;
    this.blink = true;
    this.velocity = velocity;
    this.alpha = 0;
  }
  
  Lines(float x, float y, int len, float velocity, boolean blink){
    this.y = y;
    this.len = len;
    this.alive = true;
    this.blink = true;
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
  
  public void update(float y){
        this.y = y;
      
  }
  
  public float  getVelocity(){
    return this.velocity;
  }

  // private void drawH(){

  // }

  // private void drawV(){

  // }

    
  private void draw(){
    float a;    
    if(this.alive){   
      if(this.blink){
        a = blink(this.alpha);
        println("chegou no A");
      }
    else{
        a = 255;
        println("cheogou no B");
    }
    stroke(0, 0, 0, a);
    line(this.y, 0, this.y,len );
    println("alpha: " + a + " velocity: " + this.velocity);
  }
}





  
  private float blink(float alpha){

    this.alpha += this.velocity;
    if(this.alpha > 255 || this.alpha < 0){    
      this.velocity = -this.velocity;       
    }
  return this.alpha;
  }  
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "dis" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}

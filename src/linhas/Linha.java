package linhas;

import processing.core.PApplet;

class Linha{

	private float x, y, len;
	private boolean alive;
	private boolean blink;
	private float velocity;
	private float alpha;
	private float aux;
	private PApplet parent;

	Linha(float x, float y, int len, float velocity, PApplet parent){
		this.x = x;
		this.y = y;
		this.len = len;
		this.alive = true;
		this.blink = true;
		this.velocity = velocity;
		this.alpha = 0;
		this.parent = parent;
	}

	Linha(float x, float y, int len, float velocity, boolean blink, PApplet parent){
		this.x = x;
		this.y = y;
		this.len = len;
		this.alive = true;
		this.velocity = velocity;
		this.alpha = 0;
		this.blink = blink;
		this.parent = parent;
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
		parent.stroke(0, 0, 0, this.aux);
		parent.line(this.x, 0, this.x, len);
	}

	private float blink(float alpha){
		this.alpha += this.velocity;
		if(this.alpha > 255 || this.alpha < 0){    
			this.velocity = -this.velocity;       
		}
		return this.alpha;
	}  
}

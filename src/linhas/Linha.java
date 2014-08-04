package linhas;

import beads.AudioContext;
import beads.Envelope;
import processing.core.PApplet;

class Linha{

	private float x, y, len;
	private boolean alive;
	private boolean blink;
	private float velocity;
	private float alpha;
	private float aux;
	private PApplet parent;
	private AudioContext ac;
	private Oscillator osc; 
	private float f;

	Linha(float x, float y, int len, float velocity, PApplet parent, AudioContext ac, float f){
		this.f = f;
		this.x = x;
		this.y = y;
		this.len = len;
		this.alive = true;
		this.blink = true;
		this.velocity = velocity;
		this.alpha = 0;
		this.parent = parent;
		this.ac= ac;
		//this.osc.getGainGlide().setValue(PApplet.map(this.alpha, 0, 255, 0.f, 0.2f));	
		this.osc.getEnvelope().addSegment((float) 0.3, PApplet.map(this.alpha, 0, 255, 1.f, 2.f));
	}

	Linha(float x, float y, int len, float velocity, boolean blink, PApplet parent, AudioContext ac, float f){
		this.x = x;
		this.y = y;
		this.len = len;
		this.alive = true;
		this.velocity = velocity;
		this.alpha = 1;
		this.blink = blink;
		this.parent = parent;
		this.ac = ac;
		this.f = f;
		osc = new Oscillator( ac, f);
		//this.osc.getGainGlide().setValue(PApplet.map(this.alpha, 0, 255, 0.f, 1.f));
		this.osc.getEnvelope().addSegment((float) 0.3, PApplet.map(this.alpha, 0, 255, 1.f, 2.f));

				
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
	
	/**
	 * @return the alpha
	 */
	public float getAlpha() {
		return alpha;
	}

	/**
	 * @param alpha the alpha to set
	 * 
	 */
	public void setAlpha(float alpha) {
		this.alpha = alpha;
	}
	
	public void draw(){
		parent.strokeWeight(parent.random(1, 3));;
		parent.stroke(0, 0, 0, this.aux);
		parent.line(this.x, 0, this.x, len);
	}

	private float blink(float alpha){
		this.alpha += this.velocity;
		if(this.alpha == 1){
			this.osc.getEnvelope().addSegment((float) 0.4, PApplet.map(this.alpha, 0, 255, 1.f, 2.f));
		}
		
		if(this.alpha >= 255 ){
			this.osc.getEnvelope().addSegment((float) 0.0, PApplet.map(this.alpha, 0, 255, 0, 0.5f));
		}
		
		if(this.alpha > 255 || this.alpha < 0){    
			this.velocity = -this.velocity;
			
		}
		return this.alpha;
	}

	/**
	 * @return the osc
	 */
	public Oscillator getOsc() {
		return osc;
	}  
	
	
}

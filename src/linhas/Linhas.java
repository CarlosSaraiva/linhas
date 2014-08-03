package linhas;

import processing.core.PApplet;


import beads.*;
import java.util.Arrays; 
import processing.core.PApplet;


public class Linhas extends PApplet {

	private static final long serialVersionUID = -201929992233084192L;
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

		Oscillator osc = new Oscillator(ac, 440.f, this);
		ac.start();


		for(int i = 0; i < threads.length; i++){
			threads[i] = new LThread((int)random(100), "linha: " + i, new Linha(position, 0.f, height, 1, true, this), this);
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

}
package linhas;

import processing.core.PApplet;
import beads.*;

import java.util.ArrayList;
import java.util.Arrays; 

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import processing.core.PApplet;


public class Linhas extends PApplet {

	private static final long serialVersionUID = -201929992233084192L;
	LThread threads[] = new LThread[12];
	int velocity = 1; //int(random(10));
	int wait = 10;
	int position = 50;
	AudioContext ac;
	ArrayList aleatorios = new ArrayList(12);
	float  alpha[] = new float[12];
	Gain masterGain;
	float f = 220.f;
	

	public void setup(){
		size(1290, 720);
		background(255);
		frameRate(60); 
		ac = new AudioContext();
	    masterGain = new Gain(ac, 1, (float) 0.0);
	    ac.out.addInput(masterGain);

		for(int i = 0; i < threads.length; i++){
			threads[i] = new LThread(random(0.f, 14.f), "linha: " + i, new Linha(position, 0.f, height, 1, true, this, ac, f), this);
			//threads[i] = new LThread(10, "linha: " + i, new Linha(position, 0.f, height, 1, true, this, ac, f), this);			
			f *=2;
			threads[i].start(); 
			position += 1290/threads.length;
		
		}
		masterGain.setGain(0.f);
		ac.start();		
	}

	public void draw(){
		background(255);
		fill(0);
		
		for(int i = 0; i < 4; i++){
			threads[(int) alpha[i]].draw();
			
			if(threads[i].getLinha().getAlpha() == 0){	
				
				nextLine();
				System.out.println("AQUI");
			}			
		}
	}

	private void nextLine() {
		// TODO Auto-generated method stub
				
		
		
		for(int i = 0; i < 4; i++){
			alpha[i] = (int) random(0, 11); 
			System.out.println(alpha[i]);
		    threads[(int) alpha[i]].getLinha().setAlpha(1);
		}
		
	}
}
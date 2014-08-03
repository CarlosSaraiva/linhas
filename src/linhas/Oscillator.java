package linhas;

import processing.core.PApplet;
import beads.AudioContext;
import beads.Buffer;
import beads.Gain;
import beads.Glide;
import beads.WavePlayer;

class Oscillator{

	@SuppressWarnings("unused")
	private float frequency;
	@SuppressWarnings("unused")
	private WavePlayer tone;
	@SuppressWarnings("unused")
	private Glide frequencyGlide, gainGlide, modulatorGlide;
	private Gain gain;
	@SuppressWarnings("unused")
	private String wave;
	@SuppressWarnings("unused")
	private AudioContext ac;


	Oscillator(AudioContext ac, float frequency, PApplet parent){

		this.ac = ac;
		this.frequencyGlide = new Glide(ac, 440, 50);
		this.gainGlide = new Glide(ac, 10.f, 50);
		this.modulatorGlide = new Glide(ac, 10, 50);
		
		WavePlayer tone = new WavePlayer(ac, this.frequencyGlide, Buffer.SINE);  		
  		gain = new Gain(ac, 1, 1);
  		gain.addInput(tone);
  		ac.out.addInput(gain);
	}

	

}	

package linhas;

import processing.core.PApplet;
import beads.AudioContext;
import beads.Buffer;
import beads.Envelope;
import beads.Gain;
import beads.Glide;
import beads.UGen;
import beads.WavePlayer;

class Oscillator{

	@SuppressWarnings("unused")
	private float frequency;
	private WavePlayer tone;
	@SuppressWarnings("unused")
	private Glide frequencyGlide, gainGlide, modulatorGlide;
	private Gain gain;
	private UGen wave;
	@SuppressWarnings("unused")
	private AudioContext ac;
	private float f;
	private float synthGain;
	private Envelope envelope;


	Oscillator(float f,AudioContext ac, float frequency, PApplet parent){
		
		this.f = f;
		this.ac = ac;
		this.frequencyGlide = new Glide(ac, 440, 50);
		this.gainGlide = new Glide(ac, 10.f, 50);
		this.modulatorGlide = new Glide(ac, 10, 50);
		
		tone = new WavePlayer(ac, this.f, Buffer.SINE); 
		this.envelope = new Envelope(ac, (float) 0.0);		 		
  		gain = new Gain(ac, 1, this.envelope);
		//gain = new Gain(ac, 1, 0);
  		
  		gain.addInput(tone);
  		ac.out.addInput(gain);
	}


	public Oscillator(AudioContext ac, float f) {
		this.f = f;
		this.ac = ac;
		this.frequencyGlide = new Glide(ac, 50);
		this.gainGlide = new Glide(ac, 10.f, 50);
		this.modulatorGlide = new Glide(ac, 10, 50);
		
		tone = new WavePlayer(ac, f, Buffer.SINE); 
		this.envelope = new Envelope(ac, (float) 0.0);		 		
  		gain = new Gain(ac, 1, this.envelope);
		//gain = new Gain(ac, 1, gainGlide);
  		
  		gain.addInput(tone);
  		ac.out.addInput(gain);
  		gainGlide.setValue(0);
	}


	public UGen getWave() {
		return wave;
	}


	/**
	 * @return the gain
	 */
	public Gain getGain() {
		return gain;
	}


	/**
	 * @param gain the gain to set
	 */
	public void setGain(float gain) {
		this.gain.setValue(gain);
	}


	/**
	 * @return the frequencyGlide
	 */
	public Glide getFrequencyGlide() {
		return frequencyGlide;
	}


	/**
	 * @param frequencyGlide the frequencyGlide to set
	 */
	public void setFrequencyGlide(Glide frequencyGlide) {
		this.frequencyGlide = frequencyGlide;
	}


	/**
	 * @return the envelope
	 */
	public Envelope getEnvelope() {
		return envelope;
	}


	/**
	 * @param envelope the envelope to set
	 */
	public void setEnvelope(Envelope envelope) {
		this.envelope = envelope;
	}


	/**
	 * @return the gainGlide
	 */
	public Glide getGainGlide() {
		return gainGlide;
	}


	/**
	 * @param gainGlide the gainGlide to set
	 */
	public void setGainGlide(Glide gainGlide) {
		this.gainGlide = gainGlide;
	}
	
	
	
	
	
}	

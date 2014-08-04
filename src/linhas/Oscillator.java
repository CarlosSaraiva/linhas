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
	@SuppressWarnings("unused")
	private WavePlayer tone;
	@SuppressWarnings("unused")
	private Glide frequencyGlide, gainGlide, modulatorGlide;
	private Gain gain;
	@SuppressWarnings("unused")
	private UGen wave;
	@SuppressWarnings("unused")
	private AudioContext ac;
	private float f;
	private Envelope envelope;


	Oscillator(float f,AudioContext ac, float frequency, PApplet parent){
		
		this.f = f;
		this.ac = ac;
		this.frequencyGlide = new Glide(ac, 440, 50);
		this.gainGlide = new Glide(ac, 10.f, 50);
		this.modulatorGlide = new Glide(ac, 10, 50);
		
		envelope = new Envelope(ac, (float) 0.0);
		tone = new WavePlayer(ac, this.f, Buffer.SINE);  		
  		gain = new Gain(ac, 1, envelope);
  		
  		gain.addInput(tone);
  		ac.out.addInput(gain);
	}


	public Oscillator(AudioContext ac, float f) {
		this.f = f;
		this.ac = ac;
		this.frequencyGlide = new Glide(ac, 50);
		this.gainGlide = new Glide(ac, 10.f, 50);
		this.modulatorGlide = new Glide(ac, 10, 50);
		
		WavePlayer tone = new WavePlayer(ac, this.f, Buffer.SINE);  		
  		gain = new Gain(ac, 1, 1);
  		gain.addInput(tone);
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
	public void setGainGlide(float gain) {
		this.gainGlide.setValue(gain);;
	}


	/**
	 * @return the wave
	 */
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
	public void setGain(Gain gain) {
		this.gain = gain;
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
	
	
	
	
	
}	

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
		this.gainGlide = new Glide(ac, 10., 50);
		this.modulatorGlide = new Glide(ac, 0.0, 50);
		
		WavePlayer tone = new WavePlayer(ac, this.frequencyGlide, Buffer.SINE);  		
  		gain = new Gain(ac, 1, 1);
  		gain.addInput(tone);
  		ac.out.addInput(gain);
	}

	

}	




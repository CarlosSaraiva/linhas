class Oscilator{

	private float frequency;
	private WavePlayer wavePlayer;
	private Glide frequencyGlide;
	private Gain gain;
	private String wave;


	Audio(WavePlayer tone, float frequency, AudioContext ac, String wave){

		WavePlayer wp = new WavePlayer(ac, function, Buffer.SINE);
  		Gain g = new Gain(ac, 1, 0.1);
  		g.addInput(wp);
  		ac.out.addInput(g);
		ac.start();
	}

}	




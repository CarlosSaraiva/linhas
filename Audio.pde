// iport beads,*;

// class Audio{

//   float baseFrequency = 200.0f;
//   int sineCount = 10;

//   WavePlayer sineTone;
//   Glide frequency;
//   Gain gain;


//   Audio(WavePlayer tone, float frequency){



//   }



// }

//   AudioContext ac;

//   WavePlayer freqModulator = new WavePlayer(ac, 1000, Buffer.SINE);
//   Function function = new Function(freqModulator){
//   	public float calculate(){
//   		return x[0] * 500.0 + 700.0;
//   	}
//   };
//   WavePlayer wp = new WavePlayer(ac, function, Buffer.SINE);
//   Gain g = new Gain(ac, 1, 0.1);
//   g.addInput(wp);
//   ac.out.addInput(g);
//   ac.start();

// }

//   ac = new  AudioContext(); 
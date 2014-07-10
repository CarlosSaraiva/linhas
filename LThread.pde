class LThread extends Thread{
		boolean running;
		int wait;
		String id;
		int count;

	LThread(int w, String s){
		wait = w;
		running = false;
		id = s;
		count = 0;
	}

	void start(){
		running = true;
		println("Starting thread (will execute every " + wait + " milliseconds.");
		println("Linha desenhando");
		super.start();		
	}

	void run(){
		while(running && count < 10){
			println(id + ": " + count);
			count++;
		
	 		try{
	 			sleep((long)(wait));
	 		}catch (Exception e){
	 		}
	 	}
	println("The thread is dead!");

}

	void quit(){
		println("Quiting");
		running = false;
		interrupt();
	}

	int getCount(){
		return count;
	}
}
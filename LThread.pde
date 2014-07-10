class LThread extends Thread{
		boolean running;
		int wait;
		String id;
		int count;
		Linha linha;

	LThread(int w, String s, Linha linha){
		wait = w;
		running = false;
		id = s;
		count = 0;
		this.linha = linha;
	}

	void start(){
		running = true;
		println("Starting thread (will execute every " + wait + " milliseconds.");
		println("Linha desenhando");
		super.start();		
	}

	void run(){
		while(running){
			println(id + ": " + count);
			count++;
			println(linha.getVelocity());
			linha.update();
	 		try{
	 			sleep((long)(wait));
	 		}catch (Exception e){
	 		}
	 	}
	println("The thread is dead!");

}
	public void draw(){
		linha.draw();
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
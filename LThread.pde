class LThread extends Thread{
		boolean running;
		int wait;
		String id;
		int count;
		Linha linha;

	LThread(int wait, String id, Linha linha){
		this.wait = wait;
		running = false;
		this.id = id;
		count = 0;
		this.linha = linha;
	}

	void start(){
		running = true;
		println("Iniciando thread (desenhando " + this.linha + " a cada: " + wait + " ms.");
		super.start();		
	}

	void run(){
		while(running){
			println(id + ": " + count);
			count++;
			this.linha.update();
	 		try{
	 			sleep((long)(wait));
	 		}catch (Exception e){
	 		}
	 	}
	println("The thread is dead!");

}
	public void draw(){
		this.linha.draw();		
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

package linhas;

import processing.core.PApplet;

class LThread extends Thread{
	boolean running;
	int wait;
	String id;
	int count;
	Linha linha;
	PApplet parent;

	LThread(int wait, String id, Linha linha, PApplet parent){
		this.wait = wait;
		running = false;
		this.id = id;
		count = 0;
		this.linha = linha;
		this.parent = parent;
	}

	public void start(){
		running = true;
		System.out.println("Iniciando thread (desenhando " + this.linha + " a cada: " + wait + " ms.");
		super.start();		
	}

	public void run(){
		while(running){
			System.out.println(id + ": " + count);
			count++;
			this.linha.update();
			try{
				sleep((long)(wait));
			}catch (Exception e){
			}
		}
		System.out.println("The thread is dead!");

	}
	public void draw(){
		this.linha.draw();		
	}

	void quit(){
		System.out.println("Quiting");
		running = false;
		interrupt();
	}

	int getCount(){
		return count;
	}
}

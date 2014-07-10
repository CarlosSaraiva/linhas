Lines[] reta = new Lines[2];
LThread thread1 = new LThread(1000,"linha1");
LThread thread2 = new LThread(1500,"linha 2");

void setup(){
  size(400, 300);
  background(255);
  frameRate(60);
  reta[0] = new Lines(height/2, width/2, width, 5, true);
  reta[1] = new Lines(height/2, 100, width, 5, true);

  thread1.start();
  thread2.start();

}

void draw(){
	background(255);
	fill(0);

  int a = thread1.getCount();
  text(a,10,50);
 
  int b = thread2.getCount();
  text(b,10,150);

}
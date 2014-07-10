class Lines{
  
  private float y, len;
  private boolean alive;
  private boolean blink;
  private float velocity;
  private float alpha;
  
  Lines(float x, float y, int len, float velocity){
    this.y = y;
    this.len = len;
    this.alive = true;
    this.blink = true;
    this.velocity = velocity;
    this.alpha = 0;
  }
  
  Lines(float x, float y, int len, float velocity, boolean blink){
    this.y = y;
    this.len = len;
    this.alive = true;
    this.blink = true;
    this.velocity = velocity;
    this.alpha = 0;
    this.blink = blink;
  }    

  public void setBlink(boolean blink){
    this.blink = blink;  
  }
  
  public boolean getBlink(){
      return this.blink;
  }

  public float getY(){
    return this.y;
  }
  
  public float[] getPosition(){
    return new float[] {this.y};
  }

  public void setAlive(boolean alive){
    this.alive = alive;
  }

  public boolean getAlive(){
    return this.alive;
  }
  
  public void update(float y){
        this.y = y;
      
  }
  
  public float  getVelocity(){
    return this.velocity;
  }

  // private void drawH(){

  // }

  // private void drawV(){

  // }

    
  private void draw(){
    float a;    
    if(this.alive){   
      if(this.blink){
        a = blink(this.alpha);
        println("chegou no A");
      }
    else{
        a = 255;
        println("cheogou no B");
    }
    stroke(0, 0, 0, a);
    line(this.y, 0, this.y,len );
    println("alpha: " + a + " velocity: " + this.velocity);
  }
}





  
  private float blink(float alpha){

    this.alpha += this.velocity;
    if(this.alpha > 255 || this.alpha < 0){    
      this.velocity = -this.velocity;       
    }
  return this.alpha;
  }  
}
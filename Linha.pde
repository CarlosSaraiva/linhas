class Linha{
  
  private float y, len;
  private boolean alive;
  private boolean blink;
  private float velocity;
  private float alpha;
  private float aux;
  
  Linha(float x, float y, int len, float velocity){
    this.y = y;
    this.len = len;
    this.alive = true;
    this.blink = true;
    this.velocity = velocity;
    this.alpha = 0;
  }
  
  Linha(float x, float y, int len, float velocity, boolean blink){
    this.y = y;
    this.len = len;
    this.alive = true;
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
  
  public float  getVelocity(){
    return this.velocity;
  }

  public void updateY(float y){
        this.y = y;
      
  }

  public void update(){
    if(this.alive){   
      if(this.blink){
        this.aux = blink(this.alpha);
        println("chegou no A");
      }
    }
    else{
        this.aux = 255;
        println("cheogou no B");
    }

  }
   
  public void draw(){
    stroke(0, 0, 0, this.aux);
    line(this.y, 0, this.y,len);
    println(this.y  + "" + len);
    println("alpha: " + this.aux + " velocity: " + this.velocity);  
  }
  
  private float blink(float alpha){
    this.alpha += this.velocity;
    if(this.alpha > 255 || this.alpha < 0){    
      this.velocity = -this.velocity;       
    }
  return this.alpha;
  }  
}
class Plan extends PVector{
  float grade;
  
  Plan(){  
    super();
    grade = 0;
  }
  
  Plan(float _c1, float _c2){
    super(_c1,_c2);
    grade = 0;
  }
  
  Plan(float _c1,float _c2, float _g){
    super(_c1,_c2);
    
    grade = _g;
  }
  
  void setGrade(float _grade){
    grade = _grade;
  }
  
  // a plan should not be
  // restricted with two criteria but
  // to see it in a flat screen
  void draw(){
    rect(x*drawArea.x,x*drawArea.y,3,3);
  }
  
  PVector mult(PVector _p){
    return new PVector(x*_p.x,y*_p.y,z*_p.z);
  }
  
  public Plan copy(){
    return new Plan(x,y,grade);
  }
  
}
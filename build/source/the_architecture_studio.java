import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class the_architecture_studio extends PApplet {


// This is basically a bunch of global variables
static class Studio{
  static final int weekNumber = 10;
  static final int studentNumber = 1;
  static final int criterionNumber = 2;
}

Student[] students;


final PVector margin = new PVector(20,20);
PVector drawArea;


public void setup(){
  
  frameRate(1);

  students = new Student[Studio.studentNumber];
  for(int i=0;i<Studio.studentNumber;i++){
    students[i] = new Student();
  }

  drawArea = (new PVector(1280,1024)).sub(PVector.mult(margin,2));
}


public void draw(){
  background(0);

  pushMatrix();
  translate(margin.x, margin.y);

  noFill();
  stroke(255);
  rect(0,0,drawArea.x,drawArea.y);
  for(int s=0;s<Studio.studentNumber;s++){
    students[s].draw();
  }

  popMatrix();

  if(frameCount > Studio.weekNumber){
    noLoop();
    save("out/the_architecture_studio.png");
  }
}
class Instructor{
  
  Instructor(){
  }
  
  // TODO: this should be a call back mechanism
  public float evaluate(Plan _plan){
    return random(1);
  }
  
}
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
  
  public void setGrade(float _grade){
    grade = _grade;
  }
  
  // a plan should not be
  // restricted with two criteria but
  // to see it in a flat screen
  public void draw(){
    rect(x*drawArea.x,x*drawArea.y,3,3);
  }
  
  public PVector mult(PVector _p){
    return new PVector(x*_p.x,y*_p.y,z*_p.z);
  }
  
  public Plan copy(){
    return new Plan(x,y,grade);
  }
  
}
class Student{
  Plan currentPlan;
  // I will use ArrayLists incase we want to run so many weeks
  ArrayList<Plan> archivePlans;

 Student(){
   currentPlan = new Plan();
   archivePlans = new ArrayList<Plan>();
 }

 public void nextWeek(){
    archivePlans.add(currentPlan);
    currentPlan = studentRule();
  }

  public void critiqueLastPlan(float _grade){
    currentPlan.setGrade(_grade);
  }

  public Plan studentRule(){
    Plan tempPlan = new Plan(random(drawArea.x),random(drawArea.y));
    return tempPlan;
  }

  public void draw(){
    noFill();
    stroke(100);

    pushMatrix();
    scale(drawArea.x,drawArea.y);
    // draw paths
    beginShape();
    for(int i=0;i<archivePlans.size();i++){
      vertex(archivePlans.get(i).array());
    }
    vertex(currentPlan.array());
    printArray(currentPlan.array());
    endShape();
    popMatrix();

    // draw points
    for(int i=0;i<archivePlans.size();i++){
      archivePlans.get(i).draw();
    }
     currentPlan.draw();
  }

}
  public void settings() {  size(1280, 1024); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "the_architecture_studio" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}

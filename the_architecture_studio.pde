
// This is basically a bunch of global variables
static class Studio{
  static final int weekNumber = 10;
  static final int studentNumber = 1;
  static final int criterionNumber = 2;
}

Student[] students;


final PVector margin = new PVector(20,20);
PVector drawArea;


void setup(){
  size(1280, 1024);
  frameRate(1);

  students = new Student[Studio.studentNumber];
  for(int i=0;i<Studio.studentNumber;i++){
    students[i] = new Student();
  }

  drawArea = (new PVector(1280,1024)).sub(PVector.mult(margin,2));
}


void draw(){
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

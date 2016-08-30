class Student{
  Plan currentPlan;
  // I will use ArrayLists incase we want to run so many weeks
  ArrayList<Plan> archivePlans;

 Student(){
   currentPlan = new Plan();
   archivePlans = new ArrayList<Plan>();
 }

 void nextWeek(){
    archivePlans.add(currentPlan);
    currentPlan = studentRule();
  }

  void critiqueLastPlan(float _grade){
    currentPlan.setGrade(_grade);
  }

  Plan studentRule(){
    Plan tempPlan = new Plan(random(drawArea.x),random(drawArea.y));
    return tempPlan;
  }

  void draw(){
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

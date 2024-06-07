import processing.core.PApplet;
import java.util.ArrayList;

public class Sketch extends PApplet {
	
  boolean[] boolKeyHeld = new boolean[256];
  int[] intCharPos = new int[2];
  ArrayList<int[]> intEllipses = new ArrayList<>();
  int intPlayerSpeed = 1;
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(400, 400);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(210, 255, 173);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    clear();
    background(210, 255, 173);
    if(boolKeyHeld[(int)'a']){
      intCharPos[0] -= intPlayerSpeed;
    }
    if(boolKeyHeld[(int)'d']){
      intCharPos[0] += intPlayerSpeed;
    }
    if(boolKeyHeld[(int)'w']){
      intCharPos[1] -= intPlayerSpeed;
    }
    if(boolKeyHeld[(int)'s']){
      intCharPos[1] += intPlayerSpeed;
    }
    if(boolKeyHeld[255]){
      intPlayerSpeed = 2;
    }
    else{
      intPlayerSpeed = 1;
    }
    if(mousePressed){
      intEllipses.add(new int[]{intCharPos[0],intCharPos[1]});
    }
    for(int x = 0; x < intEllipses.size(); x++){
      ellipse(intEllipses.get(x)[0],intEllipses.get(x)[1],10,10);
    }
    if(boolKeyHeld[(int)'c']){
      intEllipses.clear();
    }
    ellipse(intCharPos[0], intCharPos[1], 10, 10);
  }
  
  @Override
  public void keyPressed() {
    if (key == CODED){
      if(keyCode == SHIFT){
        boolKeyHeld[255] = true;
      }
    }
    if(key != CODED){
      boolKeyHeld[(int)key] = true;
    }
  }
  @Override
  public void keyReleased() {
    if (key == CODED){
      if(keyCode == SHIFT){
        boolKeyHeld[255] = false;
      }
    }
    else{
      boolKeyHeld[(int)key] = false;
    }
  }
}
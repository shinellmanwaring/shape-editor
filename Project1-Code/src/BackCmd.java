import java.awt.*;

/**
 * BackCmd.java
 * Command class moving the frontmost object, that is under the 
 * mouse position at the time of the click, to the back of the 
 * linear ordering of objects in the drawing. 
 * 
 * @author Shinell J. Manwaring
 * @see Command
 */
public class BackCmd extends Command {

	/**
	 * When the mouse is clicked, find the frontmost Shape in the drawing
	 * that contains the mouse position. If there is such a Shape, then
	 * move it to the back of the drawing.
	 * 
	 * @param p the coordinates of the click
	 * @param dwg the drawing being clicked
	 */
	public void executeClick(Point p, Drawing dwg) {
		Shape s = dwg.getFrontmostContainer(p); // find the frontmost shape containing p

		if (s != null) { // was there a Shape containing p?
			dwg.moveToBack(s); // move the shape to the back of the drawing

		}
	}
}

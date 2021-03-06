import java.awt.*;

/**
 * AddSegment.java
 * Class for adding a segment to the drawing.
 *
 * @author Shinell J. Manwaring 
 * @see Command
 */
public class AddSegment extends Command {
	private Point pressedPoint = null; // Where the mouse was pressed
	private Segment currentSegment = null; // The segment being altered 
	
	/**
	 * Records the point of the press and creates a new segment in that location.
	 * 
	 * @param p the coordinates of the press
	 * @param dwg the drawing being pressed
	 */
	public void executePress(Point p, Drawing dwg) { 
		pressedPoint = p;
		currentSegment = new Segment(pressedPoint.x, pressedPoint.y, pressedPoint.x, pressedPoint.y, dwg.getColor());
		dwg.add(currentSegment); // adds the segment to the current list of shapes
	}

	/**
	 * Adjusts the size of the current segment by appropriately setting
	 * its coordinates. Once dragging is complete, it sets the color of the current 
	 * segment and adds it to the list of shapes.
	 * 
	 * @param p the coordinates of the drag
	 * @param dwg the drawing being dragged
	 */
	public void executeDrag(Point p, Drawing dwg) { 
		if (currentSegment != null) { // makes sure that there is a current segment
			Point pt = p; // where the mouse was dragged
			
			currentSegment.setX2(pt.x); // updates the value of x2 in the current segment
			currentSegment.setY2(pt.y); // updates the value of y2 in the current segment
			
			currentSegment.setColor(dwg.getColor()); // sets the segment to the default color
		}
	}
}

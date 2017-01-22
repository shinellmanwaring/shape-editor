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
	private Segment currentSegment = null; // The rectangle being altered 
	
	/**
	 * Records the point of the press and creates a new segment in that location.
	 * 
	 * @param p the coordinates of the press
	 * @param dwg the drawing being pressed
	 */
	public void executePress(Point p, Drawing dwg) { 
		pressedPoint = p;
		currentSegment = new Segment(pressedPoint.x, pressedPoint.y, 0, 0, dwg.getColor());
	
		System.out.println("point:" + p);
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
		if (currentSegment != null) { // makes sure that there is a currentRect
			Point pt = p;
			currentSegment.setX1(Math.min(pt.x, pressedPoint.x));
			currentSegment.setY1(Math.min(pt.y, pressedPoint.y));
			currentSegment.setX2(Math.abs(pt.x - pressedPoint.x));
			currentSegment.setY2(Math.abs(pt.y - pressedPoint.y));
			
			currentSegment.setColor(dwg.getColor());
			dwg.add(currentSegment);
			
			System.out.println(p);
			
		}
	}
}
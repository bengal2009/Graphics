//
//  Rasterizer.java
//  
//
//  Created by Joe Geigel on 1/21/10.
//  @Contributor Sharath Navalpakkam Krishnan
//  Copyright 2010 __MyCompanyName__. All rights reserved.
//

/**
 * 
 * A simple class for performing rasterization algorithms.
 * 
 * Name : Sharath Navalpakkam Krishnan, sxn9447@rit.edu
 * 
 *
 */

import java.util.*;

public class Rasterizer {

	/**
	 * number of scanlines
	 */
	int n_scanlines;

	/**
	 * Constructor
	 * 
	 * @param n
	 *            - number of scanlines
	 * 
	 */
	Rasterizer(int n) {
		n_scanlines = n;
	}

	/**
	 * Draw a line from (x0,y0) to (x1, y1) on the simpleCanvas C.
	 * 
	 * Handles a Shallow Positive slope between the two points
	 * 
	 * Implementation should be using the Midpoint Method
	 * 
	 * You are to add the implementation here using only calls to C.setPixel()
	 * 
	 * @param x0
	 *            - x coord of first endpoint
	 * @param y0
	 *            - y coord of first endpoint
	 * @param x1
	 *            - x coord of second endpoint
	 * @param y1
	 *            - y coord of second endpoint
	 * @param C
	 *            - The canvas on which to apply the draw command.
	 */
	public void shallowpositive(int x0, int y0, int x1, int y1, simpleCanvas C) {
		int dx, dy, x, y, d, dE, dNE, max;
		dx = Math.abs(x0 - x1);
		dy = Math.abs(y0 - y1);
		d = (2 * dy) - dx;
		dE = 2 * dy;
		dNE = 2 * (dy - dx);

		if (x0 > x1) {
			x = x1;
			y = y1;
			max = x0;

		} else {
			x = x0;
			y = y0;
			max = x1;
		}

		C.setPixel(x, y);

		while (x < max) {
			x++;
			if (d < 0)
				d += dE;

			else {
				y++;
				d += dNE;
			}

			C.setPixel(x, y);
		}

	}

	/**
	 * Draw a line from (x0,y0) to (x1, y1) on the simpleCanvas C.
	 * 
	 * Handles a Shallow Negative slope between the two points
	 * 
	 * Implementation should be using the Midpoint Method
	 * 
	 * You are to add the implementation here using only calls to C.setPixel()
	 * 
	 * @param x0
	 *            - x coord of first endpoint
	 * @param y0
	 *            - y coord of first endpoint
	 * @param x1
	 *            - x coord of second endpoint
	 * @param y1
	 *            - y coord of second endpoint
	 * @param C
	 *            - The canvas on which to apply the draw command.
	 */

	public void shallownegative(int x0, int y0, int x1, int y1, simpleCanvas C) {
		int dx, dy, x, y, d, dE, dNE, max;
		dx = Math.abs(x0 - x1);
		dy = Math.abs(y0 - y1);
		d = (2 * dy) - dx;
		dE = 2 * dy;
		dNE = 2 * (dy - dx);

		if (x0 > x1) {
			x = x1;
			y = y1;
			max = x0;

		} else {
			x = x0;
			y = y0;
			max = x1;
		}

		C.setPixel(x, y);

		while (x < max) {
			x++;
			if (d < 0)
				d += dE;

			else {
				y--;
				d += dNE;
			}

			C.setPixel(x, y);
		}

	}

	/**
	 * Draw a line from (x0,y0) to (x1, y1) on the simpleCanvas C.
	 * 
	 * Handles a Steep Positive slope between the two points
	 * 
	 * Implementation should be using the Midpoint Method
	 * 
	 * You are to add the implementation here using only calls to C.setPixel()
	 * 
	 * @param x0
	 *            - x coord of first endpoint
	 * @param y0
	 *            - y coord of first endpoint
	 * @param x1
	 *            - x coord of second endpoint
	 * @param y1
	 *            - y coord of second endpoint
	 * @param C
	 *            - The canvas on which to apply the draw command.
	 */
	public void steeppositive(int x0, int y0, int x1, int y1, simpleCanvas C) {
		int dx, dy, x, y, d, dE, dNE, max;
		dx = Math.abs(x0 - x1);
		dy = Math.abs(y0 - y1);
		d = (2 * dx) - dy;
		dE = 2 * dx;
		dNE = 2 * (dx - dy);

		if (y0 > y1) {
			x = x1;
			y = y1;
			max = y0;

		} else {
			x = x0;
			y = y0;
			max = y1;
		}

		C.setPixel(x, y);

		while (y < max) {
			y++;
			if (d < 0)
				d += dE;

			else {
				x++;
				d += dNE;
			}

			C.setPixel(x, y);
		}

	}

	/**
	 * Draw a line from (x0,y0) to (x1, y1) on the simpleCanvas C.
	 * 
	 * Handles a Steep Negative slope between the two points
	 * 
	 * Implementation should be using the Midpoint Method
	 * 
	 * You are to add the implementation here using only calls to C.setPixel()
	 * 
	 * @param x0
	 *            - x coord of first endpoint
	 * @param y0
	 *            - y coord of first endpoint
	 * @param x1
	 *            - x coord of second endpoint
	 * @param y1
	 *            - y coord of second endpoint
	 * @param C
	 *            - The canvas on which to apply the draw command.
	 */
	public void steepnegative(int x0, int y0, int x1, int y1, simpleCanvas C) {
		int dx, dy, x, y, d, dE, dNE, max;
		dx = Math.abs(x0 - x1);
		dy = Math.abs(y0 - y1);
		d = (2 * dx) - dy;
		dE = 2 * dx;
		dNE = 2 * (dx - dy);

		if (y0 > y1) {
			x = x1;
			y = y1;
			max = y0;

		} else {
			x = x0;
			y = y0;
			max = y1;
		}

		C.setPixel(x, y);

		while (y < max) {
			y++;
			if (d < 0)
				d += dE;

			else {
				x--;
				d += dNE;
			}

			C.setPixel(x, y);
		}

	}

	/**
	 * Draw a line from (x0,y0) to (x1, y1) on the simpleCanvas C.
	 * 
	 * Implementation should be using the Midpoint Method
	 * 
	 * You are to add the implementation here using only calls to C.setPixel()
	 * 
	 * @param x0
	 *            - x coord of first endpoint
	 * @param y0
	 *            - y coord of first endpoint
	 * @param x1
	 *            - x coord of second endpoint
	 * @param y1
	 *            - y coord of second endpoint
	 * @param C
	 *            - The canvas on which to apply the draw command.
	 */
	public void drawLine(int x0, int y0, int x1, int y1, simpleCanvas C) {
		float m, dx = 0, dy = 0;
		int flag = 0;

		if (x0 > x1) {
			int temp = x1;
			x1 = x0;
			x0 = temp;

			temp = y1;
			y1 = y0;
			y0 = temp;

			//System.out.println("SWAPPER " + x0 + " " + y0 + " " + x1 + " " + y1);
		}

		dx = (x1 - x0);
		dy = (y1 - y0);

		m = dy / dx;

		// System.out.println("M = "+m);

		// if (m > -1 && m < 0)
		if (dy > (-dx) && dy < 0) {
		//	System.out.println("Shallow Negative");
			shallownegative(x0, y0, x1, y1, C);
			return;
		}

		else
		// if (m < (-1))
		if (dy <= (-dx)) {
			//System.out.println("Steep Negative");
			steepnegative(x0, y0, x1, y1, C);
			return;
		}

		else // if (m < 1 && m > 0)
		if (dy <= dx && dy >= 0) {
			//System.out.println("Shallow Positive");
			shallowpositive(x0, y0, x1, y1, C);
			return;
		}

		else

		if (dy > dx) {
			//System.out.println("Steep Positive");
			steeppositive(x0, y0, x1, y1, C);
			return;
		}

		else {
			System.out.println("Invalid " + x0 + " " + y0 + " " + x1 + " " + y1);
		}

	}

}

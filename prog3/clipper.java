import java.util.LinkedList;

//
//  Clipper.java
//  
//
//  Created by Joe Geigel on 1/21/10.
//  @Contributor Sharath Navalpakkam Krishnan
//  Copyright 2010 __MyCompanyName__. All rights reserved.
//

/**
 * Object for performing clipping
 * 
 */

class Point {
	public float x, y;

	Point(float x, float y) {
		this.x = x;
		this.y = y;
	}
}

public class clipper {
	static LinkedList inxy;
	static LinkedList outxy;
	
	/**
	 * clipleft
	 * 
	 * Handles clipping against Left Boundary	
	 * @param x0
	 *            - x coord of lower left of clipping rectangle.
	 * @param y0
	 *            - y coord of lower left of clipping rectangle.
	 * @param x1
	 *            - x coord of upper right of clipping rectangle.
	 * @param y1
	 *            - y coord of upper right of clipping rectangle.
	 * 
	 */

	public void clipleft(float x0, float y0, float x1, float y1) {
		Point tail = (Point) inxy.getLast();

		for (int i = 0; i < inxy.size(); i++) {
			Point temp = (Point) inxy.get(i);

			if (temp.x > x0) {
				if (!(tail.x > x0)) {
					float x2 = tail.x;
					float y2 = tail.y;
					float x3 = temp.x;
					float y3 = temp.y;
					float interx = (((((x0 * y1) - (y0 * x1)) * (x2 - x3)) - ((x0 - x1) * ((x2 * y3) - (y2 * x3)))) / (((x0 - x1) * (y2 - y3)) - ((y0 - y1) * (x2 - x3))));
					float intery = (((((x0 * y1) - (y0 * x1)) * (y2 - y3)) - ((y0 - y1) * ((x2 * y3) - (y2 * x3)))) / (((x0 - x1) * (y2 - y3)) - ((y0 - y1) * (x2 - x3))));
					outxy.add(new Point(interx, intery));
				}
				outxy.add(temp);
			}

			else {
				if ((tail.x > x0)) {
					float x2 = tail.x;
					float y2 = tail.y;
					float x3 = temp.x;
					float y3 = temp.y;
					float interx = (((((x0 * y1) - (y0 * x1)) * (x2 - x3)) - ((x0 - x1) * ((x2 * y3) - (y2 * x3)))) / (((x0 - x1) * (y2 - y3)) - ((y0 - y1) * (x2 - x3))));
					float intery = (((((x0 * y1) - (y0 * x1)) * (y2 - y3)) - ((y0 - y1) * ((x2 * y3) - (y2 * x3)))) / (((x0 - x1) * (y2 - y3)) - ((y0 - y1) * (x2 - x3))));
					outxy.add(new Point(interx, intery));
				}

			}
			tail = temp;

		}

	}
	/**
	 * clipbottom
	 * 
	 * Handles clipping against Bottom Boundary	
	 * @param x0
	 *            - x coord of lower left of clipping rectangle.
	 * @param y0
	 *            - y coord of lower left of clipping rectangle.
	 * @param x1
	 *            - x coord of upper right of clipping rectangle.
	 * @param y1
	 *            - y coord of upper right of clipping rectangle.
	 * 
	 */
	public void clipbottom(float x0, float y0, float x1, float y1) {
		Point tail = (Point) inxy.getLast();

		for (int i = 0; i < inxy.size(); i++) {
			Point temp = (Point) inxy.get(i);

			if (temp.y > y0) {
				if (!(tail.y > y0)) {
					float x2 = tail.x;
					float y2 = tail.y;
					float x3 = temp.x;
					float y3 = temp.y;
					float interx = (((((x0 * y1) - (y0 * x1)) * (x2 - x3)) - ((x0 - x1) * ((x2 * y3) - (y2 * x3)))) / (((x0 - x1) * (y2 - y3)) - ((y0 - y1) * (x2 - x3))));
					float intery = (((((x0 * y1) - (y0 * x1)) * (y2 - y3)) - ((y0 - y1) * ((x2 * y3) - (y2 * x3)))) / (((x0 - x1) * (y2 - y3)) - ((y0 - y1) * (x2 - x3))));
					outxy.add(new Point(interx, intery));
				}
				outxy.add(temp);
			}

			else {
				if ((tail.y > y0)) {
					float x2 = tail.x;
					float y2 = tail.y;
					float x3 = temp.x;
					float y3 = temp.y;
					float interx = (((((x0 * y1) - (y0 * x1)) * (x2 - x3)) - ((x0 - x1) * ((x2 * y3) - (y2 * x3)))) / (((x0 - x1) * (y2 - y3)) - ((y0 - y1) * (x2 - x3))));
					float intery = (((((x0 * y1) - (y0 * x1)) * (y2 - y3)) - ((y0 - y1) * ((x2 * y3) - (y2 * x3)))) / (((x0 - x1) * (y2 - y3)) - ((y0 - y1) * (x2 - x3))));
					outxy.add(new Point(interx, intery));
				}

			}
			tail = temp;

		}

	}
	
	/**
	 * clipright
	 * 
	 * Handles clipping against Right Boundary	
	 * @param x0
	 *            - x coord of lower left of clipping rectangle.
	 * @param y0
	 *            - y coord of lower left of clipping rectangle.
	 * @param x1
	 *            - x coord of upper right of clipping rectangle.
	 * @param y1
	 *            - y coord of upper right of clipping rectangle.
	 * 
	 */
	public void clipright(float x0, float y0, float x1, float y1) {
		Point tail = (Point) inxy.getLast();

		for (int i = 0; i < inxy.size(); i++) {
			Point temp = (Point) inxy.get(i);

			if (temp.x < x0) {
				if (!(tail.x < x0)) {
					float x2 = tail.x;
					float y2 = tail.y;
					float x3 = temp.x;
					float y3 = temp.y;
					float interx = (((((x0 * y1) - (y0 * x1)) * (x2 - x3)) - ((x0 - x1) * ((x2 * y3) - (y2 * x3)))) / (((x0 - x1) * (y2 - y3)) - ((y0 - y1) * (x2 - x3))));
					float intery = (((((x0 * y1) - (y0 * x1)) * (y2 - y3)) - ((y0 - y1) * ((x2 * y3) - (y2 * x3)))) / (((x0 - x1) * (y2 - y3)) - ((y0 - y1) * (x2 - x3))));
					outxy.add(new Point(interx, intery));
				}
				outxy.add(temp);
			}

			else {
				if ((tail.x < x0)) {
					float x2 = tail.x;
					float y2 = tail.y;
					float x3 = temp.x;
					float y3 = temp.y;
					float interx = (((((x0 * y1) - (y0 * x1)) * (x2 - x3)) - ((x0 - x1) * ((x2 * y3) - (y2 * x3)))) / (((x0 - x1) * (y2 - y3)) - ((y0 - y1) * (x2 - x3))));
					float intery = (((((x0 * y1) - (y0 * x1)) * (y2 - y3)) - ((y0 - y1) * ((x2 * y3) - (y2 * x3)))) / (((x0 - x1) * (y2 - y3)) - ((y0 - y1) * (x2 - x3))));
					outxy.add(new Point(interx, intery));
				}

			}
			tail = temp;

		}

	}
	
	/**
	 * cliptop
	 * 
	 * Handles clipping against Top Boundary	
	 * @param x0
	 *            - x coord of lower left of clipping rectangle.
	 * @param y0
	 *            - y coord of lower left of clipping rectangle.
	 * @param x1
	 *            - x coord of upper right of clipping rectangle.
	 * @param y1
	 *            - y coord of upper right of clipping rectangle.
	 * 
	 */
	
	public void cliptop(float x0, float y0, float x1, float y1) {
		Point tail = (Point) inxy.getLast();

		for (int i = 0; i < inxy.size(); i++) {
			Point temp = (Point) inxy.get(i);

			if (temp.y < y0) {
				if (!(tail.y < y0)) {
					float x2 = tail.x;
					float y2 = tail.y;
					float x3 = temp.x;
					float y3 = temp.y;
					float interx = (((((x0 * y1) - (y0 * x1)) * (x2 - x3)) - ((x0 - x1) * ((x2 * y3) - (y2 * x3)))) / (((x0 - x1) * (y2 - y3)) - ((y0 - y1) * (x2 - x3))));
					float intery = (((((x0 * y1) - (y0 * x1)) * (y2 - y3)) - ((y0 - y1) * ((x2 * y3) - (y2 * x3)))) / (((x0 - x1) * (y2 - y3)) - ((y0 - y1) * (x2 - x3))));
					outxy.add(new Point(interx, intery));
				}
				outxy.add(temp);
			}

			else {
				if ((tail.y < y0)) {
					float x2 = tail.x;
					float y2 = tail.y;
					float x3 = temp.x;
					float y3 = temp.y;
					float interx = (((((x0 * y1) - (y0 * x1)) * (x2 - x3)) - ((x0 - x1) * ((x2 * y3) - (y2 * x3)))) / (((x0 - x1) * (y2 - y3)) - ((y0 - y1) * (x2 - x3))));
					float intery = (((((x0 * y1) - (y0 * x1)) * (y2 - y3)) - ((y0 - y1) * ((x2 * y3) - (y2 * x3)))) / (((x0 - x1) * (y2 - y3)) - ((y0 - y1) * (x2 - x3))));
					outxy.add(new Point(interx, intery));
				}

			}
			tail = temp;

		}

	}

	/**
	 * clipPolygon
	 * 
	 * Clip the polygon with vertex count in and vertices inx/iny against the
	 * rectangular clipping region specified by lower-left corner (x0,y0) and
	 * upper-right corner (x1,y1). The resulting vertices are placed in
	 * outx/outy.
	 * 
	 * The routine should return the with the vertex count of polygon resultinhg
	 * from the clipping.
	 * 
	 * @param in
	 *            the number of vertices in the polygon to be clipped
	 * @param inx
	 *            - x coords of vertices of polygon to be clipped.
	 * @param int - y coords of vertices of polygon to be clipped.
	 * @param outx
	 *            - x coords of vertices of polygon resulting after clipping.
	 * @param outy
	 *            - y coords of vertices of polygon resulting after clipping.
	 * @param x0
	 *            - x coord of lower left of clipping rectangle.
	 * @param y0
	 *            - y coord of lower left of clipping rectangle.
	 * @param x1
	 *            - x coord of upper right of clipping rectangle.
	 * @param y1
	 *            - y coord of upper right of clipping rectangle.
	 * 
	 * @return number of vertices in the polygon resulting after clipping
	 * 
	 */
	public int clipPolygon(int in, float inx[], float iny[], float outx[],
			float outy[], float x0, float y0, float x1, float y1) {

		inxy = new LinkedList();
		outxy = new LinkedList();

		for (int i = 0; i < in; i++)
			inxy.add(new Point(inx[i], iny[i]));
		
		
		if(inxy.size()!=0)
		{
			clipleft(x0, y0, x0, y1);
			inxy=outxy;
			outxy=new LinkedList();
		}
		
		if(inxy.size()!=0)
		{
			clipbottom(x0, y0, x1, y0);
			inxy=outxy;
			outxy=new LinkedList();
		}
		
		if(inxy.size()!=0)
		{
			clipright(x1, y0, x1, y1);
			inxy=outxy;
			outxy=new LinkedList();
		}
		
		if(inxy.size()!=0)		
			cliptop(x0,y1, x1, y1);
		
		
		
		for(int i=0;i<outxy.size();i++)
		{
			Point temp=(Point) outxy.get(i);
			outx[i]=temp.x;
			outy[i]=temp.y;
			
		}
		

		return outxy.size();
	}
}

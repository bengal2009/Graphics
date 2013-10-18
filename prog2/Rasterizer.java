//
//  Rasterizer.java
//  
//
//  Created by Joe Geigel on 1/21/10.
//  @Contributor Sharath Navalpakkam Krishnan
//  Copyright 2010 __MyCompanyName__. All rights reserved.
//
// Sharath Navalpakkam Krishnan, sxn9447@rit.edu

/**
 * 
 * This is a class that performas rasterization algorithms
 *
 */

import java.util.*;

class Edge {
	public int ymax, x, dx, dy, numerator;
	public int ymin;

	Edge(int ymax, int x, int dx, int dy, int numerator, int ymin) {
		this.ymax = ymax;
		this.x = x;
		this.dx = dx;
		this.dy = dy;
		this.numerator = numerator;
		this.ymin = ymin;
	}
}

public class Rasterizer {

	/**
	 * number of scanlines
	 */
	int n_scanlines;

	Object EdgeTable[];
	LinkedList ActiveEdgeTable;
	ArrayList visited;

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

	int[] scanlineMinMax(int n, int y[]) {
		int minmax[] = new int[2];
		minmax[0] = y[0];
		minmax[1] = y[0];

		for (int i = 0; i < n; i++) {
			minmax[0] = Math.min(minmax[0], y[i]);
			minmax[1] = Math.max(minmax[1], y[i]);

		}
		// System.out.println("MINMAX "+minmax[0]+" "+minmax[1]);
		return minmax;
	}

	void buildEdgeTable(int n, int x[], int y[]) {
		int ymax, xlocal, dx, dy, numerator, ymin;

		//System.out.println("n " + n);
		for (int i = 0; i < n; i++) {
			dx = x[(i + 1) % n] - x[i % n];
			dy = y[(i + 1) % n] - y[i % n];

			if (y[(i + 1) % n] > y[i % n]) {
				xlocal = x[i % n];
				ymax = y[(i + 1) % n];
				ymin = y[i % n];

				// System.out.println("xlocal "+xlocal);
				// System.out.println("ymax "+ymax);
				// System.out.println("ymin "+ymin);
			} else {
				xlocal = x[(i + 1) % n];
				ymax = y[i % n];
				ymin = y[(i + 1) % n];

				// System.out.println("xlocal "+xlocal);
				// System.out.println("ymax "+ymax);
				// System.out.println("ymin "+ymin);
			}

			Edge edge = new Edge(ymax, xlocal, dx, dy, 0, ymin);
			List list = (List) EdgeTable[ymin];

			if (list == null) {
				LinkedList temp = new LinkedList();
				temp.add(edge);
				EdgeTable[ymin] = temp;
				// System.out.println("ADDED EDGE "+ymin);
			}

			else {
				list.add(edge);
			}
		}
	}

	void buildActiveEdgeTable(List bucket, int scanNo) {
		//System.out.println("Bucket Size " + bucket.size());
		for (int i = 0; i < bucket.size(); i++) {
			//System.out.println("NO ERROR");
			Edge temp = (Edge) bucket.get(i);
			//System.out.println("TEMP YMIN " + temp.ymin);
			if (scanNo == temp.ymin) {
				if (temp.dy != 0) {
					ActiveEdgeTable.add(temp);
					//System.out.println("ADDED EDGES TO ACTIVE AND VISITED");
					visited.add(temp);
				}
			}
		}
	}

	void updateActiveEdgeTable(int scanNo) {
		int visitedId = 0;
		do {
			Edge temp = (Edge) ActiveEdgeTable.get(visitedId);
			if (temp.ymax != scanNo)
				visitedId++;
			else {
				ActiveEdgeTable.remove(visitedId);
				visitedId = 0;
			}

		} while (visitedId != ActiveEdgeTable.size());

	}

	void updateBucket(List bucket) {
		for (int i = 0; i < visited.size(); i++) {
			Edge temp1 = (Edge) visited.get(i);

			for (int j = 0; j < bucket.size(); j++) {
				Edge temp2 = (Edge) bucket.get(j);
				if (temp1 == temp2) {
					bucket.remove(temp1);
					// System.out.println("REMOVED");
					// return;
					break;
				}
			}
		}
		//System.out.println("ACTIVE EDGE SIZE " + ActiveEdgeTable.size());
	}

	void sortActiveEdgeTable() {
		Collections.sort(ActiveEdgeTable, new Comparator<Edge>() {
			public int compare(Edge a, Edge b) {
				if (a.x < b.x)
					return -1;
				else {
					if (a == b)
						return 0;
					else
						return 1;
				}

			}
		});
	}

	void drawPixel(int scanNo, simpleCanvas C) {

		//System.out.println("BEFOE SORTTTT");

		sortActiveEdgeTable();

		int visitedId = 0;

	//	System.out.println("Active Edge table size" + ActiveEdgeTable.size());

		while (visitedId < ActiveEdgeTable.size()) {
			Edge temp = (Edge) ActiveEdgeTable.get(visitedId);
			int x1 = temp.x;
			visitedId++;
			temp = (Edge) ActiveEdgeTable.get(visitedId);
			int x2 = temp.x;
			visitedId++;

		//	System.out.println("X1 X2" + x1 + " " + x2);

			for (int i = x1; i < x2; i++)
				C.setPixel(i, scanNo);

		}
	}

	void adjustActiveEdgeTable() {
		for (int i = 0; i < ActiveEdgeTable.size(); i++) {
			Edge temp = (Edge) ActiveEdgeTable.get(i);
			if (temp.dx != 0) {
				int exp = Math.abs(temp.dx) + Math.abs(temp.numerator);
				temp.numerator = exp;

				if (Math.abs(temp.numerator) >= Math.abs(temp.dy)) {
					while (Math.abs(temp.numerator) >= Math.abs(temp.dy)) {
						boolean flag1 = false;
						boolean flag2 = false;

						if (temp.dx > 0)
							if (temp.dy < 0)
								flag1 = true;

						if (temp.dx < 0)
							if (temp.dy > 0)
								flag2 = true;

						if (flag1 || flag2)
							temp.x = Math.abs(temp.x) - 1;

						else
							temp.x = Math.abs(temp.x) + 1;

						temp.numerator = Math.abs(temp.numerator)
								- Math.abs(temp.dy);

					}

				}
			}
		}
	}

	boolean Visited() {
		for (int i = 0; i < EdgeTable.length; i++) {
			if (EdgeTable[i] != null)
				return false;
		}
		return true;
	}

	void fillPolygon(int scanNo, simpleCanvas C) {

		do {
			visited = new ArrayList();

			List bucket = (List) EdgeTable[scanNo];
			//System.out.println("fill Polygon scanNo" + scanNo);

			if (ActiveEdgeTable != null)
				if (ActiveEdgeTable.size() != 0)
					updateActiveEdgeTable(scanNo);

			if (bucket != null)
				buildActiveEdgeTable(bucket, scanNo);

			updateBucket(bucket);

			if (ActiveEdgeTable != null)
				drawPixel(scanNo, C);

			adjustActiveEdgeTable();

			scanNo++;

		} while (Visited() || ActiveEdgeTable.size() != 0);
	}

	/**
	 * Draw a filled polygon in the simpleCanvas C.
	 * 
	 * The polygon has n distinct vertices. The coordinates of the vertices
	 * making up the polygon are stored in the x and y arrays. The ith vertex
	 * will have coordinate (x[i], y[i])
	 * 
	 * You are to add the implementation here using only calls to C.setPixel()
	 */
	public void drawPolygon(int n, int x[], int y[], simpleCanvas C) {
		int ymax, xlocal, dx, dy, sum, ymin;
		int minmax[] = new int[2];
		int scanNo;

		minmax = scanlineMinMax(n, y);
		scanNo = minmax[0];

		//System.out.println(scanNo);

		EdgeTable = new Object[minmax[1] + 1];
		ActiveEdgeTable = new LinkedList();

		buildEdgeTable(n, x, y);
		fillPolygon(scanNo, C);

	}

}

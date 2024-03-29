package assignment01;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import ij.IJ;
import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;

/**
 * This ImageJ plugin collects the foreground points in
 * a binary image, converts to a new color image and
 * draws half of the dots in color.
 * 
 * @author WB
 * @version 2018-08-27
 */
public class Collect_Points_Demo implements PlugInFilter {
	
	public int setup(String arg, ImagePlus im) {
		return PlugInFilter.DOES_8G;
	}

	public void run(ImageProcessor ip) {
		int w = ip.getWidth();
		int h = ip.getHeight();
		
		// Collect all image points with pixel values greater than zero:
		List<Point> pntlist = new ArrayList<Point>();
		for (int v = 0; v < h; v++) {
			for (int u = 0; u < w; u++) {
				int p = ip.getPixel(u, v);
				if (p > 0) {
					pntlist.add(new Point(u, v));
				}
			}
		}
		Point[] pntarr = pntlist.toArray(new Point[0]);
		IJ.log("Found " + pntarr.length + " foreground points.");
		
		// Copy 'ip' to a new color image and redraw some of the dots in red:
		ImageProcessor cp = ip.convertToColorProcessor();
		cp.setColor(Color.red);
		for (Point p : pntarr) {
			if (p.y <= h/2)
				cp.drawDot(p.x, p.y);
		}
		
		// Just to demonstrate, draw a blue circle somewhere:
		cp.setColor(Color.blue);
		cp.drawOval(35, 200, 75, 75);
		
		// Display the newly created image:
		showImage(cp, "colored dots");
	}
	
	void showImage(ImageProcessor ip, String title) {
		(new ImagePlus(title, ip)).show();
	}

}

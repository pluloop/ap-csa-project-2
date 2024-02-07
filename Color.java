package example;

public class Color {
	private int red;
	private int green;
	private int blue; 
	private int hue;
	private int saturation;
	private int brightness;
	final int MAX_COLOR = 255;
	
	public Color(int type, int a, int b, int c) {
		if (type == 1) {
			red = a;
			green = b;
			blue = c;
		}else {
			hue = a;
			saturation = b;
			brightness = c;
		}
	}
	public void setRGB(int r, int g, int b) {
		red = r;
		green = g;
		blue = b;
	}
	public void setHSV(int h, int s, int b) {
		hue = h;
		saturation = s;
		brightness = b;
	}
	public void setRed(int r) {
		red = r;
	}
	public void setGreen(int g) {
		green = g;
	}
	public void setBlue(int b) {
		blue = b;
	}
	public void setHue(int h) {
		 hue = h;
	}
	public void setSaturation(int s) {
		saturation = s;
	}
	public void setBrightness(int b) {
		brightness = b;
	}
	public int getRed() {
		return red;
	}
	public int getBlue() {
		return green;
	}
	public int getGreen() {
		return blue;
	}
	public int getHue() {
		return hue;
	}
	public int getSaturation() {
		return saturation;
	}
	public int getBrightness() {
		return brightness;
	}
	public int[] getRGB() {
		int[] rgb = {red, green, blue};
		
		return rgb;
	}
	public int[] getHSV() {
		int[] hsv = {hue, saturation, blue};
		
		return hsv;
	}
	
	private double getMaximum(double one, double two, double three) {
		double max = one;
		
		if (max < two) {
			max = two;
		}
		
		if (max < three) {
			max = three;
		}
		
		return max;
	}
	private double getMinimum(double one, double two, double three) {
			double min = one;
			
			if (min > two) {
				min = two;
			}
			
			if (min > three) {
				min = three;
			}
			a
			return min;
	}
	private void calculateHue(double r, double g, double b, double max, double min) {
			r /= MAX_COLOR;
			g /= MAX_COLOR;
			b /= MAX_COLOR;
		
			if (r == max) {
				this.hue = (int) (60 * ((g - b / max - min) % 6));
			} else if (g == max) {
				this.hue = (int) (60 * ((b - r / max - min) + 2));
			} else {
				this.hue = (int) (60 * ((r - g / max - min) + 4));
			}
	}
	private void calculateSaturation(double r, double g, double b, double max, double min) {
		
	}
	
	// Ethan does
//	public Color RGBtoHSV() {
//
//	}
//	public Color HSVtoRGB() {	
//		
//	}
	public void printColor() {
		char c = 176;
		System.out.printf("%10s%3d%2s%3d%2s%3d%2s", "\tRGB = (" , red , ", " , green , ", " , blue , ")");
		System.out.printf("%10s%3d%2s%3d%2s%3d%2s", "HSV = (" , hue , (""+ c+", ")  , saturation , "%, " , brightness , "%)");
	}
}
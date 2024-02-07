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
		} else {
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
			
			return min;
	}
	private int calculateHue(double r, double g, double b) {
		r /= MAX_COLOR;
		g /= MAX_COLOR;
		b /= MAX_COLOR;
		int cMax = getMaximum(r, g, b);
		int cMin = getMinimum(r, g, b);
		int delta = cMax - cMin;
	
		if (delta == 0) {
			return 0;
		} 
		
		if (cMax == r) {
			return (int)(60.0*((g-b)/delta)%6);
		}
		
		if (cMax == g) {
			return (int)(60.0*((b-r)/delta)+2);
		}
		
		if (cMax == b) {
			return (int)(60.0*((r-g)/delta)+4);
		}
	}
	private int calculateSaturation(double r, double g, double b) {
		r /= MAX_COLOR;
		g /= MAX_COLOR;
		b /= MAX_COLOR;
		int cMax = getMaximum(r, g, b);
		int cMin = getMinimum(r, g, b);
		int delta = cMax - cMin;
		
		if (cMax == 0) {
			return 0;
		}
		if (cMax != 0) {
			return delta/cMax;
		}
		
		
	}
	
	private int calculateBrightness(double r, double g, double b) {
		r /= MAX_COLOR;
		g /= MAX_COLOR;
		b /= MAX_COLOR;
		int cMax = getMaximum(r, g, b);
		
		return cMax;
	}
	
	public void RGBtoHSV() {
		setHue(calculateHue(red,green,blue));
		setSaturation(calculateSaturation(red,green,blue));
		setBrightness(calculateBrightness(red,green,blue));
	}
	public void HSVtoRGB() {
		double r;
		double b;
		double g;
		
		double c = brightness*saturation;
		double x = c*(1-Math.abs((hue/60)%2-1));
		double m = brightness - c;
		if ((hue >= 0 && hue < 60)) {
			r = c;
			b = x;
			g = 0;
		} else if ((hue >= 60 && hue < 120)) {
			r = x;
			b = c;
			g = 0;
		} else if ((hue >= 120 && hue < 180)) {
			r = 0;
			b = c;
			g = x;
		} else if ((hue >= 180 && hue < 240)) {
			r = 0;
			b = x;
			g = c;
		} else if ((hue >= 240 && hue < 300)) {
			r = x;
			b = 0;
			g = c;
		} else if ((hue >= 300 && hue < 360)) {
			r = c;
			b = 0;
			g = x;
		}
		
		if ((int)r != r && r < 255) {
			r = (int)(r + 1);
		}
		if ((int)b != b && b < 255) {
			b = (int)(b + 1);
		}
		if ((int)g != g && g < 255) {
			g = (int)(g + 1);
		}
		
		setRed((int)r);
		setGreen((int)g);
		setBlue((int)blue);
		
	}
	public void printColor() {
		char c = 176;
		System.out.printf("%10s%3d%2s%3d%2s%3d%2s", "\tRGB = (" , red , ", " , green , ", " , blue , ")");
		System.out.printf("%10s%3d%2s%3d%2s%3d%2s", "HSV = (" , hue , (""+ c+", ")  , saturation , "%, " , brightness , "%)");
	}
}
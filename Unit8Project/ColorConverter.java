package example;

import Color;

public class ColorConverter {
	private Color[][] myColors;
	private int rows;
	private int cols;
	
	
	public ColorConverter(int rows, int cols, int type, int[] first, int[] second, int[] third)
	{
		this.rows = rows;
		this.cols = cols;
		myColors = new Color[rows][cols];
		int index = 0;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				myColors[row][col] = new Color(type, first[index], second[index], third[index]);
				index++;
			}
		}



	}
	
	public Color[][] RGBtoHSV() {
//		for (Color[] c: myColors) {
//			for (Color co: c) {
//				co.printColor();
//			}
//			System.out.println();
//		}
		Color[][] result = new Color[rows][cols];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				myColors[row][col].RGBtoHSV();
				result[row][col] = myColors[row][col];
			}
		}
		return result;



	}
	public Color[][] HSVtoRGB() {
		Color[][] result = new Color[rows][cols];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				myColors[row][col].HSVtoRGB();
				result[row][col] = myColors[row][col];
				
			}
		}
		return result;


	}
	public void print() {
		for (Color[] row: myColors) {
			for (Color c: row) {
				c.printColor();
				System.out.print("\t");
			}
			System.out.print("\n\n");
		}


	}
}
package example;

import Color;

public class ColorConverter {
	private Color[][] myColors;
	
	public ColorConverter(int rows, int cols, int type, int[] first, int[] second, int[] third)
	{
		myColors = new Color[rows][cols];
		int index = 0;
		for (int row = 0; row < first.length; row++) {
			for (int col = 0; col < first[row].length; col++) {
				myColors[row][col] = new Color(type, first[index], second[index], third[index]);
				index++;
			}
		}



	}
	
	public Color[][] RGBtoHSV() {
		for (int row = 0; row < myColors.length; row++) {
			for (int col = 0; col < myColors[row].length; row++) {
				myColors[row][col].RGBtoHSV();
				
			}
		}



	}
	public Color[][] HSVtoRGB() {
		for (int row = 0; row < myColors.length; row++) {
			for (int col = 0; col < myColors[row].length; row++) {
				myColors[row][col].HSVtoRGB();
				
			}
		}


	}
	public void print() {
		for (Color[] row: myColors) {
			for (Color c: row) {
				c.printColor();
				System.out.println();
			}
		}


	}
}
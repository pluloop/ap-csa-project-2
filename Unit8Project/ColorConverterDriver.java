package example;

import java.util.Scanner;
import Color
import ColorConverter;

public class ColorConverterDriver {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the rows, columns, type, and 3 values of a color each separated by a space: ");	
		int row = scanner.nextInt();
		int col = scanner.nextInt();
		int type = scanner.nextInt();
		int value1 = scanner.nextInt();
		int value2 = scanner.nextInt();
		int value3 = scanner.nextInt();
		
		ColorConverter converter = new ColorConverter(row, col, type, value1, value2, value3);
	}

}
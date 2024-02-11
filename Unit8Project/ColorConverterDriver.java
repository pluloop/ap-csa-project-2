package example;
import java.io.File;
import java.util.Scanner;
import Color
import ColorConverter;
public class ColorConverterDriver {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int rows = 0;
		int cols = 0;
		int type = 0;
		int[] first;
		int[] second;
		int[] third;
		int decision = 0;
		
		System.out.println("Would you like to generate random values(enter \'1\') or use your own file(enter \'2\')?");
		decision = scan.nextInt();
		while (decision != 1 && decision != 2) {
			System.out.println("Please enter \'1\' or \'2\': ");
			decision = scan.nextInt();
		}
		
		
		System.out.println("Enter the number of rows in the matrix");
		rows = scan.nextInt();
		while (rows < 0) {
			System.out.println("Please enter a positive number: ");
			rows = scan.nextInt();
		}
		
		System.out.println("Enter the number of columns in the matrix");
		cols = scan.nextInt();
		while (cols < 0) {
			System.out.println("Please enter a positive number: ");
			cols = scan.nextInt();
		}
		
		System.out.println("Are the colors in RGB or HSV values (type \'1\' for RGB or \'2\' for HSV): ");
		type = scan.nextInt();
		while (type != 1 && type != 2) {
			System.out.println("Please enter \'1\' or \'2\': ");
			type = scan.nextInt();
		}
		
		
		first = new int[rows*cols];
		second = new int[rows*cols];
		third = new int[rows*cols];
		
		if (decision == 2) {
			Scanner s = new Scanner(System.in);
			System.out.println("Enter the file name");
			String fName = s.nextLine();
			try {
				File f = new File(fName);
				Scanner reader = new Scanner(f);
				int index = 0;
				while (reader.hasNextLine()) {
					first[index] = reader.nextInt();
					second[index] = reader.nextInt();
					third[index] = reader.nextInt();
					index++;
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else {
			for (int i = 0; i < first.length; i++) {
				first[i] = (int)(Math.random()*256);
				second[i] = (int)(Math.random()*256);
				third[i] = (int)(Math.random()*256);
			}
		}
		
		
		ColorConverter myColors = new ColorConverter(rows, cols, type, first, second, third);
		if (type == 1) {
			myColors.RGBtoHSV();
		} else {
			myColors.HSVtoRGB();
		}
		myColors.print();
	}

}
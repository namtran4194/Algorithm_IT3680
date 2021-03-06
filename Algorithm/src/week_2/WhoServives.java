package week_2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WhoServives {
	public static final int MBS = 1000;
	public static final int LBS = 10000;

	public static void main(String[] args) {
		long beginTime = System.currentTimeMillis();
		int[] salarys = new int[3];
		int survivesSalary = 0;
		try {
			System.setIn(new FileInputStream("D:\\input_who_survives.txt"));
			Scanner scanner = new Scanner(System.in);
			int numberOfTestCases = Integer.parseInt(scanner.nextLine());
			if (numberOfTestCases <= 0) {
				scanner.close();
				return;
			}
			while (numberOfTestCases > 0) {
				for (int i = 0; i < 3; i++) {
					int salary = scanner.nextInt();
					if (!checkBound(salary)) {
						scanner.close();
						break;
					}
					salarys[i] = salary;
				}
				sort(salarys, 0, salarys.length - 1);
				survivesSalary = salarys[1];
				System.out.println("Case " + (4 - numberOfTestCases) + ": " + survivesSalary);
				if (scanner.hasNextLine()) {
					scanner.nextLine(); // Xuống dòng 
				}
				numberOfTestCases--; // Sang test case tiếp theo
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Total time: " + (endTime - beginTime) + "ms");
	}

	private static boolean checkBound(int number) {
		if (MBS <= number && number <= LBS) {
			return true;
		}
		return false;
	}
	
	public static void sort(int a[], int left, int right) {
		int i = left, j = right;
		int x = a[(left + right) / 2];
		do {
			// tìm phần tử sai vị trí
			while (a[i] < x)
				i++;
			while (a[j] > x)
				j--;
			// Hoán đổi nếu i nằm trước j
			if (i <= j) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		} while (i < j);
		if (left < j) {
			sort(a, left, j);
		}
		if (right > i) {
			sort(a, i, right);
		}
	}
}

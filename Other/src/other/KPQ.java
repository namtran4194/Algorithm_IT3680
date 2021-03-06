package other;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class KPQ {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("D:\\input.txt"));
		Scanner scan = new Scanner(System.in);
		int board = 0; // Board
		while (true) {
			int n = scan.nextInt();// rows
			int m = scan.nextInt(); // columns
			if ((m == 0) && (n == 0))
				break;
			else {
				board++;
				int[][] Arr = new int[n][m];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						Arr[i][j] = 0;
					}
				}
				int q = scan.nextInt();
				for (int i = 0; i < q; i++) {
					int row = scan.nextInt();
					int column = scan.nextInt();
					Arr[row - 1][column - 1] = 1;
				}
				int k = scan.nextInt();
				for (int i = 0; i < k; i++) {
					int row = scan.nextInt();
					int column = scan.nextInt();
					Arr[row - 1][column - 1] = 2;
				}
				int p = scan.nextInt();
				for (int i = 0; i < p; i++) {
					int row = scan.nextInt();
					int column = scan.nextInt();
					Arr[row - 1][column - 1] = 3;
				}
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						// Test Queen
						if (Arr[i][j] == 1) {
							int row = i - 1, column = j - 1;
							while (column >= 0) {
								if ((Arr[i][column] == 0) || (Arr[i][column] == 4)) {
									Arr[i][column] = 4;
									column--;
								} else
									break;
							}
							column = j + 1;
							while (column < m) {
								if ((Arr[i][column] == 0) || (Arr[i][column] == 4)) {
									Arr[i][column] = 4;
									column++;
								} else
									break;
							}
							while (row >= 0) {
								if ((Arr[row][j] == 0) || (Arr[row][j] == 4)) {
									Arr[row][j] = 4;
									row--;
								} else
									break;
							}
							row = i + 1;
							while (row < n) {
								if ((Arr[row][j] == 0) || (Arr[row][j] == 4)) {
									Arr[row][j] = 4;
									row++;
								} else
									break;
							}
							row = i - 1;
							column = j - 1;
							while ((row >= 0) && (column >= 0)) {
								if ((Arr[row][column] == 0) || (Arr[row][column] == 4)) {
									Arr[row][column] = 4;
									row--;
									column--;
								} else
									break;
							}
							row = i + 1;
							column = j + 1;
							while ((row < n) && (column < m)) {
								if ((Arr[row][column] == 0) || (Arr[row][column] == 4)) {
									Arr[row][column] = 4;
									row++;
									column++;
								} else
									break;
							}
							row = i - 1;
							column = j + 1;
							while ((row >= 0) && (column < m)) {
								if ((Arr[row][column] == 0) || (Arr[row][column] == 4)) {
									Arr[row][column] = 4;
									row--;
									column++;
								} else
									break;
							}
							row = i + 1;
							column = j - 1;
							while ((row < n) && (column >= 0)) {
								if ((Arr[row][column] == 0) || (Arr[row][column] == 4)) {
									Arr[row][column] = 4;
									row++;
									column--;
								} else
									break;
							}
						}
						if (Arr[i][j] == 2) {
							if (((i - 2) >= 0) && (j - 1) >= 0) {
								if (Arr[i - 2][j - 1] == 0)
									Arr[i - 2][j - 1] = 4;
							}
							if (((i - 2) >= 0) && (j + 1) < m) {
								if (Arr[i - 2][j + 1] == 0)
									Arr[i - 2][j + 1] = 4;
							}
							if (((i + 2) < n) && (j - 1) >= 0) {
								if (Arr[i + 2][j - 1] == 0)
									Arr[i + 2][j - 1] = 4;
							}
							if (((i + 2) < n) && (j + 1) < m) {
								if (Arr[i + 2][j + 1] == 0)
									Arr[i + 2][j + 1] = 4;
							}
							if (((i - 1) >= 0) && (j - 2) >= 0) {
								if (Arr[i - 1][j - 2] == 0)
									Arr[i - 1][j - 2] = 4;
							}
							if (((i + 1) < n) && (j - 2) >= 0) {
								if (Arr[i + 1][j - 2] == 0)
									Arr[i + 1][j - 2] = 4;
							}
							if (((i - 1) >= 0) && (j + 2) < m) {
								if (Arr[i - 1][j + 2] == 0)
									Arr[i - 1][j + 2] = 4;
							}
							if (((i + 1) >= 0) && (j + 2) < m) {
								if (Arr[i + 1][j + 2] == 0)
									Arr[i + 1][j + 2] = 4;
							}
						}
					}
				}
				int count = 0;
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						if (Arr[i][j] == 0)
							count++;
					}
				}
				System.out.println("Board " + board + " has " + count + " safe squares.");
			}
		}
		scan.close();
	}
}

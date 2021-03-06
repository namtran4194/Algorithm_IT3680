package week_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author namtran
 */
public class TravelingSalesman {
	static int n, m, cmin, cost, x[], cities[][];
	static int minCost;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] line = reader.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		cities = new int[n + 1][n + 1];
		visited = new boolean[n + 1];
		x = new int[n + 1];
		cmin = Integer.MAX_VALUE;
		minCost = Integer.MAX_VALUE;
		for (int index = 0; index < m; index++) {
			line = reader.readLine().split(" ");
			int i = Integer.parseInt(line[0]);
			int j = Integer.parseInt(line[1]);
			cities[i][j] = Integer.parseInt(line[2]);
			if (cities[i][j] < cmin) {
				cmin = cities[i][j];
			}
		}
		x[1] = 1;
		visited[x[1]] = true;
		TRY(2);
		System.out.println(minCost);
	}

	static void TRY(int k) {
		for (int v = 2; v <= n; v++) {
			if (!visited[v]) {
				x[k] = v;
				visited[v] = true;
				if (cities[x[k - 1]][x[k]] > 0) {
					cost += cities[x[k - 1]][x[k]];
					if (k == n) {
						if (cities[x[k]][x[1]] > 0 && cost + cities[x[k]][x[1]] <= minCost) {
							minCost = cost + cities[x[k]][x[1]];
						}
					} else {
						int z = cost + (n - k + 1) * cmin;
						if (z <= minCost) {
							TRY(k + 1);
						}
					}
					cost -= cities[x[k - 1]][x[k]];
				}
				visited[v] = false;
			}
		}
	}
}

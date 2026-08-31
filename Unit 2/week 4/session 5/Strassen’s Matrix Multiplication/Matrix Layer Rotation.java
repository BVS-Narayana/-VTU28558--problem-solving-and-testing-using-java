import java.io.*;
import java.util.*;

public class Solution {

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();
        int numLayers = Math.min(m, n) / 2;

        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = matrix.get(i).get(j);
            }
        }

        for (int layer = 0; layer < numLayers; layer++) {
            List<Integer> elements = new ArrayList<>();

            // 1. Top row (left to right)
            for (int j = layer; j < n - layer; j++) {
                elements.add(res[layer][j]);
            }
            // 2. Right column (top + 1 to bottom - 1)
            for (int i = layer + 1; i < m - layer - 1; i++) {
                elements.add(res[i][n - layer - 1]);
            }
            // 3. Bottom row (right to left)
            for (int j = n - layer - 1; j >= layer; j--) {
                elements.add(res[m - layer - 1][j]);
            }
            // 4. Left column (bottom - 1 to top + 1)
            for (int i = m - layer - 2; i > layer; i--) {
                elements.add(res[i][layer]);
            }

            int len = elements.size();
            int shift = r % len; // Avoid redundant full loops

            // Write back shifted elements (anti-clockwise)
            int idx = shift;

            // 1. Top row
            for (int j = layer; j < n - layer; j++) {
                res[layer][j] = elements.get(idx);
                idx = (idx + 1) % len;
            }
            // 2. Right column
            for (int i = layer + 1; i < m - layer - 1; i++) {
                res[i][n - layer - 1] = elements.get(idx);
                idx = (idx + 1) % len;
            }
            // 3. Bottom row
            for (int j = n - layer - 1; j >= layer; j--) {
                res[m - layer - 1][j] = elements.get(idx);
                idx = (idx + 1) % len;
            }
            // 4. Left column
            for (int i = m - layer - 2; i > layer; i--) {
                res[i][layer] = elements.get(idx);
                idx = (idx + 1) % len;
            }
        }

        // Print final matrix
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(res[i][j]).append(j == n - 1 ? "" : " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);
        int n = Integer.parseInt(firstMultipleInput[1]);
        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] matrixRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            List<Integer> matrixRowItems = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int matrixItem = Integer.parseInt(matrixRowTempItems[j]);
                matrixRowItems.add(matrixItem);
            }

            matrix.add(matrixRowItems);
        }

        matrixRotation(matrix, r);
        bufferedReader.close();
    }
}
    

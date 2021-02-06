import java.util.Arrays;
import java.util.Vector;

class PrimAlgorithm {

    public static void main(String[] args) {
        int[][] adjacencyMatrix = { { 0, 2, 0, 6, 0 }, { 2, 0, 3, 8, 5 }, { 0, 3, 0, 0, 7 }, { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };

        int length = adjacencyMatrix.length;
        int[] parentNode = new int[length];
        int[] minValues = new int[length];
        Arrays.fill(minValues, Integer.MAX_VALUE);
        boolean[] mst = new boolean[length];
        Arrays.fill(mst, false);
        parentNode[0] = -1;
        minValues[0] = 0;
        for (int i = 0; i < length - 1; i++) {
            int min = Integer.MAX_VALUE;
            int minVertex = -1;
            for (int j = 0; j < length; j++) {
                if (mst[j] == false && minValues[j] < min) {
                    minVertex = j;
                    min = minValues[j];
                }
            }
            mst[minVertex] = true;
            for (int j = 0; j < length; j++) {
                if (adjacencyMatrix[minVertex][j] != 0 && mst[j] == false
                        && adjacencyMatrix[minVertex][j] <= minValues[j]) {
                    minValues[j] = adjacencyMatrix[minVertex][j];
                    parentNode[j] = minVertex;
                }
            }
        }
        for (int i = 1; i < length; i++) {
            System.out.println(parentNode[i] + "->" + i + " wt: " + adjacencyMatrix[parentNode[i]][i]);
        }
    }
}
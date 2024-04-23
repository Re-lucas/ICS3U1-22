public class AllSum {
    public static void main(String[] args) {
        int[][] data = {{3, 2, 5}, {1, 4, 4, 8, 13}, {9, 1, 0, 2}, {0, 2, 6, 4, -1, -8}};
        int sum = calculateSum(data);
        System.out.println("All sum inside are：" + sum);
    }

    private static int calculateSum(int[][] data) {
        int total = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                total += data[i][j];
            }
        }
        return total;
    }
}

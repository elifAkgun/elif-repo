package code.elif;

public class NumberOfIsland {
    public static void main(String[] args) {
        char[][] input = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '1'}
        };

        System.out.println(numIslands(input));
    }

    public static int numIslands(char[][] grid) {

        int numIsland = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    numIsland += searchLand(grid, i, j);
                }
            }
        }
        return numIsland;
    }

    private static int searchLand(char[][] input, int i, int j) {

        if (i < 0 || j < 0 || i > input.length || j > input.length || input[i][j] == '0') {
            return 0;
        }

        input[i][j] = '0';
        searchLand(input, i, j - 1);
        searchLand(input, i, j + 1);
        searchLand(input, i - 1, j);
        searchLand(input, i + 1, j );
        return 1; 
    }
}

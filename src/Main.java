import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

//Solution to: https://adventofcode.com/2021/day/9

public class Main {
    private static final int GRID_X = 100;
    private static final int GRID_Y = 100;
    private static int sumOfRisk = 0;

    public static void main(String[] args) throws IOException {
        int[][] grid = parseFile("C:\\Users\\Todd\\Desktop\\adventOfCodeDayNine\\src\\input.txt");
        solveGrid(grid);
        System.out.println(sumOfRisk);
    }

    private static void solveGrid(int[][] grid) {
        for(int x = 0; x < GRID_X; x++)
            for(int y = 0; y < GRID_Y; y++) {
                HashSet<Integer> neighbours = new HashSet<>();
                //Left
                if(x - 1 >= 0) neighbours.add(grid[x - 1][y]);
                //Right
                if(x + 1 < 100) neighbours.add(grid[x + 1][y]);
                //Up
                if(y - 1 >= 0) neighbours.add(grid[x][y - 1]);
                //Down
                if(y + 1 < 100) neighbours.add(grid[x][y + 1]);

                //If our number is lower than smallest neighbour, sum
                if(Collections.min(neighbours) > grid[x][y]) {
                    sumOfRisk += 1 + grid[x][y];
                }
            }

    }

    private static int[][] parseFile(String s) throws IOException {
        Scanner scan = new Scanner(new FileReader(s));
        int y = 0;
        int[][] grid = new int[GRID_X][GRID_Y];

        //Parse too grid
        while(scan.hasNext()) {
            String line = scan.next();
            int x = 0;
            for(char i : line.toCharArray()) {
                grid[x][y] = Character.getNumericValue(i);
                x++;
            }
            y++;
        }

        return grid;
    }
}

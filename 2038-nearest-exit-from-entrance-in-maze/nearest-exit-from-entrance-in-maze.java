import java.util.*;

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1], 0});

        // mark entrance visited
        maze[entrance[0]][entrance[1]] = '+';

        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1], steps = curr[2];

            for (int[] d : directions) {
                int nr = r + d[0];
                int nc = c + d[1];

                // valid move
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && maze[nr][nc] == '.') {

                    // check if it's an exit
                    if (nr == 0 || nr == m-1 || nc == 0 || nc == n-1) {
                        return steps + 1;
                    }

                    // mark visited
                    maze[nr][nc] = '+';
                    queue.offer(new int[]{nr, nc, steps + 1});
                }
            }
        }

        return -1;
    }
}
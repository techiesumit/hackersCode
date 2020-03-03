package aws.hackerrank.code;
//https://leetcode.com/discuss/interview-question/411357/
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Solution {
    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, -1, 0, 1};

    public int orangesRotting(int[][] grid) {
        int gridLen = grid.length, colLen = grid[0].length;

        Queue<Integer> queue = new ArrayDeque<Integer>();
        Map<Integer, Integer> depth = new HashMap<Integer, Integer>();
        for (int r = 0; r < gridLen; ++r)
            for (int c = 0; c < colLen; ++c)
                if (grid[r][c] == 2) {
                    int code = r * colLen + c;
                    queue.add(code);
                    depth.put(code, 0);
                }

        int ans = 0;
        while (!queue.isEmpty()) {
            int code = queue.remove();
            int r = code / colLen, c = code % colLen;
            for (int k = 0; k < 4; ++k) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (0 <= nr && nr < gridLen && 0 <= nc && nc < colLen && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    int ncode = nr * colLen + nc;
                    queue.add(ncode);
                    depth.put(ncode, depth.get(code) + 1);
                    ans = depth.get(ncode);
                }
            }
        }

        for (int[] row: grid)
            for (int v: row)
                if (v == 1)
                    return -1;
        return ans;

    }
    public static void main(String[] args) {
	//	new Solution().orangesRotting(grid)
	}
}


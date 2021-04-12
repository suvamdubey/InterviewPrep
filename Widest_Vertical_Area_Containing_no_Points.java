import java.util.Arrays;

public class Widest_Vertical_Area_Containing_no_Points {
    /**
     * Given n points on a 2D plane where points[i] = [xi, yi], Return the widest
     * vertical area between two points such that no points are inside the area.
     * 
     * A vertical area is an area of fixed-width extending infinitely along the
     * y-axis (i.e., infinite height). The widest vertical area is the one with the
     * maximum width.
     * 
     * Note that points on the edge of a vertical area are not considered included
     * in the area.
     * https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/
     */
    class Solution {
        public int maxWidthOfVerticalArea(int[][] p) {
            Arrays.sort(p, (a, b) -> Integer.compare(a[0], b[0]));
            int h = p[1][0] - p[0][0];
            for (int i = 1; i < p.length; i++) {
                int c = p[i][0] - p[i - 1][0];
                if (c > h)
                    h = c;
            }
            return h;
        }
    }
}

import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        Set<Point> points = new HashSet<>();

        for (int i = 0; i < line.length - 1; i++) {
            for (int j = i + 1; j < line.length; j++) {
                long a1 = line[i][0], b1 = line[i][1], c1 = line[i][2];
                long a2 = line[j][0], b2 = line[j][1], c2 = line[j][2];

                long demon = a1 * b2 - b1 * a2;
                
                if (demon == 0) continue;

                long tmpX = b1 * c2 - c1 * b2;
                long tmpY = c1 * a2 - a1 * c2;

                if (tmpX % demon != 0 || tmpY % demon != 0) continue;

                long x = tmpX / demon;
                long y = tmpY / demon;

                points.add(new Point(x, y));
            }
        }

        long minX = Long.MAX_VALUE, maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE, maxY = Long.MIN_VALUE;

        for (Point p : points) {
            minX = Math.min(minX, p.getX());
            maxX = Math.max(maxX, p.getX());
            minY = Math.min(minY, p.getY());
            maxY = Math.max(maxY, p.getY());
        }

        int width = (int)(maxX - minX + 1);
        int height = (int)(maxY - minY + 1);

        char[][] grid = new char[height][width];
        for (char[] row : grid) {
            Arrays.fill(row, '.');
        }

        for (Point p : points) {
            int x = (int)(p.getX() - minX);
            int y = (int)(maxY - p.getY());
            grid[y][x] = '*';
        }

        String[] result = new String[height];
        for (int i = 0; i < height; i++) {
            result[i] = new String(grid[i]);
        }

        return result;
    }

    class Point {
        private final long x;
        private final long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        public long getX() {
            return x;
        }

        public long getY() {
            return y;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Point)) return false;
            Point p = (Point) o;
            return this.x == p.x && this.y == p.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}


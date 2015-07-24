package pl.bohocode.toptal;// you can also use imports, for example:


/**
 * We persist last vertical (east and west) and horizontal (north and south)
 * segments we've drawn. When moving vertically, we check collisions with
 * stored horizontal segments, and accordingly when moving horizontally,
 * we check collisions with stored vertical segments.
 *
 * Space complexity is constant O(1), and time complexity linear O(N);
 */
class Solution3 {
    public int solution(int[] A) {
        Segment west = new Segment();
        Segment north = new Segment();
        Segment south = new Segment();
        Segment east = new Segment();

        Segment newwest = new Segment();
        Segment newnorth = new Segment();
        Segment newsouth = new Segment();
        Segment neweast = new Segment();

        int x = 0;
        int y = 0;
        int oldx = 0;
        int oldy = 0;

        // write your code in Java SE 8
        for (int i = 0; i < A.length; i++) {
            oldx = x;
            oldy = y;

            if (i%4 == 0) {//north
                y+=A[i];
                newwest = new Segment(x, oldy, x, y);
                if (north.intersects(newwest) || south.intersects(newwest)) return i;
                south = newsouth;
            }
            if (i%4 == 1) {//east
                x+=A[i];
                newnorth = new Segment(x, y, oldx, y);
                if (east.intersects(newnorth) || west.intersects(newnorth)) return i;
                west = newwest;

            }
            if (i%4 == 2) {//south
                y-=A[i];
                neweast = new Segment(x, y, x, oldy);
                if (north.intersects(neweast) || south.intersects(neweast)) return i;
                north = newnorth;
            }
            if (i%4 == 3) {//west
                x-=A[i];
                newsouth = new Segment(x, y, oldx, y);
                if (east.intersects(newsouth) || west.intersects(newsouth)) return i;

                east = neweast;
            }

        }
        return 0;
    }


    class Segment {
        int x1 = 0, x2 = 0, y1 = 0, y2 = 0;

        public Segment() {
        }

        public Segment(int x1, int y1, int x2, int y2) {
            this.x1 = Math.min(x1, x2);
            this.x2 = Math.max(x1, x2);
            this.y1 = Math.min(y1, y2);
            this.y2 = Math.max(y1, y2);
        }

        boolean intersects(Segment that) {
            if (x1 == x2 && y1 == y2) return false;

            return (that.x1 <= this.x1 && that.x2 >= this.x2 &&
                    this.y1 <= that.y1 && this.y2 >= that.y2)
                    ||
                    (that.y1 <= this.y1 && that.y2 >= this.y1 &&
                            this.x1 <= that.x1 && this.x2 >= that.x2);
        }

        @Override
        public String toString() {
            return String.format("(%d, %d), (%d, %d)", x1, y1, x2, y2);
        }
    }
}
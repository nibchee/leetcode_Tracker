class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        for (int x = xCenter - radius; x <= xCenter + radius; x++) {
            for (int y = yCenter - radius; y <= yCenter + radius; y++) {
                if ((x - xCenter) * (x - xCenter) + (y - yCenter) * (y - yCenter) <= radius * radius) {
                    if (x >= x1 && x <= x2 && y >= y1 && y <= y2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

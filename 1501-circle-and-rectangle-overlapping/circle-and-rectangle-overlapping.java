class Solution {
    private int compute_dist(int x1,int y1, int x2, int y2){
        return ((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    }
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        // int d1=compute_dist(xCenter,yCenter,x1,y1);
        // int d2=compute_dist(xCenter,yCenter,x2,y2);
        // int d3=compute_dist(xCenter,yCenter,x1,y2);
        // int d4=compute_dist(xCenter,yCenter,x2,y1);
        // return Math.min(Math.min(d1,d2),Math.min(d3,d4))<=radius*radius;
        int near_x=Math.max(x1,Math.min(x2,xCenter));
        int near_y=Math.max(y1,Math.min(y2,yCenter));
        return (xCenter-near_x)*(xCenter-near_x)+(yCenter-near_y)*(yCenter-near_y)<=radius*radius;
    }
}
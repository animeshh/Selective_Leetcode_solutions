// Source : https://leetcode.com/problems/gray-code/
// Author : Animesh Gupta
// Date   : 2015-09-29

/************************************************************************************************** 
Algorithm: Logic is to create hashmap everytime for new point and saving its slope with all other poins.
Max_points gives count of  points on same line having this point then maxCount would be the max_points on all the lines.
**************************************************************************************************/
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    boolean dup(Point point1,Point point2){
        return (point1.x==point2.x && point1.y==point2.y);
    }
    double getSlope(Point point1,Point point2){
        double y_diff = point1.y- point2.y;
        double x_diff = point1.x- point2.x;
        if(y_diff==0) return 0;
        else if(x_diff==0) return Double.POSITIVE_INFINITY;
        return y_diff/x_diff;
    }
    public int maxPoints(Point[] points) {
        if(points.length<=2) return points.length;
        int maxCount =0;
        for(int i=0;i<points.length;i++){
            int max_points=1;
            int dup=0;
            HashMap<Double,Integer> map = new HashMap<Double,Integer>();
            for(int j=i+1;j<points.length;j++){
                
                if(dup(points[i],points[j])){
                    dup++;
                    continue;
                }
                double slope = getSlope(points[i],points[j]);
                if(map.containsKey(slope)){
                    map.put(slope,map.get(slope)+1);
                }
                else{
                    map.put(slope,2);
                }
                max_points = Math.max(max_points,map.get(slope));
            }
            maxCount = Math.max(maxCount,max_points+dup);
            if(maxCount==points.length) 
                break;
        }
        return maxCount;
    }
}

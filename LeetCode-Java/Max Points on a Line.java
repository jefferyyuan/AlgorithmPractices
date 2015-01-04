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
    public int maxPoints(Point[] points) {
        ArrayList<Point> uniquePoints = new ArrayList<Point>();
        ArrayList<Integer> dupCount = new ArrayList<Integer>();
        for(int i = 0;i < points.length; i ++)
        {
            boolean isUnique = true;
            for(int j = 0;j < uniquePoints.size();j ++)
            {
                Point p1 = points[i];
                Point p2 = uniquePoints.get(j);
                if(p1.x == p2.x && p1.y == p2.y)
                {
                    isUnique = false;
                    dupCount.set(j, dupCount.get(j) + 1);
                    break;
                }
            }
            if(isUnique)
            {
                uniquePoints.add(points[i]);
                dupCount.add(1);
            }
        }
        if(uniquePoints.size() == 0)
            return 0;
        else if(uniquePoints.size() == 1)
            return dupCount.get(0);
        int maxCount = 0;
        //HashSet<Integer> record = new HashSet<Integer>();
        for(int i = 0;i < uniquePoints.size() ;i ++)
        {
            //if(record.contains(i))
            //    continue;
            boolean hasFind = false;
            for(int j = i + 1;j < uniquePoints.size();j ++)
            {
                //if(record.contains(j))
                //    continue;
                int count = dupCount.get(i) + dupCount.get(j);
                for(int k = j + 1;k < uniquePoints.size();k ++)
                {
                    Point p1 = uniquePoints.get(i);
                    Point p2 = uniquePoints.get(j);
                    Point p3 = uniquePoints.get(k);
                    if((p3.x - p1.x) * (p2.y - p1.y) == (p2.x - p1.x) * (p3.y - p1.y))
                    {
                        if(hasFind)
                        {
                            count += dupCount.get(k);
                            //record.add(k);
                        }
                        else
                        {
                            hasFind = true;
                            count += dupCount.get(k);
                            //record.add(j);
                            //record.add(k);
                        }
                    }
                }
                maxCount = Math.max(maxCount, count);
                if(hasFind)
                    break;
            }
        }
        return maxCount;
    }
}
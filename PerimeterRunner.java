import edu.duke.*;

public class PerimeterRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }
    
    public int getNumPoints(Shape s) {
        int numOfPoints = 0;
        
        for(Point currPt : s.getPoints()) {
            numOfPoints += 1;
        }
        
        return numOfPoints;
    }
    
    public double getAverageLength(Shape s) {
        double avgLength = 0.0;
        double totalPerim = 0.0;
        int numOfPoints = 0;
        
        Point prevPt = s.getLastPoint();
       
        for(Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            totalPerim = totalPerim + currDist; 
            numOfPoints += 1;
            prevPt = currPt;
        }
        
        avgLength = totalPerim / numOfPoints;
        
        return avgLength;
    }
    
    public double getLargestSide(Shape s) {
        double largestSide = 0.0;
        double currDist = 0.0;
        double prevDist = 0.0;
        
        Point prevPt = s.getLastPoint();
        
        for(Point currPt : s.getPoints()) {
            currDist = prevPt.distance(currPt);
            
            if(prevDist < currDist)
            {
                largestSide = currDist;
            }
            
            prevDist = currDist;
        }
        
        return largestSide;
    }
    
    public double getLargestX(Shape s) {
        double largestXPos = 0.0;
        double prevX = 0.0;
        double currX = 0.0;
        
        Point prevPt = s.getLastPoint();
        
        for(Point currPt : s.getPoints()) {
            currX = currPt.getX();
            
            if(prevX < currX)
            {
                largestXPos = currX; 
            }
            
            prevX = currX;
        }
        
        return largestXPos;
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        double avgLength = getAverageLength(s);
        double largestSide = getLargestSide(s);
        double largestXPos = getLargestX(s);
        int numOfTotalPoints = getNumPoints(s);
        System.out.println("perimeter = " + length);
        System.out.println("The shape's total number of points = " + numOfTotalPoints);
        System.out.println("The shape's average length = " + avgLength);
        System.out.println("The shape's largest side = " + largestSide);
        System.out.println("The shape's largest X = " + largestXPos);
    }

    public static void main (String[] args) {
        PerimeterRunner pr = new PerimeterRunner();
        pr.testPerimeter();
    }
}

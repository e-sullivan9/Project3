//Jaocb Dwyer
//Venue class for the Amazing Race project
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import project3.Route;
public class Venue
{
  private int a,b,c,d;
  //private ArrayList <Integer> distanceList = new ArrayList<Integer>();
  private int distanceAB, distanceBC, distanceCD, distanceAC, distanceAD, distanceBD;
  Random random = new Random();
  ArrayList<Route> route;
  
  public Venue()
  {
    a = random.nextInt(2000)+500;
    b = random.nextInt(2000)+500;
    b = random.nextInt(2000)+500;
    b = random.nextInt(2000)+500;
    route = createRoute();
  }
  //Create an array of distances so that they can be randomly accessed later
  //distanceList.add(distanceAB);
  
//Setters for the distances between the points
  public void setDisAB()
  {
    distanceAB = a + b;
  }
  
  public void setDisBC()
  {
    distanceBC = b + c;
  }
  
  public void setDisCD()
  {
    distanceCD = c + d;
  }
  
  public void setDisAC()
  {
    distanceAC = a + c;
  }
  
  public void setDisAD()
  {
    distanceAD = a + d;
  }
  
  public void setDisBD()
  {
    distanceBD = b + d;
  }
  
//Getters for the distances between the points
  public int getDisAB()
  {
    return distanceAB;
  }
  
  public int getDisBC()
  {
    return distanceBC;
  }
  
  public int getDisCD()
  {
    return distanceCD;
  }
  
  public int getDisAC()
  {
    return distanceAC;
  }
  
  public int getDisAD()
  {
    return distanceAD;
  }
  
  public int getDisBD()
  {
    return distanceBD;
  }
  
  //Returns total distance of track
  public int getTotalDistance()
  {
    int totalDistance = a + b + c + d;
      return totalDistance;
  }
  public ArrayList<Route> createRoute(){
      ArrayList<Route> temp = new ArrayList<>();
      int i = random.nextInt(3);
      switch(i){
          case 0:
               temp.add(new Route(new ImageIcon("A.jpg"),a));
               temp.add(new Route(new ImageIcon("B.jpg"),b));
               temp.add(new Route(new ImageIcon("C.jpg"),c));
               temp.add(new Route(new ImageIcon("D.jpg"),d));
              break;
         case 1:
               temp.add(new Route(new ImageIcon("B.jpg"),b));
               temp.add(new Route(new ImageIcon("A.jpg"),a));
               temp.add(new Route(new ImageIcon("C.jpg"),c));
               temp.add(new Route(new ImageIcon("D.jpg"),d));
              break;
         case 2:
               temp.add(new Route(new ImageIcon("C.jpg"),c));
               temp.add(new Route(new ImageIcon("A.jpg"),a));
               temp.add(new Route(new ImageIcon("D.jpg"),d));
               temp.add(new Route(new ImageIcon("B.jpg"),a));
              break;
         case 3:
               temp.add(new Route(new ImageIcon("B.jpg"),a));
               temp.add(new Route(new ImageIcon("C.jpg"),c));
               temp.add(new Route(new ImageIcon("A.jpg"),a));
               temp.add(new Route(new ImageIcon("D.jpg"),d));
              break;
         default:
               temp.add(new Route(new ImageIcon("A.jpg"),a));
               temp.add(new Route(new ImageIcon("C.jpg"),c));
               temp.add(new Route(new ImageIcon("B.jpg"),a));
               temp.add(new Route(new ImageIcon("D.jpg"),d));
              break;
      }
      
      return temp;
  }
  public ArrayList<Route> getRoutes(){
      return route;
  }
}


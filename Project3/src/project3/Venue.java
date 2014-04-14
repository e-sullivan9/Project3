package project3;
//Jaocb Dwyer
//Venue class for the Amazing Race project
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
public class Venue
{
  private int a,b,c,d;
  Random random = new Random();
  ArrayList<Route> route;
  
  public Venue()
  {
    a = 1000;
    b = 1500;
    c = 500;
    d = 2000;
    route = createRoute();
  //Returns total distance of track
  }
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
               temp.add(new Route(new ImageIcon("B.jpg"),b));
              break;
         case 3:
               temp.add(new Route(new ImageIcon("B.jpg"),b));
               temp.add(new Route(new ImageIcon("C.jpg"),c));
               temp.add(new Route(new ImageIcon("A.jpg"),a));
               temp.add(new Route(new ImageIcon("D.jpg"),d));
              break;
         default:
               temp.add(new Route(new ImageIcon("A.jpg"),a));
               temp.add(new Route(new ImageIcon("C.jpg"),c));
               temp.add(new Route(new ImageIcon("B.jpg"),b));
               temp.add(new Route(new ImageIcon("D.jpg"),d));
              break;
      }
      
      return temp;
  }
  public ArrayList<Route> getRoutes(){
      return route;
  }
}


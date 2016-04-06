import java.awt.event.*;
import java.awt.geom.Line2D;
import java.awt.*;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class TreePanel extends JPanel
{
   private final int PANEL_WIDTH = 1600;
   private final int PANEL_HEIGHT = 900;

   private final double RATIO = 0.72;

   private int current; 
   
   private final double BTHETA = Math.toRadians(60.0);
   private final double BTHETA2 = Math.toRadians(00.0);
   
   private String choice;
   private String color1;
   private String color2;
   public TreePanel (int currentOrder)
   {
      current = currentOrder;
      setBackground (Color.black);
      setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
      this.setFocusable(true);
      
      Object[] possibilities = {"Choice1", "Choice 2", "Choice 3"};
      choice = (String)JOptionPane.showInputDialog(
                null,
                "Choose a Pattern",
                "Input",
                JOptionPane.PLAIN_MESSAGE,
                null,
                possibilities,
                possibilities[0]);
                
      Object[] colors = {"Red", "Blue", "Green"};
      color1 = (String)JOptionPane.showInputDialog(
                null,
                "Choose a Color",
                "Input",
                JOptionPane.PLAIN_MESSAGE,
                null,
                colors,
                colors[0]);
                
      color2 = (String)JOptionPane.showInputDialog(
                null,
                "Choose a Color",
                "Input",
                JOptionPane.PLAIN_MESSAGE,
                null,
                colors,
                colors[0]);
      
   }


   public void drawFractal (int order, double x1, double y1, double theta, double distance,
                            Graphics2D g2)
   {
      double deltaXPlus, deltaYPlus, deltaXMinus, deltaYMinus, x2, y2, x3, y3, plusTheta, minusTheta;
      Random r1 = new Random();
      
      distance *= RATIO;
      plusTheta = theta + BTHETA;
      minusTheta = theta - BTHETA2;
      
      if(order > 20 || order == 1)
      {
          return;
      }
      else
      {
          deltaXPlus = (distance * Math.sin(plusTheta));
          deltaYPlus = (distance * Math.cos(plusTheta));
          
   
          
          x2 = x1 - deltaXPlus;
          y2 = y1 - deltaYPlus;
          
 
          
          if (x2 < 1720 && x2 > 0 && y2 < 1060 && y2 > 0)
          {
             g2.setStroke(new BasicStroke((float)distance/12));
             //g2.setColor(new Color(0, (int)(255 * (((x2/1920)>1 || (x2/1920)<0)?1:(x2/1920))), (int)(255 * (((y2/1080>1 || (y2/1080)<0))?1:(y2/1080))))); 
             
             g2.setColor(ColorCreator.generateColor(color1, color2, x2, y2));
                          
             g2.draw(new Line2D.Double(x1, y1, x2, y2));
             drawFractal(order - 1, x2, y2, plusTheta, distance, g2);
          }
     }
   }
   

   //-----------------------------------------------------------------
   //  Performs the initial calls to the drawFractal method.
   //-----------------------------------------------------------------
   public void paintComponent (Graphics page)
   {
      Graphics2D g2 = (Graphics2D) page;
      super.paintComponent (g2);
      g2.setColor (new Color(155,155,155));
      g2.setStroke(new BasicStroke(20));
      
      //g2.draw(new Line2D.Double(PANEL_WIDTH/2, 600, PANEL_WIDTH/2, 900));
      drawFractal (current, PANEL_WIDTH/2, PANEL_HEIGHT/2, 270.6, 250.0, g2);
      drawFractal (current, PANEL_WIDTH/2, PANEL_HEIGHT/2, 720, 250.0, g2);
      drawFractal (current, PANEL_WIDTH/2, PANEL_HEIGHT/2, 360, 250.0, g2);
      drawFractal (current, PANEL_WIDTH/2, PANEL_HEIGHT/2, 200, 250.0, g2);
   }

   //-----------------------------------------------------------------
   //  Sets the fractal order to the value specified.
   //-----------------------------------------------------------------
   public void setOrder (int order)
   {
      current = order;
   }

   //-----------------------------------------------------------------
   //  Returns the current order.
   //-----------------------------------------------------------------
   public int getOrder ()
   {
      return current;
   }
   
   
    
   
}
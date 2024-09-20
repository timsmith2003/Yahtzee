/*Tim Smith
  CS2100
  Class for the creation and manipulation of Die objects and values*/
import java.util.Random;
public class Die 
{
   //Instance varibales
   private int value;
   private static final int SIDES = 6;
   Random r = new Random();
   /*Class constructor*/
   public Die()
   {
      value = r.nextInt(6)+1;
   }
   /*Assigns a random value 1-6 to the DIe object value
   @param none
   @return none*/
   public void roll()
   {
      value = r.nextInt(6)+1;
   }
   /*Getter*/
   public int getValue()
   {
      return value;
   }
   /*String representation of the value held by the Die object
   @param none
   @return formatted string with the Die's value*/
   @Override
   public String toString()
   {
      return String.format("%d", value);
   }
}
   
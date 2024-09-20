/*Tim Smith
  CS2100
  an extention of the category class, overrides the evaluate method*/
public class FullHouse extends Category
{
   /*Overriding the evaluate method for Full house category, awards 25 points if a pair and a three of a kind occur
   @param dice object
   @return int value with the score*/
   @Override
   public int evaluate(Dice d)
   {
      boolean two = false;
      boolean three = false;
      
      for (int i = 1; i < 7; i++)
      {
         if (d.count(i)==2)
            two = true;
      }
      for (int i = 1; i < 7; i++)
      {
         if (d.count(i)==3)
            three = true;
      }
      
      if (two == true && three == true)
         return 25;
      return 0;
   }
}
   
     
         
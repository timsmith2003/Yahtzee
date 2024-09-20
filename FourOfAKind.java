/*Tim Smith
  CS2100
  Extends the category class and overrides the evaluate method for the Fourofakind category*/
public class FourOfAKind extends Category
{
   /*Overriding the evaluate method for four of a kind category, adds up all die
   @param dice object
   @return int value with the score*/
   @Override
   public int evaluate(Dice d)
   {
      boolean four = false;
      
      for (int i = 1; i < 7; i++)
      {
         if (d.count(i)>=4)
            four = true;
      }
      if (four == true)
         return d.sum();
      return 0;
   }
}
   
     
         
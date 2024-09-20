/*Tim Smith
  CS2100
  Abstract class creates abstract methos evaluate to be 
  Overridden in all categories*/
public abstract class Category
{
   //instance variables
   private int score = 0;
   private boolean used;
   /* Evaluates the score of the dice given a specifica category
   @param A Dice object
   @return in integer containing the score*/
   
   public abstract int evaluate(Dice d);
   
   /*Setts the variable used to true and sets score to what it 
   was evaluated as
   @param Dice object
   @return NONE*/
   public void addValue(Dice d)
   {
      int i = evaluate(d);
      used = true;
      score = i;
   }
   
   //Getters
   
   public int getScore()
   {
      return score;
   }
   public boolean getUsed()
   {
      return used;
   }
}
      
   
      
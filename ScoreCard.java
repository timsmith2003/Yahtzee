/*Tim Smith
  CS2100
  Class for creating and manipulating the players scorecards*/
import java.util.*;
public class ScoreCard
{
   //instance varibles
   private ArrayList<Category> scorecard = new ArrayList<>(NUM_CATS);
   private int yahtzeeBonus = 0;
   private static final int NUM_CATS = 13;
   
   /*Class constructor*/
   public ScoreCard()
   {
      Ones ones = new Ones();
      Twos twos = new Twos();
      Threes threes = new Threes();
      Fours fours = new Fours();
      Fives fives = new Fives();
      Sixes sixes = new Sixes();
      ThreeOfAKind toak = new ThreeOfAKind();
      FourOfAKind foak = new FourOfAKind();
      FullHouse fh = new FullHouse();
      SmallStraight ss = new SmallStraight();
      LargeStraight ls = new LargeStraight();
      Yahtzee y = new Yahtzee();
      Chance chance = new Chance();
      
      
      //Adding all of the category objects to the card
      scorecard.add(ones);
      scorecard.add(twos);
      scorecard.add(threes);
      scorecard.add(fours);
      scorecard.add(fives);
      scorecard.add(sixes);
      scorecard.add(toak);
      scorecard.add(foak);
      scorecard.add(fh);
      scorecard.add(ss);
      scorecard.add(ls);
      scorecard.add(y);
      scorecard.add(chance);
   }
   /*Selects the category to be scored and marks it as used as well as presents the score on the card
   @param Category chosed and Dice object
   @return NONE*/
   public void choose(CategoryValue cv, Dice d)
   {
      for (CategoryValue c : CategoryValue.values())
      {
         if (c == cv)
            scorecard.get(c.getValue()).addValue(d);
            
      }
   }
   /*Selects the category to be evaluated and presents the user with the score that would be awarded if that category were chosen
   @param Category chosen and Dice object
   @return Int with the potential score*/
   public int getEvaluation(CategoryValue cv, Dice d)
   {
      for (CategoryValue c : CategoryValue.values())
      {
         if (c == cv)
         {
            return scorecard.get(c.getValue()).evaluate(d);
         }
      }
      return 0; 
   }
   /*Selects the category to see if it has ben used yet by player
   @param Category chosed and Dice object
   @return Boolean stating wether the category has been used or not*/
   public boolean checkScored(CategoryValue cv, Dice d)
   {
      for (CategoryValue c : CategoryValue.values())
      {
         if (c == cv)
            return scorecard.get(c.getValue()).getUsed();
      }
      return false; 
   }
   /*/*Selects the category that the score will be shown, diplays current score of a category
   @param Category chosed and Dice object
   @return Int with the score of the category*/
   public int getCategoryScore(CategoryValue cv, Dice d)
   {
      for (CategoryValue c : CategoryValue.values())
      {
         if (c == cv)
         {
            return scorecard.get(c.getValue()).getScore();
         }
      }
      return 0;
   }
   /*Adds the scores of the "Top" categories (ones, twos....sixes)
   @param NONE
   @return Int score of the top categories*/
   public int scoreTop()
   {
      int total = 0;
      for (int i = 0; i < 6; i++)
      {
         total+=scorecard.get(i).getScore();
      }
      return total;
   }
   /*Adds the scores of the "Bottom" categories (Small Straight, Full house....Yahtzee)
   @param NONE
   @return Int score of the bottom categories*/
   public int scoreBottom()
   {
      int total = 0;
      for (int i = 6; i < 11; i++)
      {
         total+=scorecard.get(i).getScore()+yahtzeeBonus*100;
      }
      return total;
   }
   /*Adds the scores of all of the categories
   @param NONE
   @return Int score of all of the categories combines*/

   public int score()
   {
      int total = 0;
      for (int i = 0; i <11; i++)
      {
         total+=scorecard.get(i).getScore()+yahtzeeBonus*100;
      }
      return total;
   }
   /*String representation of the scores held by each category on the scorecard
   @param NONE
   @return String representation of all scores*/
   @Override
   public String toString()
   {
      return String.format("Current Scorecard:\n%15s: %d\n%15s: %d\n%15s: %d\n%15s: %d\n%15s: %d\n%15s: %d\n%15s: %d\n%15s: %d\n%15s: %d\n%15s: %d\n%15s: %d\n%15s: %d\n%15s: %d\n%15s: %d\n%15s: %d\n%15s: %d\n%15s: %d\n", "Ones", scorecard.get(0).getScore(), "Twos", scorecard.get(1).getScore(), "Threes", scorecard.get(2).getScore(), "Fours", scorecard.get(3).getScore(), "Fives", scorecard.get(4).getScore(), "Sixes", scorecard.get(5).getScore(), "Three of a Kind", scorecard.get(6).getScore(), "Four of a Kind", scorecard.get(7).getScore(), "Full House", scorecard.get(8).getScore(), "Small Straight", scorecard.get(9).getScore(), "Large Straight", scorecard.get(10).getScore(), "Yahtzee", scorecard.get(11).getScore(), "Chance", scorecard.get(12).getScore(), "Yahtzee Bonus", yahtzeeBonus,  "Upper Total", scoreTop(),"Bottom Total", scoreBottom(), "Total", score()); 
   }
          
}
      
    
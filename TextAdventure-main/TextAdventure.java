import java.util.*;

public class TextAdventure 
{
  FancyConsole console;
  Scanner inScanner;
  Player ourHero;
  public TextAdventure()
  {
    console = new FancyConsole("Great Text Adventure!", 600, 600);
    inScanner = new Scanner(System.in);

    // feel free to change the player's starting values
    ourHero = new Player("Bob", 100, 0);
  }

  public void play()
  {
    String input;
    // start of adventure. You can change this if you like
    console.setImage("bb2.png");

    // ask the user for their name.
    System.out.println("What is your username?\n");
    input = inScanner.nextLine();

    // Change ourHero's name
    ourHero.changeName(input);
    // ADD CODE HERE
    
    // describe the starting situation. Feel free to change this
    System.out.println("You wake up to find yourself in the sky on the battlebus. \n With a pickaxe in hand, and a glider on your back, you look to the map ahead. \nWhere we dropping? \n1. tilted towers: a blooming city, filled with loot and many enemies.\n2. pleasant park: calm suburbs... that is until everyone drops.\n3. shifty shafts: an old mine, filled with lots of goodies.\n4. loot lake: a beautiful large lake, with a waterfront property in the center.\n: ");

    // get user input and go to the appropriate zone based on their input
    System.out.println("What will you choose? (write the number)\n");
    input = inScanner.nextLine();
    // ADD CODE HERE
    if(input.equals("1")){
      enterZone1();
    }
    else if(input.equals("2")){
      enterZone2();
    }
    else if(input.equals("3")){
      enterZone3();
    }
    else if(input.equals("4")){
      enterZone4();
    }
    else{
      System.out.println("You failed to choose a location.");
      gameEndLose();
    }

  }

  private void enterZone1()
  {
    // change image
    console.setImage("tilted.jpg");
    // ADD CODE HERE
    System.out.print("You land on top of a building. You descend down the stairs and find a chest.\n Inside you find a");
    int rarity = (int)(Math.random()*5)+1;
    int wc;
    if(rarity == 1){
      System.out.println(" Common gun.");
      wc = 1;
    }
    if(rarity == 2){
      System.out.println("n Uncommon gun.");
      wc = 2;
    }
    if(rarity == 3){
      System.out.println(" Rare gun.");
      wc = 3;
    }
    if(rarity == 4){
      System.out.println("n Epic gun.");
      wc = 5;
    }
    if(rarity == 5){
      System.out.println(" Legendary gun.");
      wc = 6;
    }
    System.out.println("The storm begins closing and you have to move. Where will you go?\n1. dusty divot\n2. salty springs\n");
    String input = inScanner.nextLine();
    if(input.equals("1")){
      enterZone5();
    }
    else if(input.equals("2")){
      enterZone6();
    }
    else{
      System.out.println("You failed to move and died in the storm.");
      gameEndLose();
    }

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE

    // Take action or go to another zone based on their choice
    // ADD CODE HERE

  }

  private void enterZone2()
  {
    // change image
    // ADD CODE HERE
    console.setImage("ppark.png");
    System.out.println("You arrive in the field. While observing your surroundings you begin to be shot at.");
    int wc = (int)(Math.random()*5)+1;
    System.out.println(wc);
    if(wc>2){
      System.out.println("You shoot back at the other player and eliminate them.");
      System.out.println("Would you like to stay, or leave?\n1. Stay in Pleasant Park\n2. Go to dusty divot\n");
      String input = inScanner.nextLine();
      if(input.equals("1")){
        int storm = (int)(Math.random()*2)+1;
        if(storm == 1){
          System.out.println("You survive the final storm circle. There is one player left. Would you like to fight them or hide?\n1. fight\n2. hide\n");
          input = inScanner.nextLine();
          if(input.equals("1")){
            gameEndVic();
            System.out.println("You fight the remaining player and eliminate them!");
          }
          if(input.equals("2")){
            gameEndLose();
            System.out.println("You hid and the other player found and eliminated you.");
          }          
        }
        if(storm == 2){
          System.out.println("You decide to stay, however the storm soon begins to close in on you.\n You are stranded and die in the storm.");
          gameEndLose();
        }
       //* else if(input.equals("2")){
         // enterZone5();
        //}
        //else{
          //System.out.println("You did nothing and died.");
          //gameEndLose();
        //}
      }
      else if(input.equals("2")){
        enterZone5();
      }
      else{
        System.out.println("You did nothing and died.");
        gameEndLose();
      }
    }
    else{
        System.out.println("You have two options.\n1. run away\n2. fight back\n");
        String input = inScanner.nextLine();
        if(input.equals("1")){
          System.out.println("Where would you like to go?\n1. dusty divot\n2. salty springs\n");
          input = inScanner.nextLine();
          if(input.equals("1")){
            enterZone5();
          }
          else if(input.equals("2")){
            enterZone6();
          }
        }
        if(input.equals("2")){
          System.out.println("The other player has a better gun and eliminates you. You lose, game over");
          gameEndLose();
        }
        
    }
    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE 

    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }

  private void enterZone3()
  {
    console.setImage("shafts.jpg");
    System.out.println("You arrive at shifty shafts and notice many people landing above you.");
    System.out.println("You notice a loot drop on your mini map. What would you like to do?\n1. Go to the loot drop\n2. Go to salty springs.\n");
    String input = inScanner.nextLine();
    if(input.equals("1")){
      System.out.println("You venture off to the loot drop. As you are opening it,\n someone snipes you from a nearby hill and eliminates you.");
      gameEndLose();
    }
    if(input.equals("2")){
      enterZone6();
    }
    // change image
    // ADD CODE HERE

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE

    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }

  private void enterZone4()
  {
    console.setImage("lake.jpg");
    System.out.println("As your flying over the lake you have two landing options.\n1. The lake\n2. The house\n");
    String input = inScanner.nextLine();
    if(input.equals("1")){
      System.out.println("Your fortnite character is very unathletic and cannot swim. You drown");
      gameEndLose();
    }
    if(input.equals("2")){
      System.out.println("You land on the roof and begin breaking into the house. Inside you find a variety of good weapons.");
      System.out.println("Nobody else landed here, so you have two options.\n1. Camp out the rest of the game\n2. Move to a new location");
      input = inScanner.nextLine();
      if(input.equals("1")){
        System.out.println("You got extremely lucky, and the final storm circle is at loot lake.");
        System.out.println("You see the remaining player along the outskirts of the lake. How would you like to eliminate them?");
        System.out.println("1. Snipe them\n2. Throw a boogie bomb and then pickaxe them\n");
        input = inScanner.nextLine();
        if(input.equals("1")){
          System.out.println("You snipe them in the head and win!");
          gameEndVic();
        }
        if(input.equals("2")){
          System.out.println("You boogie bomb them and quickly swim over, just in time to eliminate them.");
          gameEndVic();
        }
      }
      else{
        System.out.println("Where would you like to go?\n1. Dusty Divot\n2. Salty Springs\n");
        input = inScanner.nextLine();
        if(input.equals("1")){
          enterZone5();
        }
        if(input.equals("2")){
          enterZone6();
        }
      }
    }
    // change image
    // ADD CODE HERE

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE

    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }

  private void enterZone5()
  {
    // change image
    console.setImage("divot.jpg");
    System.out.println("After a long journey, you finally make it to Dusty Divot. There are five players remaining.");
    System.out.println("A few more players die and you spot the last player afar.\n Would you like to snipe them? (Yes or No)\n");
    String Input = inScanner.nextLine();
    if(Input.equals("Yes")||(Input.equals("yes"))){
      int wc = (int)(Math.random()*2)+1;
      System.out.print("You line up your shot ");
      if(wc == 1){
        System.out.println("and eliminate the player.");
        gameEndVic();
      }
      else{
        System.out.println("and miss. The player notices and begins shooting at you.\n In the heat of the moment you panic and get eliminated.");
        gameEndLose();
      }
    }
    if(Input.equals("No")||(Input.equals("no"))){
      System.out.println("You slowly observe them as they walk around, looking for you.\n In your inventory you see a boogie bomb.\n Would you like to use it? (Yes or No)\n");
      Input = inScanner.nextLine();
      if(Input.equals("Yes")||(Input.equals("yes"))){
        System.out.println("You hit them with the boogie bomb, and then snipe them.");
        gameEndVic();
      }
      if(Input.equals("no")||(Input.equals("No"))){
        System.out.println("While thinking, the other player spots you and snipes you. You get eliminated.");
        gameEndLose();
      }
    }
    // ADD CODE HERE

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE

    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }

  private void enterZone6()
  {
    console.setImage("salty.jpg");
    System.out.println("Upon arriving at Salty springs, you see many houses and a gas station. Which would you like to enter?\n1. Enter the house\n2. Enter the gas station\n");
    String input =inScanner.nextLine();
    if(input.equals("1")){
      System.out.println("When you enter, someone pops out behind the stairs and shoots you. You get eliminated.");
      gameEndLose();
    }
    if(input.equals("2")){
      System.out.println("You enter the gas station and find a mending machine.\n Would you like to buy meds?(Yes or No)\n");
      input = inScanner.nextLine();
      if(input.equals("Yes")||(input.equals("yes"))){
        System.out.println("You now have 150 health, giving you an advantage over other opponents.");
        System.out.println("In the house across the street, you see the final player. \nYou quickly rush into the house and fight him.\n Because you have extra health, you easily eliminate your opponent.");
        gameEndVic();
      }
      if(input.equals("no")||(input.equals("No"))){
        System.out.println("In the house across the street, you see the final player.\n You quickly rush into the house and fight him.\n Unfortunately the other player was smarter and decided to buy meds, therefore gaining extra health.");
        System.out.println("You try to fight them, but in the end, they have more health and easily eliminate you.");
        gameEndLose();
      }
    }
    // change image
    // ADD CODE HERE

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE

    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }

  private void gameEndVic()
  {
    console.setImage("vict.jpg");
    System.out.println("Congratulations, you won!");

    inScanner.close();
  }
  private void gameEndLose()
  {
    // ADD CODE HERE
    console.setImage("lose.png");
    System.out.println("You lost. Now going back to lobby.");
    inScanner.close();
  }
}
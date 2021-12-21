
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 41756
 */
public class Game {
  public final int IN_INVENTORY=-1;
    protected Player player1;
    protected String[] allItems;
    protected Item[] codedItems;
    protected Room[] rooms;
    

    //protected means accesible to all subclasses but no other classes
    //only Nisghtshade can access it
    public Game() {

        initGame();
    }

   
    
    
    public Item getItems(int location) {
        return codedItems[0];
    }

    protected Player setUpPlayer() {
        Scanner in = new Scanner(System.in);

//        System.out.println("Enter player's name: ");
        String name = in.next();
//        System.out.println("       ");
        return new Player(name, "game player", -1);

    }

    private void initGame() {

        System.out.println("Player setup");
        System.out.println("**************************\n");

//        System.out.println("Setting up Game");
        setUpPlayer();
    }

  public void showVisibleItems(int room){
    String items="";
    Translate T;
    for(int i=0;i<codedItems.length;i++){
        if(Math.abs(codedItems[i].getLocation())==room){
            T=new Translate(codedItems[i].getName());
            
            
           
       items=T.getTranslation() + "";
        }
    }
      System.out.println("Items: "+ items);
  }
    
    
    public static void main(String[] args) {
//        Item i= new Item("key", "key to safe box", 5);
//        System.out.println(i);

//         Item i2= new Item();
//        System.out.println("\n"+i2);
//Player p1= new Player("Muna", "player", 17);
        Game game = new Nightshade();
//        for (int i = 0; i < game.allItems.length; i++) {
//            System.out.println(game.allItems[i]);
//        }

//nightShade.setUpPlayer();
//        System.out.println(nightShade.player1);
    }
}

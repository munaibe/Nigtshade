
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 41756
 */
public class Player extends Item {
    
      public ArrayList<Item> inventory=new ArrayList<Item>();
    
    
    public Player(String n, String d, int l){
        super(n,d,l);
    
    }
    
    public void addToInventory(Item i){
        inventory.add(i);
    }
    
     public void showInventory(){
        if(inventory.size()==0){
            System.out.println("Nothing to display");
        }else{
            System.out.print("BackPAck Contents:");
            //loop through arrraylist displaying each item
            for(Item i:inventory){
                Translate T=new Translate(i.getName());
                System.out.println(T.getTranslation()+"");
            }
            System.out.println("");
        }
    }
    
    public String toString(){
        return("Player is in room"+ getLocation());
    }
}

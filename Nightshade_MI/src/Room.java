
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
public class Room extends Item {
    
    private int exits[]= new int[6];
    private ArrayList<String> items= new ArrayList<String>();
    
    
    public Room(String name, String desc, int loc, int n, int s, int e, int w,
            int u, int d){
        super(name, desc, loc);
        
        
        exits[0]=n;
        exits[1]=s;
        exits[2]=e;
        exits[3]=w;
        exits[4]=u;
        exits[5]=d;
        
    }

   
    
    public String getExits(){
         //outPut shoukld lool like exits
         String exits="";
         String [] exitValues= {"N", "S", "E", "W", "U", "D"};
         
         for(int i=0;i<this.exits.length;i++){
             if(this.exits[i]>0){
                 exits="" +exitValues[i];
             }
         }
         return exits;
         
    }
    
     public int getExit(int dir){
        return exits[dir];
    }
    
    
    public String toString(){
     return getDescription() +"||"+ getExits();
   }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 41756
 */
public class Item {

    private String name;
    private String description;
    private int location;

    public Item(String n, String d, int l){
        //Constructor idd for load the nstance variables with data
        this.name= n;
        this.description=d;
        this.location=l;
    }
    
    public Item(String n, int l){
        this.name=n;
        this.location=l;
        this.description="";
    }
    
    public Item(){
        
    }
       
    public void setName(String name) {

    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {

    }

    public String getDescription() {
        return description;
    }

    public void setLocation(int location) {

    }

    public int getLocation() {
        return location;
    }
    
    public String toString(){
        if(!getDescription().equals("")){
        return("Item: "+ getName()+ "\nDescription: "+ getDescription()+ "\nLocation:" + getLocation());
    }
return("Item: "+ getName()+"\nLocation:" + getLocation() );
}
    
    
    
    
    
}

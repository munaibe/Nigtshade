/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author munai
 */
public class Translate {
    private String translated;
    
    public Translate (String nightshade){
        setTranslation(nightshade);
    }
 
    
    public String getTranslation(){
        return this.translated;
    }
    
 
    
    
    public void setTranslation(String nightshade){
        String result="";
        char character;
        
        
        for(int i=0; i<nightshade.length();i++){
            character=nightshade.charAt(i);
            character-=1;
            result+=Character.toString(character);
        }
        translated=result;
        
    }
}

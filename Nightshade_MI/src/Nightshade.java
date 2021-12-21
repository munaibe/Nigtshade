
import java.io.File;
import java.io.FileNotFoundException;
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
public class Nightshade extends Game {

   
    private int prevBoatRoom;
    private int curRoomNum=5 ;
    private Room curRoom;
    private int ItemsInInventory = 0;
    private int numGlueIngredients = 0;
    private boolean trollFainted = false;
    private String verb;
    private String noun;
    private String completeNoun;
    private String[] nounNames;
    private int[] nounIndex;
        private final int NUM_ROOMS = 30;
    private final int ITEM_USED=-4;
    private final int MAX_ROOM_ITEM=4;
    private final int NOT_IN_GAME=0;
    
    
    
    
    
    public Nightshade() {
//        System.out.println("NIGHTSHADE!!!!!!!!!");
//        System.out.println(player1);
        init();
    }

    private void setRoomData(int room) {
        switch (room) {
            case 8:
            case 9:
            case 10: {
                codedItems[ItemsEnums.Items.TREES.ordinal()].setLocation(-curRoomNum);
                break;
            }
            case 11: {
                codedItems[ItemsEnums.Items.TREES.ordinal()].setLocation(-curRoomNum);
                codedItems[ItemsEnums.Items.SWAMP.ordinal()].setLocation(-curRoomNum);
                break;
            }
            case 15: {
                codedItems[ItemsEnums.Items.SWAMP.ordinal()].setLocation(-curRoomNum);
                break;
            }
            case 29:{
                setBoatRoom(prevBoatRoom);
                break;
            }
        }
    }

    private void setBoatRoom(int pbr){
          rooms[prevBoatRoom]=new Room("In a smaal boat", "", 29, 0,0,0,0,pbr,0);
    }
    
    private void init() {
//        System.out.println("Nightshade setUpPlayer");
rooms = new Room[NUM_ROOMS + 1];
        player1 = setUpPlayer();
        addRooms();
        loadItems();
        listRooms();
//        loadCodedItems();
//        testCoded();
//       codedItems = new Item[1];
//        codedItems[0] = new Item("KEY", 1);

        curRoom = rooms[curRoomNum];
        //test getter
        System.out.println("Coded items: " + getItems(1));
        Update();

    }

    private void Update()  {
//        System.out.println(curRoom);
//        System.out.println("-----------------------------");
//        System.out.println("What would youu like to do?");
//        System.out.println("Get help(?)");
//        System.out.println("Exit gamme(!)");

        Scanner in = new Scanner(System.in);
        

          setRoomData(curRoomNum);
        curRoom = rooms[curRoomNum];
        System.out.println(curRoom);
        super.showVisibleItems(curRoomNum);
       player1.showInventory();


        processInput();
    }

    private void addRooms() {

//        System.out.println("Adding Rooms");
//        prevBoatRoom = 12;
//        Room r = new Room("Entry", "a large entry", 10, 13, 0, 11, 0, 0, 0);
        File file = new File("src/RoomData.txt");

        try {
            Scanner in = new Scanner(file);

            int numLines = 0;
            while (in.hasNextLine()) {
                in.nextLine();
                numLines++;
//                String s=in.nextLine();
//                System.out.println(numLines);
            }

            numLines = numLines / 2;

            rooms = new Room[numLines];
            in.close();

            rooms = new Room[31];

            in = new Scanner(file);
            for (int i = 0; i < numLines; i++) {
                int location = in.nextInt();
                String name = in.next();
                String desc = in.nextLine();
                int n = in.nextInt();
                int s = in.nextInt();
                int e = in.nextInt();
                int w = in.nextInt();
                int u = in.nextInt();
                int d = in.nextInt();

                rooms[location] = new Room(name, desc, location, n, s, e, w, u, d);
            }

        } catch (FileNotFoundException e) {
            //happens if file isnt found
            System.out.println("Items file not found");
        }

        //System.out.println(r);
        //r.getExits();
    }

    protected Player setUpPlayer() {

        System.out.println("Enter the name of the adveturer who will help denny in his Nightshade quest");
        
        Player p = super.setUpPlayer();

        //ask for avatar name
        ////other nightshade game player method that you would not NOT need in spooky mansion
        return p;
    }

    private void loadItems() {

        //  System.out.println(System.getProperty("user.dir"));
        File file = new File("src/ItemsEnum.txt");
 
        // System.out.println(file);
        try {
            Scanner in = new Scanner(file);

           int numLines = 0;
            while (in.hasNextLine()) {
                in.nextLine();
                numLines++;
//                String s=in.nextLine();
//                System.out.println(numLines);
            }
            allItems = new String[numLines];
            in.close();

            in = new Scanner(file);
            numLines = 0;
            while (in.hasNextLine()) {
                allItems[numLines] = in.nextLine();
                System.out.println(allItems[numLines]);
                numLines++;

            }
            in.close();
        } catch (FileNotFoundException e) {
            //happens if file isnt found
            System.out.println("Items file not found");
        }

        File file2 = new File("src/codedItems.txt");

        try {
            Scanner in = new Scanner(file2);
            int numLines = 0;
            while (in.hasNextLine()) {
                in.nextLine();
                numLines++;
//                String s=in.nextLine();
//                System.out.println(numLines);
            }
            codedItems = new Item[numLines];
            in.close();

            in = new Scanner(file2);
            numLines = 0;
            while (in.hasNextLine()) {
                String name = in.next();
                int location = in.nextInt();

                codedItems[numLines] = new Item(name, location);
                numLines++;
            }
            in.close();
        } catch (FileNotFoundException e) {
            //happens if file isnt found
            System.out.println("Items file not found");
        }

        for (int i = 0; i < codedItems.length; i++) {
            System.out.println(codedItems[i]);
        }

        
        
//        File file3 = new File("src/nounNames.txt");
//
//        try {
//            Scanner in = new Scanner(file3);
//            int numLines = 0;
//            while (in.hasNextLine()) {
//                in.nextLine();
//                numLines++;
////                String s=in.nextLine();
////                System.out.println(numLines);
//            }
//           nounNames = new String[numLines];
//            in.close();
//
//            in = new Scanner(file3);
//            numLines = 0;
//            while (in.hasNextLine()) {
//                String name = in.next();
//               
//
//                nounNames[numLines] = new String(name);
//                numLines++;
//            }
//            in.close();
//        } catch (FileNotFoundException e) {
//            //happens if file isnt found
//            System.out.println("Items file not found");
//        }
    
        
        
        
    }

    private void listRooms() {
        for (int i = 0; i < rooms.length; i++) {
            System.out.println("Room: " + rooms[i]);
        }
    }

    private int getDirection(String dir) {
        dir = dir.toUpperCase();
        switch (dir) {
            case "N":
                return 0;
            case "S":
                return 1;
            case "E":
                return 2;
            case "W":
                return 3;
            case "U":
                return 4;
            case "D":
                return 5;
            default:
                 return -1;
        }
        
    }

    private void movePlayer(String dir) {
        System.out.println("Moving");
        int direction = getDirection(dir);
        if (direction != -1) {
            if (curRoom.getExit(direction) > 0) {
                curRoomNum = curRoom.getExit(direction);
                Update();
            } else {//bad command...not a direction
                System.out.println("\nDenny cant move that way.\n");
                Update();
            }
        }
        
        else {
            System.out.println("\nDenny doesn't understand.");
            Update();
        }
        
    }

   public void processVerb() {
   
        switch (verb) {
            case "LOO":
            case "EXA":
                doExamine();
                break;
            case "GLU":
                doGlue();
                break;
            case "MOV":
                doMove();
                break;
            case "TAK":
            case "GET":
                doGet();
                break;
            case "GIV":
            case "PUT":
            case "DRO":
                doDrop();
                break;
            case "TAL":
                doTalk();
                break;
            case "DRI":
                doDrink();
                break;
            case "CLI":
                doClimb();
                break;
            case "SIN":
                doSing();
                break;
            case "ENT":
            case "GO":
            case "GO ":
                    doGo();
                    break;
            case "SAY":
                doSay();
                break;
            case "SMA":
            case "HIT":
                doHit();
                break;
                    
            default:
                System.out.println("Denny doesnt' know how to do that.");
                Update();
        }
        System.out.println("");
        //updateGame();
    }

    private void displayHelp() {
        System.out.println("Help coming sooon");
        Update();
    }

 public void processInput() {

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        //if the string is only length 1, it is a direction or a cry for help
        if (input.length() == 1) {

            if (input.equals("!")) {
                System.out.println("Wakey wakey!");
                System.exit(0);

            } else if (input.equals("?")) {
                displayHelp();
            } //else move in the requested direction
            else {
                movePlayer(input);
            }
        } else { //assume there is 2 words here

            in = new Scanner(input);
            verb = in.next().trim().toUpperCase();
            if (verb.equals("GO")) verb="GO ";
            noun = in.nextLine().trim().toUpperCase();
            if (noun.length() < 3 || verb.length() < 3) //invalid command
            {
                System.out.println("\nDenny does not understand.\n");
            } //there is an run time error here if only 1 word entered
            else {
                verb = verb.substring(0, 3);
                completeNoun = noun.toString();
                noun = noun.substring(0, 3);
                System.out.println("Verb " + verb + "Noun " + noun);
                processVerb();
            }
        }

    }

     public int getItemNumber(){
     
        for(int i=0;i<nounNames.length;i++){
            if(noun.equals(nounNames[i])){
                return (nounIndex[i]);
            }
        }
        
        return -1;
    }
    
     
       private int getNumRoomItems(){
         int num=0;
         //enhanced for loop to go through codeditems
         for(Item i:codedItems){
             if(Math.abs(i.getLocation())==curRoomNum){
                 num++;
             }
         }
         return num;
     }
   
       
        private void doDrop(){
         int numRoomItems=getNumRoomItems();
         int itemNum=getItemNumber();
         System.out.println("Dropping: "+itemNum + completeNoun);
         
         
         if(itemNum==-1){
             System.out.println("Cant drop what doesnt exist.");
         }
         else if(numRoomItems==MAX_ROOM_ITEM){
             System.out.println("No room here. ");
         }
         else if(codedItems[itemNum].getLocation()!=IN_INVENTORY){
             System.out.println("Denny doesnt have that.");
         }
         else if (codedItems[ItemsEnums.Items.JUG.ordinal()].getLocation() == IN_INVENTORY
                && (noun.equals("CRY") || noun.equals("MUD") || noun.equals("ALG"))) {
            System.out.println("In the jug...");
            codedItems[itemNum].setLocation(ITEM_USED);

 

            numGlueIngredients = numGlueIngredients + 1;

 

            if (numGlueIngredients == 3) {
                codedItems[ItemsEnums.Items.JUGWITHGLUE.ordinal()].setLocation(IN_INVENTORY);
                codedItems[ItemsEnums.Items.JUG.ordinal()].setLocation(NOT_IN_GAME);
                codedItems[ItemsEnums.Items.TROLL.ordinal()].setLocation(-19);
                System.out.println("Denny made the magical glue!");
            }
        } else if (curRoomNum == 19 && trollFainted == false
                && noun.equals("MIR") && codedItems[ItemsEnums.Items.MIRROR.ordinal()].getLocation() == IN_INVENTORY) {
            System.out.println("The troll saw himself in the mirror and fainted!");
            trollFainted = true;
            codedItems[ItemsEnums.Items.MIRROR.ordinal()].setLocation(curRoomNum);
            codedItems[ItemsEnums.Items.FAINTEDTROLL.ordinal()].setLocation(-curRoomNum);
            codedItems[ItemsEnums.Items.TROLL.ordinal()].setLocation(NOT_IN_GAME);

 

        } else {
            codedItems[itemNum].setLocation(curRoomNum);
             System.out.println("Denny dropped it.");
        }
     }
       
        private void doDennyWakes(String msg){
         System.out.println("Denny wakes mission incomplete. ");
         init();
     }
        
        public void doGet() {
        int itemNum;
        itemNum = getItemNumber();
        System.out.println("");

        if (itemNum == -1) {
            System.out.println("No such item.");

        } else if (curRoomNum != Math.abs(codedItems[itemNum].getLocation())) {
            System.out.println("That item isn't here.");

        } else if (codedItems[itemNum].getLocation() == -curRoomNum) {
            System.out.println("Denny can't pick that up!");

        } else if (curRoomNum == 26 && (noun.equals("HAM") || noun.equals("HUG"))
                && codedItems[ItemsEnums.Items.POTION.ordinal()].getLocation() != ITEM_USED) {
            System.out.println("The hammer's too heavy.");

        } else {
            //add to inventory
            codedItems[itemNum].setLocation(IN_INVENTORY);
            player1.addToInventory(codedItems[itemNum]);
            System.out.println("Denny got it.");
        }

        Update();

    }
        
        
        public void doMove() {

        // System.out.println(currRoomNum + " " + noun +codedItems[ItemsEnum.Items.GLOWINGDOOR.ordinal()].getLoc()  );
        if (curRoomNum == 6 && noun.equals("CLO")) {
            if (codedItems[ItemsEnums.Items.GLOWINGDOOR.ordinal()].getLocation() == NOT_IN_GAME) {

                System.out.println("\nThere's a strange doorway!\n");
                codedItems[ItemsEnums.Items.GLOWINGDOOR.ordinal()].setLocation(-curRoomNum);

                // System.out.println(codedItems[ItemsEnum.Items.GLOWINGDOOR.ordinal()].getLoc();
            } else { //wrong room
                System.out.println("\nDenny sees the closet wall.\n");
            }
        } else {
            System.out.println("\nDenny can't move that.\n");
        }
//
        Update();
    }
        
   public void doGlue() {
        if (codedItems[ItemsEnums.Items.JUGWITHGLUE.ordinal()].getLocation() == IN_INVENTORY
                && codedItems[ItemsEnums.Items.BOOK.ordinal()].getLocation() == IN_INVENTORY
                && codedItems[ItemsEnums.Items.PAGE.ordinal()].getLocation() == IN_INVENTORY
                && (noun.equals("BOOK") || noun.equals("PAG"))) {
            if (curRoomNum != 5 && curRoomNum != 6) {
                System.out.println("\nYou can't do that here.");
            } else {
                System.out.println("\nCongratulations! You saved Nightshade.");
                //StartNewGame
            }
        } else {
            System.out.println("\nDenny can't glue that.");
        }

        Update();
    }      
        
        public void doExamine() {
       // System.out.println(currRoomNum == codedItems[ItemsEnum.Items.BOOK.ordinal()].getLoc());
       // System.out.println(noun);
        if (noun.equals("BOO"))//&& codedItems[ItemsEnum.Items.BOOK.ordinal()].getLoc() == currRoomNum)
        {
            System.out.println("yes");
            System.out.println("\nIt looks interesting.\n");
        } else if (noun.equals("GIA") && codedItems[ItemsEnums.Items.GIANT.ordinal()].getLocation() == -curRoomNum) {
            System.out.println("\nHe's carrying an huge hammer.\n");
        } else if (noun.equals("BOA") && codedItems[ItemsEnums.Items.BOAT.ordinal()].getLocation() == -curRoomNum) {
            System.out.println("\nYep, it's definitely a boat.\n");
        } else if (noun.equals("MIR")
                && codedItems[ItemsEnums.Items.MIRROR.ordinal()].getLocation() == IN_INVENTORY) {
            System.out.println("\nSome writing says UGLIES DON'T USE THIS.\n");
        } else if (noun.equals("BOO")
                && codedItems[ItemsEnums.Items.BOOK.ordinal()].getLocation() == IN_INVENTORY) {
            System.out.println("\nThe last page is missing.\n");
        } else if (noun.equals("TRE") && curRoomNum == 10
                && codedItems[ItemsEnums.Items.WOODENDOOR.ordinal()].getLocation() == NOT_IN_GAME) {
            System.out.println("\nThere's a door in it.\n");
            codedItems[ItemsEnums.Items.WOODENDOOR.ordinal()].setLocation(-curRoomNum);
        } else if (curRoomNum == 11 && noun.equals("TRE")) {
            System.out.println("\nAn arrow points up.\n");
        } else if (curRoomNum == 23 && noun.equals("STR")
                && codedItems[ItemsEnums.Items.ALGAE.ordinal()].getLocation() == NOT_IN_GAME) {
            System.out.println("\nDenny sees something!\n");
            codedItems[ItemsEnums.Items.ALGAE.ordinal()].setLocation(curRoomNum);
        } else if (curRoomNum == 21 && (noun.equals("GLA") || noun.equals("DOO"))
                && codedItems[ItemsEnums.Items.GLASSDOOR.ordinal()].getLocation() == -curRoomNum) {
            System.out.println("\nDenny sees his bedroom!\n");
        } else if (curRoomNum == 19 && (noun.equals("TRO") || noun.equals("FAI"))
                && codedItems[ItemsEnums.Items.FAINTEDTROLL.ordinal()].getLocation() == -curRoomNum
                && codedItems[ItemsEnums.Items.PAGE.ordinal()].getLocation() == NOT_IN_GAME) {
            System.out.println("\nHe has a BOOK page!\n");
            codedItems[ItemsEnums.Items.PAGE.ordinal()].setLocation(curRoomNum);
        } else if ((noun.equals("FAN") || noun.equals("BOX"))
                && codedItems[ItemsEnums.Items.FANCYBOX.ordinal()].getLocation() == IN_INVENTORY) {
            System.out.println("\nIt says: Use blue scroll\n");
        } else if (noun.equals("BLU")
                && codedItems[ItemsEnums.Items.BLUESCROLL.ordinal()].getLocation() == IN_INVENTORY) {
            System.out.println("\nIt says: Asy rpseot\n");
        } else if ((noun.equals("SHE") || noun.equals("MUS"))
                && codedItems[ItemsEnums.Items.SHEETMUSIC.ordinal()].getLocation() == IN_INVENTORY) {
            System.out.println("\nIt's a very moving piece.\n");
        } else if ((noun.equals("REC") || noun.equals("CAR"))
                && codedItems[ItemsEnums.Items.RECIPECARD.ordinal()].getLocation() == IN_INVENTORY) {
            System.out.println("\nGlue: mud, algae, crystal.\n");
        } else if (noun.equals("RED")
                && codedItems[ItemsEnums.Items.REDSCROLL.ordinal()].getLocation() == IN_INVENTORY) {
            System.out.println("\nIt says: Asy mseesa\n");
        } else if (curRoomNum == 21 && noun.equals("SIG")) {
            System.out.println("\nIt says: Ali Baba was  here.\n");
        } else if (curRoomNum == 19 && noun.equals("TRO")
                && codedItems[ItemsEnums.Items.TROLL.ordinal()].getLocation() == -curRoomNum) {
            System.out.println("\nHe's frighteningly ugly.\n");
        } else if (noun.equals("PAG") && codedItems[ItemsEnums.Items.PAGE.ordinal()].getLocation() == IN_INVENTORY) {
            System.out.println("\nIt's from the BOOK.\n");
        } else if (noun.equals("POT") && codedItems[ItemsEnums.Items.POTION.ordinal()].getLocation() == IN_INVENTORY) {
            System.out.println("\nIt says: For strength.\n");
        } else {
            System.out.println("\nDenny sees nothing of value.");
        }

        Update();
    }
        
    public void doDrink() {
        System.out.println("");
        if (noun.equals("POT") && codedItems[ItemsEnums.Items.POTION.ordinal()].getLocation() == IN_INVENTORY) {
            System.out.println("Strength surges into Denny's body.");
            codedItems[ItemsEnums.Items.POTION.ordinal()].setLocation(ITEM_USED);
        } else {
            System.out.println("Denny can't drink that.");
        }

        Update();
    }
   
     public void doClimb() {
        System.out.println("");
        if (curRoomNum == 11 && noun.equals("TRE")) {
            curRoomNum = 28;
            System.out.println("Denny climbs the tree.");
        } else {
            System.out.println("Denny won't climb that.");
        }
        Update();
    }
   
     public void doSing() {
        System.out.println("");
        if ((noun.equals("SHE") || noun.equals("MUS"))
                && codedItems[ItemsEnums.Items.SHEETMUSIC.ordinal()].getLocation() == IN_INVENTORY) {
            if (curRoomNum == 29) {
                if (prevBoatRoom == 17) {
//        Exits(UP) = 12;
                    prevBoatRoom = 12;
                    setBoatRoom(prevBoatRoom);

                } else {
//        Exits(UP) = 17
                    prevBoatRoom = 17;
                    setBoatRoom(prevBoatRoom);

                    codedItems[ItemsEnums.Items.BOAT.ordinal()].setLocation(-prevBoatRoom);

                    System.out.println("The boat glides across the pond.");
                }
            } else {
                System.out.println("While Denny sings, the boat begins to rock.");
            }
        }

        Update();
    }
   
    public void doSay() {
        System.out.println("");
        if (codedItems[ItemsEnums.Items.FANCYBOX.ordinal()].getLocation() == IN_INVENTORY
                && codedItems[ItemsEnums.Items.POTION.ordinal()].getLocation() == NOT_IN_GAME
                && codedItems[ItemsEnums.Items.BLUESCROLL.ordinal()].getLocation() == IN_INVENTORY
                && completeNoun.equals("PRESTO")) {

            System.out.println("The box opens, and the scroll vanishes.");
            codedItems[ItemsEnums.Items.POTION.ordinal()].setLocation(curRoomNum);
            codedItems[ItemsEnums.Items.BLUESCROLL.ordinal()].setLocation(ITEM_USED);

        } else if (curRoomNum == 21 && codedItems[ItemsEnums.Items.REDSCROLL.ordinal()].getLocation() == IN_INVENTORY
                && codedItems[ItemsEnums.Items.GLASSDOOR.ordinal()].getLocation() == NOT_IN_GAME
                && completeNoun == "SESAME") {
            codedItems[ItemsEnums.Items.GLASSDOOR.ordinal()].setLocation(-curRoomNum);
            codedItems[ItemsEnums.Items.REDSCROLL.ordinal()].setLocation(ITEM_USED);
            System.out.println("A glass door appears!");

        } else {
            System.out.println("Denny says " + completeNoun);
        }

        Update();
    }
   
       
      public void doHit() {
        System.out.println("");

        if (curRoomNum == 24 && noun.equals("BOU")
                && codedItems[ItemsEnums.Items.HUGEHAMMER.ordinal()].getLocation() == IN_INVENTORY
                && codedItems[ItemsEnums.Items.CRYSTALS.ordinal()].getLocation() == NOT_IN_GAME) {
            System.out.println("When the hammer hits, a boulder crumbles.");
            codedItems[ItemsEnums.Items.CRYSTALS.ordinal()].setLocation(curRoomNum);
            codedItems[ItemsEnums.Items.BITSOFROCK.ordinal()].setLocation(curRoomNum);
        } else {
            System.out.println("Denny doesn't want to hit that.");
        }

        Update();
    }
    
      
      
        public void doGo() {
        if (curRoomNum == 5 && noun.equals("BED")) {
            System.out.println("Zzzzzzzzzzzzzzzzz.");

        } else if (curRoomNum == 6 && (noun.equals("GLO") || noun.equals("DOO"))
                && codedItems[ItemsEnums.Items.GLOWINGDOOR.ordinal()].getLocation() == -curRoomNum) {

            curRoomNum = 8;

            System.out.println("Denny goes through the door.");

        } else if (curRoomNum == 15 && noun.equals("HUT")) {
            curRoomNum = 16;
            System.out.println("Denny enters the hut.");
            
            
        } else if (curRoomNum == 17 && noun.equals("TUN")
                && codedItems[ItemsEnums.Items.TUNNEL.ordinal()].getLocation() == -curRoomNum) {

            curRoomNum = 18;

            System.out.println("Denny goes through the tunnel.");
        } else if (codedItems[ItemsEnums.Items.BOAT.ordinal()].getLocation() == -curRoomNum && noun.equals("BOA")) {

            curRoomNum = 29;

            System.out.println("Denny gets into the boat.");
        } else if (curRoomNum == 10 && (noun.equals("WOO") || noun.equals("DOO"))
                && codedItems[ItemsEnums.Items.WOODENDOOR.ordinal()].getLocation() == -curRoomNum) {

            curRoomNum = 13;

            System.out.println("Denny goes through the wooden door.");
        } else if ((curRoomNum == 11 || curRoomNum == 15) && noun.equals("SWA")) {

            if (codedItems[ItemsEnums.Items.WATERSHOES.ordinal()].getLocation() == IN_INVENTORY) {

                curRoomNum = 14;
                System.out.println("Denny uses the water shoes to cross the swamp.");
            } else {
                System.out.println("Denny sinks into the swamp.");

                doDennyWakes("Denny sinks into the swamp.");
            }
        } else if (curRoomNum == 18 && noun.equals("BRA")) {
            System.out.println("Denny's falling into empty blackness!");
            doDennyWakes("Denny's falling into blackness!");

        } else if (curRoomNum == 18 && noun.equals("SIL")) {
            curRoomNum = 19;
            System.out.println("Denny goes through the silver door.");

        } else if (curRoomNum == 18 && noun.equals("GOL")) {
            curRoomNum = 21;
            System.out.println("Denny goes through the gold door.");

        } else if (curRoomNum == 21 && noun.equals("GLA")
                && codedItems[ItemsEnums.Items.GLASSDOOR.ordinal()].getLocation() == -curRoomNum) {
            if (codedItems[ItemsEnums.Items.BOOK.ordinal()].getLocation() == IN_INVENTORY
                    || codedItems[ItemsEnums.Items.BOOK.ordinal()].getLocation() == 5
                    || codedItems[ItemsEnums.Items.BOOK.ordinal()].getLocation() == 6
                    && codedItems[ItemsEnums.Items.JUGWITHGLUE.ordinal()].getLocation() == IN_INVENTORY
                    && codedItems[ItemsEnums.Items.PAGE.ordinal()].getLocation() == IN_INVENTORY) {

                curRoomNum = 5;
                System.out.println("Denny goes through the glass door.");
            } else {
                System.out.println("Denny has failed his mission.");
                doDennyWakes("");
            }
        } else if (noun.equals("DOO")) {
            System.out.println("Which door?");
        } else {
            System.out.println("Denny doesn 't want to go there.");
        }

        Update();
    }
      
     public void doTalk() {
        if (curRoomNum == 13 && (noun.equals("ELF") || noun.equals("FAM"))
                && codedItems[ItemsEnums.Items.WATERSHOES.ordinal()].getLocation() == NOT_IN_GAME) {
            System.out.println("They show Denny something.");

            codedItems[ItemsEnums.Items.WATERSHOES.ordinal()].setLocation(curRoomNum);
        } else if (curRoomNum == 13 && (noun.equals("ELF") || noun.equals("FAM"))
                && codedItems[ItemsEnums.Items.WATERSHOES.ordinal()].getLocation() == IN_INVENTORY) {
            System.out.println("They think Denny should leave.");

        } else if (curRoomNum == 26 && noun.equals("GIA")
                && codedItems[ItemsEnums.Items.HUGEHAMMER.ordinal()].getLocation() == NOT_IN_GAME) {
            System.out.println("He offers Denny something");
            codedItems[ItemsEnums.Items.HUGEHAMMER.ordinal()].setLocation(curRoomNum);

        } else if (curRoomNum == 17 && noun.equals("DWA")
                && codedItems[ItemsEnums.Items.TUNNEL.ordinal()].getLocation() == NOT_IN_GAME) {

            System.out.println("He points to something");
            codedItems[ItemsEnums.Items.TUNNEL.ordinal()].setLocation(-curRoomNum);
        } else if (curRoomNum == 26 && noun.equals("GIA") || curRoomNum == 17 && noun.equals("DWA")) {
            System.out.println("He has nothing else to say.");
        } else if (curRoomNum == 30 && (noun.equals("HAG") || noun.equals("OLD"))) {
            System.out.println("She pinched Denny");
            doDennyWakes("The hag pinched Denny!");
        } else {
            System.out.println("Denny can't talk to that.");
        }

        Update();
    }
    
}

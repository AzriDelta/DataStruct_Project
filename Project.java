/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
//import java.util.LinkedList;

/**
 *
 * @author Azri Zai
 */
public class Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ParseException {
        // TODO code application logic here
        
        MainMenu();
    }
    
    //---------------------------------------------------//
    
    public static void MainMenu() throws IOException, ParseException { //1.1
        
        boolean pass = false;
        
        while (pass != true) { // selagi tak masukkan code yang betul, sentiasa loop main menu
            
            System.out.println("Time - " + DisplayTime() + "\t" + "Date - " + DisplayDate());
            System.out.println("---------- AUCTION SYSTEM ----------");
            System.out.println("---------- MAIN MENU ----------");
            System.out.println("");

            System.out.println("[1] Register");
            System.out.println("[2] Login");
            System.out.println("[3] Enter the auction");
            System.out.println("[4] Exit the program");

            Scanner a = new Scanner(System.in);
            
        
        
        
            System.out.print("Enter the number of your choice: ");
            int choice = a.nextInt();
            System.out.println("");
            System.out.println("");

            if (choice == 1) {
                
                Registration();
                pass = true;
            }

            else if (choice == 2){
                
                Login();
                pass = true;
            }
            
            else if (choice == 3){
                
                Auction();
                pass = true;
            }

            else if(choice==4){
                System.out.println("Thank you for using our program! :)");
                pass=true;

            }
            else{
                System.out.println("Wrong code. Try again");
            }
            
        }
        
    }
    
    //---------------------------------------------------//
    //----------------------- MULA 1.0 ----------------------------//
    
    public static void Registration() throws IOException, ParseException { //1.1
        
        boolean pass = false;
        
        while (pass != true) { // selagi tak masukkan code yang betul, sentiasa loop main menu
        
            System.out.println("Time - " + DisplayTime() + "\t" + "Date - " + DisplayDate());
            System.out.println("---------- REGISTRATION ----------");
            System.out.println("");

            //DAUS DAN MEKON - paparkan senarai item di sini, takde coding lagi

            System.out.println("[1] Seller");
            System.out.println("[2] Bidder");
            System.out.println("[3] Exit to main menu");

            Scanner a = new Scanner(System.in);

            System.out.print("Enter the number of your choice: ");
            int choice = a.nextInt();
            System.out.println("");
            System.out.println("");
            
            if (choice == 1) {
                SellerRegistration();
                pass = true;
            }

            else if (choice == 2){
                BidderRegistration();
                pass = true;

            }
            
            else if (choice == 3) {
                MainMenu();
                pass = true;

            }

            else {
                System.out.println("Wrong code. Try again");

            }
        
        }
        
    }
    
    //---------------------------------------------------//
    
     public static void SellerRegistration() throws IOException, ParseException { //1.1.1
        
        boolean pass = false;
        
        while (pass != true) {
            
            System.out.println("Time - " + DisplayTime() + "\t" + "Date - " + DisplayDate());
            System.out.println("---------- REGISTRATION - SELLER ----------");
            System.out.println("");
            
            Scanner a = new Scanner(System.in);
            
            System.out.print("Enter Seller's ID: ");
            String ID = a.nextLine();
            
            System.out.print("Enter Seller's Name: ");
            String name = a.nextLine();
            
            System.out.print("Enter Item's Name to sell: ");
            String item = a.nextLine();
            
            System.out.print("Enter Item's ID to sell: ");
            String itemID = a.nextLine();
            
            System.out.print("Enter bidding period (hour): ");
            int period = a.nextInt();
            
            System.out.println("");
            
            String [] timeSplit = DisplayTime().split(":");
            int [] num=new int [2];
            for(int i=0;i<2;i++){
                num[i]=Integer.valueOf(timeSplit[i]);
            }
            
            System.out.println("---------- DISPLAYING INFO - REGISTERED SELLER ----------");
            
            System.out.println("Seller's ID: " + ID);
            System.out.println("Seller's Name: " + name);
            System.out.println("Item's Name: " + item);
            System.out.println("Item's ID: " + itemID);
            System.out.println("Bidding period: " + period + " hour(s)");
            System.out.println("End time of bidding period: " + (num[0] + period) + ":" + num[1]);
            
            System.out.println("");
            System.out.println("");
            
            //DAUS DAN MEKON - coding untuk masukkan info ke dalam fail teks
            
            try {
            
                //DAUS DAN MEKON - coding untuk check kalau ID dah wujud ke tidak - keutamaan rendah
                
                PrintWriter Seller = new PrintWriter(new FileOutputStream("D:/Google Drive/UM/UM Sem 2/WIA1002 Data Structure/Lab/Lab Project & Codes/Project/Seller/" + ID + ".txt"));
                PrintWriter Item = new PrintWriter(new FileOutputStream("D:/Google Drive/UM/UM Sem 2/WIA1002 Data Structure/Lab/Lab Project & Codes/Project/Item/" + itemID + ".txt"));
                PrintWriter itemTrack = new PrintWriter (new FileOutputStream("D:/Google Drive/UM/UM Sem 2/WIA1002 Data Structure/Lab/Lab Project & Codes/Project/Item/" + itemID + "Track.txt"));
                PrintWriter ItemAll = new PrintWriter(new FileOutputStream("ItemAll.txt", true));
                //Scanner printItemAll = new Scanner(new FileInputStream("ItemAll.txt"));
                //PrintWriter writeItemAll = new PrintWriter(new FileOutputStream("ItemAll.txt"));
                
                
                //if (!printItemAll.hasNext()) {
                    
                    //writeItemAll.println(itemID +"\t" + item);
                    
                //}
                
                //else {
                
                Seller.println(ID);
                Seller.println(name);
                Seller.println(item);
                Seller.println(itemID);
                
                //dapatkan jam
                
                
                
                Item.println("NOTSOLD");
                Item.println(itemID);
                Item.println(item);
                Item.println((num[0] + period) + ":" + num[1]);
                Item.println(DisplayDate());
                    
                ItemAll.println(itemID + "\t" + item + "\t" + "NOTSOLD\t" + (num[0] + period) + ":" + num[1] + "\t" + DisplayDate());
                    
                //}
                
                
                Seller.close();
                Item.close();
                itemTrack.close();
                ItemAll.close();
                //printItemAll.close();
                //writeItemAll.close();
                
                
            }
            
            catch (IOException e) {
                
                System.out.println("Problem with file output"); 
                
            }
            
            
                
            Registration(); // auto exit semula ke menu Registration
           
        }
        
     }
     
     //---------------------------------------------------//
     
     public static void BidderRegistration() throws IOException, ParseException { //1.1.2
         
        boolean pass = false;
        
        while (pass != true) {
            
            System.out.println("Time - " + DisplayTime() + "\t" + "Date - " + DisplayDate());
            System.out.println("---------- REGISTRATION - BIDDER ----------");
            System.out.println("");
            
            
            Scanner a = new Scanner(System.in);
            
            System.out.print("Enter ID: ");
            String ID = a.nextLine();
            
            System.out.print("Enter Name: ");
            String name = a.nextLine();
            
            System.out.println("");
            
            System.out.println("---------- DISPLAYING INFO ----------");
            
            System.out.println("ID: " + ID);
            System.out.println("Name: " + name);

            
            System.out.println("");
            System.out.println("");
            
            
            //DAUS DAN MEKON - coding untuk masukkan info ke dalam fail teks
            
            
            try {
                
                PrintWriter file = new PrintWriter(new FileOutputStream("D:/Google Drive/UM/UM Sem 2/WIA1002 Data Structure/Lab/Lab Project & Codes/Project/Bidder/" + ID + ".txt"));
                
                file.println(ID);
                file.println(name);
                
                
                file.close();
                
            }
            
            catch(IOException e) {
                System.out.println("Problem with file output");
            }
            
            Registration(); // auto exit semula ke menu Registration
            
        
            
        }
         
     }
    
    //---------------------------------------------------//
    //----------------------- TAMAT 1.1 ----------------------------//
    //---------------------------------------------------//
    //---------------------------------------------------//
    //----------------------- MULA 2.0 ----------------------------//
    
    
    public static void Login() throws IOException, ParseException { //2.1
        
        boolean pass = false;
        
        while (pass != true) { // selagi tak masukkan code yang betul, sentiasa loop main menu
        
            System.out.println("Time - " + DisplayTime() + "\t" + "Date - " + DisplayDate());
            System.out.println("---------- LOGIN ----------");
            System.out.println("");
            
            System.out.println("[1] Seller - Edit");
            System.out.println("[2] Seller - Remove");
            //---------------------------------------------------//
            System.out.println("[3] Bidder - Edit");
            System.out.println("[4] Bidder - Remove");
            System.out.println("[5] Exit to Main Menu");

            Scanner a = new Scanner(System.in);

            System.out.print("Enter the number of your choice: ");
            int choice = a.nextInt();
            System.out.println("");
            System.out.println("");
            
            if (choice == 1) {
                SellerLoginEdit();
                pass = true;
            }

            else if (choice == 2){
                SellerLoginRemove();
                pass = true;

            }
            
            else if (choice == 3){
                BidderLoginEdit();
                pass = true;

            }
            
            else if (choice == 4){
                BidderLoginRemove();
                pass = true;

            }
            
            else if (choice == 5){
                MainMenu();
                pass = true;

            }

            else{
                System.out.println("Wrong code. Try again");

            }
        
        }
    }
    
    //-----------------------------------------//
    
    public static void SellerLoginEdit() throws IOException, ParseException { //2.1.1
        
        boolean pass = false;
        
        //while (pass != true) { // selagi tak masukkan code yang betul, sentiasa loop main menu
        
            System.out.println("Time - " + DisplayTime() + "\t" + "Date - " + DisplayDate());
            System.out.println("---------- LOGIN - SELLER - EDIT ----------");
            System.out.println("");
            
            Scanner a = new Scanner(System.in);

            System.out.print("Enter your ID: ");
            String ID = a.nextLine();
            
            //DAUS DAN MEKON - coding untuk compare ID yang dimasukkan dengan fail teks - so kena wujudkan satu teks fail untuk simpan ID seller
            
            //kalau ID wujud dalam fail teks, paparkan maklumat
            
            //DAUS DAN MEKON - coding untuk paparkan maklumat dari fail teks
            
            
            String IDscan = null;
            String namescan = null;
            String itemIDscan = null;
            String itemscan = null;
            
            try { //baca info dari file Seller
                
                Scanner scan = new Scanner (new FileInputStream("D:/Google Drive/UM/UM Sem 2/WIA1002 Data Structure/Lab/Lab Project & Codes/Project/Seller/" + ID + ".txt"));
                
                while (scan.hasNextLine()) {
                    
                    IDscan = scan.nextLine();
                    namescan = scan.nextLine();
                    itemscan= scan.nextLine();
                    itemIDscan = scan.nextLine();
                    
                }

                scan.close();
            }
            
//            catch (FileNotFoundException e) {
//                
//                System.out.println("The file does not exist");
//                
//            }
            
            catch (FileNotFoundException f) {
                System.out.println("Seller's ID doesn't exist. Try again");
                System.out.println("");
                System.out.println("");
                Login();
            }
            
            System.out.println("");
            System.out.println("");
            System.out.println("---------- DISPLAYING INFO ----------");
            
            System.out.println("ID: " + IDscan);
            System.out.println("Name: " + namescan);
            System.out.println("Item: " + itemscan);
            System.out.println("Item's ID: " + itemIDscan);
            
            System.out.println("");
            System.out.println("");
            
            System.out.print("Enter New ID: ");
            ID = a.nextLine();
            
            System.out.print("Enter New Name: ");
            String name = a.nextLine();
            
            System.out.print("Enter New Item to sell: ");
            String item = a.nextLine();
            
            System.out.print("Enter New Item's ID to sell: ");
            String itemID = a.nextLine();
            
            //DAUS & MEKON - coding untuk edit maklumat masuk dalam fail teks
            
            try { //write ke dalam file Seller dan Item
            
                //DAUS DAN MEKON - coding untuk check kalau ID dah wujud ke tidak - keutamaan rendah
                
                
                //delete file Seller lama
                File f = new File("D:/Google Drive/UM/UM Sem 2/WIA1002 Data Structure/Lab/Lab Project & Codes/Project/Seller/" + IDscan + ".txt");
                f.delete();
                
                
                //delete file Item lama
                File f1 = new File("D:/Google Drive/UM/UM Sem 2/WIA1002 Data Structure/Lab/Lab Project & Codes/Project/Item/" + itemIDscan + ".txt");
                f1.delete();
                
                //cipta semula fail Seller baru
                PrintWriter file = new PrintWriter(new FileOutputStream("D:/Google Drive/UM/UM Sem 2/WIA1002 Data Structure/Lab/Lab Project & Codes/Project/Seller/" + ID + ".txt"));
                
                //cipta semula fail Item baru
                PrintWriter fileItem = new PrintWriter(new FileOutputStream("D:/Google Drive/UM/UM Sem 2/WIA1002 Data Structure/Lab/Lab Project & Codes/Project/Item/" + itemID + ".txt"));
                
                
                file.println(ID);
                file.println(name);
                file.println(item);
                file.println(itemID);
                
                fileItem.println(itemID);
                fileItem.println(item);
                
                file.close();
                fileItem.close();
                
            }
            
            catch (IOException e) {
                
                System.out.println("Problem with file output"); 
                
            }
            
            System.out.println("");
            
            System.out.println("---------- DISPLAYING NEW INFO ----------");
            
            System.out.println("ID: " + ID);
            System.out.println("Name: " + name);
            System.out.println("Item: " + item);
            System.out.println("Item's ID: " + itemID);
            
            System.out.println("");
            System.out.println("");
             
              
        //}
        
        Login(); //auto exit ke previous menu
        
    }
    
    //---------------------------------------------------//
    
    public static void SellerLoginRemove() throws IOException, ParseException { //2.1.2
        
        boolean pass = false;
        
        while (pass != true) { // selagi tak masukkan code yang betul, sentiasa loop main menu
        
            System.out.println("Time - " + DisplayTime() + "\t" + "Date - " + DisplayDate());
            System.out.println("---------- LOGIN - SELLER - REMOVE ----------");
            System.out.println("");
            
            Scanner a = new Scanner(System.in);
            
            System.out.print("Enter your ID: ");
            String ID = a.next();
            System.out.println("");
            //DAUS DAN MEKON - coding untuk compare ID yang dimasukkan dengan fail teks
            
            //kalau ID wujud dalam fail teks, paparkan maklumat
            
            //DAUS DAN MEKON - coding untuk paparkan maklumat dari fail teks
            
            String IDscan = null;
            String namescan = null;
            String itemIDscan = null;
            String itemscan = null;
            
            try {
                
                Scanner scan = new Scanner (new FileInputStream("D:/Google Drive/UM/UM Sem 2/WIA1002 Data Structure/Lab/Lab Project & Codes/Project/Seller/" + ID + ".txt"));
                
                while (scan.hasNextLine()) {
                    
                    IDscan = scan.nextLine();
                    namescan = scan.nextLine();
                    itemscan = scan.nextLine();
                    itemIDscan = scan.nextLine();
                    
                }

                scan.close();
            }
            
//            catch (FileNotFoundException e) {
//                
//                System.out.println("The file does not exist");
//                
//            }
            
            catch (FileNotFoundException f) {
                System.out.println("Seller's ID doesn't exist. Try again");
                System.out.println("");
                System.out.println("");
                Login();
            }
            
            System.out.println("ID: " + IDscan);
            System.out.println("Name: " + namescan);
            System.out.println("Item: " + itemscan);
            System.out.println("Item's ID: " + itemIDscan);
            
            System.out.println("");
            System.out.println("[1] Confirm with deleting?");
            System.out.println("[2] Exit to previous menu");
            
            System.out.print("Enter the number of your choice: ");
            int choice = a.nextInt();
            System.out.println("");
            System.out.println("");
            
            if(choice == 1){

                File f = new File("D:/Google Drive/UM/UM Sem 2/WIA1002 Data Structure/Lab/Lab Project & Codes/Project/Seller/" + IDscan + ".txt");
                f.delete();
                
                File f1 = new File("D:/Google Drive/UM/UM Sem 2/WIA1002 Data Structure/Lab/Lab Project & Codes/Project/Item/" + itemIDscan + ".txt");
                f1.delete();
                
                System.out.println("The profile has been deleted");
                pass = true;
                
                //Login();
            }
            
            else if (choice == 2){
                //Login(); patah semula ke menu Login
                pass = true;
            }
            
            else {
                System.out.println("Wrong code. Try again");
            }
        }
        
        Login();
        
    }
    
    //---------------------------------------------------//
    
    public static void BidderLoginEdit() throws IOException, ParseException { //2.1.3
        
        boolean pass = false;
        
        //while (pass != true) { // selagi tak masukkan code yang betul, sentiasa loop main menu
        
            System.out.println("Time - " + DisplayTime() + "\t" + "Date - " + DisplayDate());
            System.out.println("---------- LOGIN - BIDDER - EDIT ----------");
            System.out.println("");
            
            Scanner a = new Scanner(System.in);

            System.out.print("Enter your ID: ");
            String ID = a.nextLine();
            
            //DAUS DAN MEKON - coding untuk compare ID yang dimasukkan dengan fail teks
            
            //kalau ID wujud dalam fail teks, paparkan maklumat
            
            //DAUS DAN MEKON - coding untuk paparkan maklumat dari fail teks
            
            String IDscan = null;
            String namescan = null;
            
            try { //baca info dari file Bidder
                
                Scanner scan = new Scanner (new FileInputStream("D:/Google Drive/UM/UM Sem 2/WIA1002 Data Structure/Lab/Lab Project & Codes/Project/Bidder/" + ID + ".txt"));
                
                while (scan.hasNextLine()) {
                    
                    IDscan = scan.nextLine();
                    namescan = scan.nextLine();
                    
                }

                scan.close();
            }
            
//            catch (FileNotFoundException e) {
//                
//                System.out.println("The file does not exist");
//                
//            }
            
            catch (FileNotFoundException f) {
                System.out.println("Bidder's ID doesn't exist. Try again");
                System.out.println("");
                System.out.println("");
                Login();
            }
            
            
            System.out.println("ID: " + IDscan);
            System.out.println("Name: " + namescan);

            
            System.out.println("");
            System.out.println("");
            
            System.out.print("Enter New ID: ");
            ID = a.nextLine();
            
            System.out.print("Enter New Name: ");
            String name = a.nextLine();
            
            //DAUS & MEKON - coding untuk edit maklumat masuk dalam fail teks
            
            try { //write ke dalam file Seller dan Item
            
                //DAUS DAN MEKON - coding untuk check kalau ID dah wujud ke tidak - keutamaan rendah
                
                
                //delete file Bidder lama
                File f = new File("D:/Google Drive/UM/UM Sem 2/WIA1002 Data Structure/Lab/Lab Project & Codes/Project/Seller/" + IDscan + ".txt");
                f.delete();
                
                
                //cipta semula fail Bidder baru
                PrintWriter file = new PrintWriter(new FileOutputStream("D:/Google Drive/UM/UM Sem 2/WIA1002 Data Structure/Lab/Lab Project & Codes/Project/Bidder/" + ID + ".txt"));  
                
                
                file.println(ID);
                file.println(name);
                
                file.close();
                
            }
            
            catch (IOException e) {
                
                System.out.println("Problem with file output"); 
                
            }
            
            System.out.println("");
            
            System.out.println("---------- DISPLAYING NEW INFO ----------");
            
            System.out.println("ID: " + ID);
            System.out.println("Name: " + name);
            
            
            System.out.println("");
            System.out.println("");
            
            //Login(); 
            Login();//auto exit ke log in menu
              
        //}
        
        
        
    }
    
    //---------------------------------------------------//
    
    public static void BidderLoginRemove() throws IOException, ParseException { //2.1.4
        
        boolean pass = false;
        
        while (pass != true) { // selagi tak masukkan code yang betul, sentiasa loop main menu
        
            System.out.println("Time - " + DisplayTime() + "\t" + "Date - " + DisplayDate());
            System.out.println("---------- LOGIN - BIDDER - REMOVE ----------");
            System.out.println("");
            
            Scanner a = new Scanner(System.in);
            
            System.out.print("Enter your ID: ");
            String ID = a.next();
            System.out.println("");
            //DAUS DAN MEKON - coding untuk compare ID yang dimasukkan dengan fail teks
            
            //kalau ID wujud dalam fail teks, paparkan maklumat
            
            //DAUS DAN MEKON - coding untuk paparkan maklumat dari fail teks
            
            String IDscan = null;
            String namescan = null;
            
            try { //baca info dari file Bidder
                
                Scanner scan = new Scanner (new FileInputStream("D:/Google Drive/UM/UM Sem 2/WIA1002 Data Structure/Lab/Lab Project & Codes/Project/Bidder/" + ID + ".txt"));
                
                while (scan.hasNextLine()) {
                    
                    IDscan = scan.nextLine();
                    namescan = scan.nextLine();
                    
                }

                scan.close();
            }
            
//            catch (FileNotFoundException e) {
//                
//                System.out.println("The file does not exist");
//                
//            }
            
            catch (FileNotFoundException f) {
                System.out.println("Bidder's ID doesn't exist. Try again");
                System.out.println("");
                System.out.println("");
                Login();
            }
            
            System.out.println("ID: " + IDscan);
            System.out.println("Name: " + namescan);

            System.out.println("");
            System.out.println("[1] Confirm with deleting?");
            System.out.println("[2] Exit to previous menu");
            
            System.out.print("Enter the number of your choice: ");
            int choice = a.nextInt();
            System.out.println("");
            System.out.println("");
            
            if(choice == 1){
                //delete file
                
                File f = new File("D:/Google Drive/UM/UM Sem 2/WIA1002 Data Structure/Lab/Lab Project & Codes/Project/Bidder/" + IDscan + ".txt");
                f.delete();
                
                
                System.out.println("The profile has been deleted");
                
                pass = true;
            }
            
            else if (choice == 2){
                //Login(); //patah semula ke menu Login
                pass = true;
            }
            
            else {
                System.out.println("Wrong code. Try again");
            }
            
        }
        
        Login();
    }
    
    
    //---------------------------------------------------//
    //----------------------- TAMAT 2.1 ----------------------------//
    //---------------------------------------------------//
    //---------------------------------------------------//
    //----------------------- MULA 3.0 ----------------------------//
    
    public static void Auction() throws IOException, ParseException { //3.1
    
        boolean pass = false;
        
        while (pass != true) { // selagi tak masukkan code yang betul, sentiasa loop main menu
        
            System.out.println("Time - " + DisplayTime() + "\t" + "Date - " + DisplayDate());
            System.out.println("---------- AUCTION HALL ----------");
            System.out.println("---------- BLIND AUCTION ----------");
            System.out.println("No) Item's ID\tItem'sName\tEnd Time\tEnd Date\tTime Remaining");
            
            try {
                
                Scanner itemAll = new Scanner(new FileInputStream("D:/Google Drive/UM/UM Sem 2/WIA1002 Data Structure/Lab/Lab Project & Codes/Project/ItemAll.txt"));
                
                int i=1;
                while (itemAll.hasNextLine()) {
                    
                    String input = itemAll.nextLine();
                    String [] line = input.split("\t");
                    
                    String itemID =     line[0];
                    String itemName =   line[1];
                    String status =     line[2];
                    

                    if(status.equals("NOTSOLD")) {
                        
                        String EndHour =    line[3];
                        String EndDate =    line[4];
                        String[] timeEnd = line[3].split(":");
                        System.out.println(i + ")\t" + itemID + "\t" + itemName + "\t\t" + EndHour + "\t\t" + EndDate + "\t" +  timeremaining(line[3]));
                    }
                    
                    else {
                        
                        System.out.println(i + ")\t" + itemID + "\t" + itemName + "\t" + status);
                    }
                    
                    i++;
                }
                
            }
            
            catch (IOException e) {
                System.out.println("No item has been registered yet. Please register a seller and an item");
            }

            Scanner a = new Scanner(System.in);
            
            System.out.println("");
            System.out.println("[1] Continue with choosing which item to bid");
            System.out.println("[2] Exit to Main Menu");
            
            System.out.print("Enter the number of your choice: ");
            int choice = a.nextInt();
            System.out.println("");
            System.out.println("");
            
            if (choice == 1){
                BidChooseItemAuction();
                pass = true;
                
            }
            
            else if (choice == 2){
                MainMenu();
                pass = true;
                
            }
            
            else {
                System.out.println("Wrong code. Try again");
                
            }
            
            
        }
        
    }
    
    //---------------------------------------------------//
    
    public static void BidChooseItemAuction() throws IOException, ParseException { //3.1.1
    
        //boolean pass = false;
        
        //while (pass != true) { // selagi tak masukkan code yang betul, sentiasa loop main menu
        
            System.out.println("Time - " + DisplayTime() + "\t" + "Date - " + DisplayDate());
            System.out.println("---------- AUCTION HALL ----------");
            System.out.println("---------- BLIND AUCTION - CHOOSING ITEMS ----------");
            System.out.println("---------- CHOOSE ITEM TO BID ----------");
            System.out.println("No) Item's ID\tItem'sName\tEnd Time\tEnd Date\tTime Remaining");
            
            //DAUS DAN MEKON - coding papar senarai item
            
            try {
                
                Scanner itemAll = new Scanner(new FileInputStream("D:/Google Drive/UM/UM Sem 2/WIA1002 Data Structure/Lab/Lab Project & Codes/Project/ItemAll.txt"));
                
                int i=1;
                while (itemAll.hasNextLine()) {
                    
                    String input = itemAll.nextLine();
                    String [] line = input.split("\t");
                    
                    String itemID =     line[0];
                    String itemName =   line[1];
                    String status =     line[2];
                    

                    if(status.equals("NOTSOLD")) {
                        String EndHour =    line[3];
                        String EndDate =    line[4];
                        String[] timeEnd = line[3].split(":");
                        System.out.println(i + ")\t" + itemID + "\t" + itemName + "\t\t" + EndHour + "\t\t" + EndDate + "\t" +  timeremaining(line[3]));
                    }
                    
                    else {
                        
                        System.out.println(i + ")\t" + itemID + "\t" + itemName + "\t" + status);
                    }
                    
                    i++;
                }
                
            }
            
            catch(IOException e) {
                
                System.out.println("Problem with file output");
                
            }
            
            System.out.println("");
            Scanner a = new Scanner(System.in);
            
            System.out.print("Enter item's ID to bid: ");
            String ID = a.next();
            System.out.println("");
            //paparkan maklumat ID
            
            try {
                Scanner readItemID = new Scanner(new FileInputStream("D:/Google Drive/UM/UM Sem 2/WIA1002 Data Structure/Lab/Lab Project & Codes/Project/Item/" + ID + ".txt"));
                
            }
            
//            catch (IOException e) {
//                
//                System.out.println("Error:" + e);
//                Auction();
//            }
            
            catch (FileNotFoundException f) {
                System.out.println("Item's ID doesn't exist. Try again");
                System.out.println("");
                System.out.println("");
                BidChooseItemAuction();
            }
            
            catch(NullPointerException f) {
                System.out.println("Item's ID doesn't exist. Try again");
                System.out.println("");
                System.out.println("");
                BidChooseItemAuction();
            }

            
            String IDscan = null;
            String namescan = null;
            
//            try { //baca info dari file Bidder
//                
//                Scanner scan = new Scanner (new FileInputStream("D:/Google Drive/UM/UM Sem 2/WIA1002 Data Structure/Lab/Lab Project & Codes/Project/Item/" + ID + ".txt"));
//                
//                while (scan.hasNextLine()) {
//                    
//                    IDscan = scan.nextLine();
//                    namescan = scan.nextLine();
//                    
//                }
//
//                scan.close();
//            }
//             
//            catch (FileNotFoundException e) {
//                
//                System.out.println("The file does not exist");
//                
//            }
            
//            System.out.println("Item's ID: " + IDscan);
//            System.out.println("Item's Name: " + namescan);
//            
//            System.out.println("");
            
            BidItemAuction(ID);
            
            
        //}
        
    }
    
    //---------------------------------------------------//
    
    public static void BidItemAuction(String ID) throws IOException, ParseException { //3.1.1.1
    
        //boolean pass = false;
        
        //while (pass != true) { // selagi tak masukkan code yang betul, sentiasa loop main menu
        
            System.out.println("Time - " + DisplayTime() + "\t" + "Date - " + DisplayDate());
            System.out.println("---------- AUCTION HALL ----------");
            System.out.println("---------- BLIND AUCTION ----------");
            System.out.println("---------- BIDDING PERIOD ----------");
            
            //DAUS DAN MEKON - coding papar senarai item u
            
            Scanner a = new Scanner(System.in);
            Console console = System.console();
            
            int code = 0;
            
            Stack<Double> bidStack = new Stack<Double>();
            Stack<String> bidStackID = new Stack<String>();
            
            String status = null;
            String itemID = null;
            String itemName = null;
            String EndHour = null;
            String EndDate = null;
            
            while (code != -1) {
                
                try {
                
                    Scanner item = new Scanner(new FileInputStream("D:/Google Drive/UM/UM Sem 2/WIA1002 Data Structure/Lab/Lab Project & Codes/Project/Item/" + ID + ".txt"));
                    //Scanner itemAll = new Scanner(new FileInputStream("D:/Google Drive/UM/UM Sem 2/WIA1002 Data Structure/Lab/Lab Project & Codes/Project/ItemAll.txt"));

                    while(item.hasNextLine()) {

                        status = item.nextLine();
                        itemID = item.nextLine();
                        itemName = item.nextLine();
                        EndHour = item.nextLine();
                        EndDate = item.nextLine();

                    }
                    
                    if (!status.equals("NOTSOLD")) {
                        
                        System.out.println("HAS BEEN SOLD - CHOOSE ANOTHER ITEM");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("-------------------------------------------");
                        Auction();
                        
                    }
                    
                    else {
                        
                        System.out.print("Enter bidder's ID: ");
                        String bidderID = a.next();

                        System.out.print("Enter Your Bid (RM): ");
                        //double bid = Double.parseDouble(new String(console.readPassword("Please enter your password: ")));
                        double bid = a.nextDouble(); //tak dapat hide jumlah, tak jumpa lagi, bila guna yang atas, kena guna command prompt utk compile, ada error bila compile

                        bidStack.push(bid);
                        bidStackID.push(bidderID);
                        
                        try {
                            
                            PrintWriter itemTrack = new PrintWriter(new FileOutputStream("D:/Google Drive/UM/UM Sem 2/WIA1002 Data Structure/Lab/Lab Project & Codes/Project/Item/" + ID + "Track.txt", true));
                            
                            itemTrack.println(bid);
                            
                            itemTrack.close();
                        }
                        
                        
                        catch (IOException e) {
                            System.out.println("File is not found");
                        }
                        
                        System.out.println("Your bid has been submitted");
                    }

                    
                    
                    // timestamp = //coding untuk dapatkan masa daripada computer

                    System.out.println("");
                    System.out.println("Continue with next user?");
                    System.out.print("If YES, enter any number. Else, enter - 1: ");
                    code = a.nextInt();
                    
                    item.close();
            
                }
                
                catch (IOException e) {
                    System.out.println("File is not found");
                }
                
//                catch (FileNotFoundException f) {
//                System.out.println("Item's ID doesn't exist. Try again");
//                System.out.println("");
//                System.out.println("");
//                BidChooseItemAuction();
//                }
                
                System.out.println("");
            }
            
            System.out.println("Result will be announced soon.");
            
            System.out.println("");
            
            //DAUS DAN MEKON - coding untuk compare harga bidaan
            
            try {
                
                Scanner stack = new Scanner(new FileInputStream("D:/Google Drive/UM/UM Sem 2/WIA1002 Data Structure/Lab/Lab Project & Codes/Project/Item/" + ID + "Track.txt"));
                
                while(stack.hasNextLine()) {
                    bidStack.push(Double.parseDouble(stack.nextLine()));
                }
                
                stack.close();
            }
            
            
            catch (IOException e) {
                    System.out.println("File is not found");
            }
            
            int hold = bidStack.max();
            String winner = bidStackID.getX(hold);
            String nameWinner = null;
            
            //dapatkan nama pemenang berdasarkan ID daripada Bidder
            try {
            
                Scanner read = new Scanner(new FileInputStream("D:/Google Drive/UM/UM Sem 2/WIA1002 Data Structure/Lab/Lab Project & Codes/Project/Bidder/" + winner + ".txt"));
                
                while(read.hasNextLine()) {
                    
                    String IDscan = read.nextLine();
                    nameWinner = read.nextLine();  
                }
                
                read.close();
            }
            
            catch (IOException e) {  
                System.out.println("Problem with file output"); 
            }
            
            System.out.println("");
            System.out.println("The winner for this item is " + nameWinner + " with amount of RM " + bidStack.getX(hold));
            
            System.out.println("");
            
            //update teks file item personal, update status kepada nama pemenang
            
            try {
                
                Scanner bidder = new Scanner(new FileInputStream("D:/Google Drive/UM/UM Sem 2/WIA1002 Data Structure/Lab/Lab Project & Codes/Project/Bidder/" + bidStackID.getX(hold) + ".txt"));
                Scanner itemIDRead = new Scanner (new FileInputStream("D:/Google Drive/UM/UM Sem 2/WIA1002 Data Structure/Lab/Lab Project & Codes/Project/Item/" + ID + ".txt"));
                PrintWriter itemIDWrite = new PrintWriter(new FileOutputStream("D:/Google Drive/UM/UM Sem 2/WIA1002 Data Structure/Lab/Lab Project & Codes/Project/Item/" + ID + ".txt"));
                Scanner itemAllRead = new Scanner(new FileInputStream("ItemAll.txt"));
                
                
                String bidderID = null;
                String bidderName = null;
                
                while(bidder.hasNextLine()) {
                    
                    bidderID = bidder.nextLine();
                    bidderName = bidder.nextLine();
                }
                
                String statusScan = null;
                String itemIDScan = null;
                String itemNameScan = null;
                String EndHourScan = null;
                String EndDateScan = null;

                
                while(itemIDRead.hasNextLine()) {
                    
                    statusScan = itemIDRead.nextLine();
                    itemIDScan = itemIDRead.nextLine();
                    itemNameScan = itemIDRead.nextLine();
                    EndHourScan = itemIDRead.nextLine();
                    EndDateScan = itemIDRead.nextLine();

                }
                
                itemIDRead.close();
                
                itemIDWrite.println(bidderName);
                itemIDWrite.println(itemIDScan);
                itemIDWrite.println(itemNameScan);
                itemIDWrite.println(EndHourScan);
                itemIDWrite.println(EndDateScan);
                
                //bagaimana nak update file ItemAll.txt
                
                Queue<String> record = new Queue<String>();
                
                loop:
                while(itemAllRead.hasNextLine()) {
                    
                    record.enqueue(itemAllRead.nextLine());
                    //String input1 = input;
                    //String [] line = input.split("\t");
                    
//                    if(line[0].equals("i2")) {
//                        System.out.println("haha");
//                    }
//                    
//                    else {
//                        
//                        record.enqueue(input1);
//                        System.out.println("Added");
//                    }
                    
                    
                    
                    //System.out.println("Ulang sekali");
                }
                
                
            itemAllRead.close();
            
            PrintWriter itemAllWrite = new PrintWriter(new FileOutputStream("ItemAll.txt"));
            
            int size = record.getSize();
            
            for (int i=1; i<=size; i++) {
                    
                    String input2 = record.dequeue();
                    String input3 = input2;
                    String [] line = input2.split("\t");
                    //System.out.println("Loop: " + i);
                    
                    if(line[0].equals(ID)) {
                        itemAllWrite.println(ID + "\t" + itemName + "\tSold to " + bidderName);
                    }
                    
                    else {
                
                        itemAllWrite.println(input3);
                        //System.out.println("Dequeued");
                    
                    }
                    
                }
                
            itemAllWrite.close();
            itemIDWrite.close();
            }
            
            catch (IOException e) {
                System.out.println(e);
            }
            
            System.out.println("");
            System.out.println("");
        //}
        
        Auction(); //auto exit ke menu sebelumnya
        
    }
    
    //----------------------------------------//
    
    public static String DisplayTime() {
        
        String time=new SimpleDateFormat("HH:mm").format(new Date());
        return time;
        
    }
    
    //----------------------------------------//
    
    public static String DisplayDate() {
        
        String date = new SimpleDateFormat("dd/MM/YY").format(new Date());
        return date;
    }
    
    public static String timeremaining(String x) throws ParseException{
        Scanner a =new Scanner(System.in);
        java.util.Date masa = new java.util.Date();

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String huhu=x;
        Date end1 = sdf.parse(huhu);    
        long end2 = end1.getTime();

        String aString = sdf.format(masa); 
        Date now = sdf.parse(aString);
        long now1 = now.getTime();
    
   
         long masatinggal = end2 - now1;
        long masasec = masatinggal /1000;
        double masamin=masasec/60;
        long masamin1=masasec/60;
        double masajam=masamin/60;
        long masajam1 = masamin1/60;
        double min=masajam%1;
        long min1 = (int) (min*60);
        return masajam1+" hour(s) "+min1+" minute(s) left";
    }
}

package com.almazan.Section8.InbuiltList.GroceryShopping;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {

        boolean quit = false;
        int choice = 0;
        printInstructions();

        while(!quit) {
            System.out.print("Enter your choice: " );
            choice = scanner.nextInt();
            scanner.nextLine();

            clearConsole();
            switch(choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    processArrayList();
                    break;
                case 7:
                    quit = true;
            }
        }
    }

    /**
     * Display List of Actions
     */
    public static void printInstructions() {
        System.out.println("\nPress and Enter ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of grocery items.");
        System.out.println("\t 2 - To add an item to the list.");
        System.out.println("\t 3 - To modify an item in the list.");
        System.out.println("\t 4 - To remove an item from the list.");
        System.out.println("\t 5 - To search for an item in the list.");
        System.out.println("\t 6 - To quit the application.");
    }

    /**
     * Adds new item to the grocery list
     */
    public static void addItem() {
        System.out.print("Please enter the grocery item: ");
        groceryList.addGroceryItem(scanner.nextLine());
    }

    /**
     * Modify an item in the grocery list (Case sensitive!!!)
     */
    public static void modifyItem() {
        System.out.print("Current item name: ");
        String itemNo = scanner.nextLine();
        System.out.print("Enter new item: ");
        String newItem = scanner.nextLine();
        groceryList.modifyGroceryItem(itemNo, newItem);
    }

    /**
     * Removes and item int the grocery list (Case sensitive!!!)
     */
    public static void removeItem() {
        System.out.print("Enter item name: ");
        String itemNo = scanner.nextLine();
        groceryList.removeGroceryItem(itemNo);
    }

    /**
     * Search for item if found in grocery list
     */
    public static void searchForItem() {
        System.out.print("Item to search for: ");
        String searchItem = scanner.nextLine();
        if(groceryList.onFile(searchItem))
            System.out.println("Found " + searchItem + " in  our grocery list");
        else
            System.out.println(searchItem + ", not on shopping list file.");
    }

    public static void processArrayList() {
        ArrayList<String> newArray = new ArrayList<String>();
        newArray.addAll(groceryList.getGroceryList()); //Method of arraylist for appending list at the end of current list

        //Initialized at start
        ArrayList<String> nextArray = new ArrayList<String>(groceryList.getGroceryList());

        //ArrayList to Array
        String[] myArray = new String[groceryList.getGroceryList().size()]; //Initializing size base on arraylist being pass
        myArray = groceryList.getGroceryList().toArray(myArray); //toArray Method returns arraylist to array
    }

    /**
     * Dumps 70 new lines on console
     */
    public static void clearConsole(){
        for (int i = 0; i < 50; i++)
            System.out.println();
    }
}

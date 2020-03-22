/*
 * File: Main.java
 * Author: Anthony Smith
 * Date: 2/12/2020
 * Purpose: This class is the driver program for the assets program
 * */
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        //create two arraylists, one to hold all asset options and the other to hold the invested assets
        //readfile method reads file and saves info to the arraylist
        ArrayList<Asset> masterList = readFile("assetData.csv");
        ArrayList<Asset> portfolio = new ArrayList<>();
        //creat variable for the choice and amount invested
        int choice = 0;
        int amountInvested;
        //while loop runs until a negative number is entered
        while(choice >= 0) {
            choice = 0;
            assert masterList != null;
            //for loop lists all investment options
            for (int i = 0; i < masterList.size(); i++) {
                System.out.println(i + 1 + ".) " + masterList.get(i).getName() + " (" + masterList.get(i).getID() + ")");
            }
            //prompt user for choice, check for exceptions
            System.out.println("Enter the number of the asset you would like to invest in: ");
            try {
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            if(choice < 0){
                break;
            }
            System.out.println("Enter amount to invest in " + masterList.get(choice-1).getName());
            Scanner sc2 = new Scanner(System.in);
            amountInvested = sc2.nextInt();
            //set amount invested and output the result to user
            Asset currentAsset = masterList.get(choice-1);
            int profit = currentAsset.valueInTenYears(amountInvested);
            System.out.println("Investment value after 10 years is: $" + profit);
            System.out.println("Press enter to continue: ");
            //add invested asset to arraylist
            currentAsset.setAmountInvested(amountInvested);
            currentAsset.setProfit(profit);
            portfolio.add(currentAsset);
            Scanner sc3 = new Scanner(System.in);
            String continueOrExit = sc3.nextLine();

            //catch blocks for inputmismatch and index out of bounds
            }catch (InputMismatchException e){
                System.out.println("Invalid, Enter a number between 1 an 17 or enter -1 to exit");
                continue;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid, Enter a number between 1 an 17 or enter -1 to exit");
            }
        }
        printTable(portfolio);

    }
    public static void printTable(ArrayList<Asset> portfolio){
        System.out.println("+--------------+-----------------+--------------------+");
        System.out.println("| ASSET SYMBOL | AMOUNT INVESTED | VALUE IN TEN YEARS |");
        System.out.println("+==============+=================+====================+");
        int totalInvest = 0;
        int totalProfit = 0;
        String total = "TOTAL";
        for (Asset asset : portfolio) {
            System.out.printf("| %-13.13s| %-16d| %-19d|\n",asset.getID(),asset.getAmountInvested(),asset.getProfit());
            totalInvest += asset.getAmountInvested();
            totalProfit += asset.getProfit();
        }
        System.out.println("+--------------+-----------------+--------------------+");
        System.out.printf("| %-13.13s| %-16d| %-19d|\n",total,totalInvest,totalProfit);
        System.out.println("+--------------+-----------------+--------------------+");
    }

    //this method reads the file and saves the elements in an arraylist
    public static ArrayList<Asset> readFile(String fileName){
        try{
            BufferedReader fileRead = null;
            fileRead = new BufferedReader(new FileReader(fileName));
            ArrayList<Asset> assetList = new ArrayList<>();
            String line = "";
            String[][] assetDetails2d = new String[18][5];
            int i = 0;
            //read file line by line and separate on comma
            while ((line = fileRead.readLine()) != null) {
                assetDetails2d[i] = line.split(",");
                for(int j = 0; j < assetDetails2d[i].length; j++){
                    if (assetDetails2d[i][j].length() == 0){
                        assetDetails2d[i][j] = "0";
                    }
                }
                //assign elements to an asset object, depending on the number of elements asset will be a stock or Stable Asset
                if(assetDetails2d[i].length > 3){
                    Asset a = new Stocks(assetDetails2d[i][1], assetDetails2d[i][0], Double.parseDouble(assetDetails2d[i][2]),
                            Double.parseDouble(assetDetails2d[i][3]), Double.parseDouble(assetDetails2d[i][4]));
                    assetList.add(a);
                }
                else if (assetDetails2d[i].length <= 3 && isNumber(assetDetails2d[i][2])){
                    Asset a = new StableAssets(assetDetails2d[i][1],assetDetails2d[i][0],Double.parseDouble(assetDetails2d[i][2]));
                    assetList.add(a);
                }else {
                    System.out.println("Bad input data: " + Arrays.toString(assetDetails2d[i]));
                }
                i++;
            }
            return assetList;
        }
        //catch IO and file not found exception
        catch(FileNotFoundException e){
            System.out.println("File not found.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    //method to check if a string is numeric
    public static boolean isNumber(String number){
        try {
            double numDouble = Double.parseDouble(number);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }

}

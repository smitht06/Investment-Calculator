import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        ArrayList<Asset> masterList = readFile("assetData.csv");
        ArrayList<Asset> portfolio = new ArrayList<>();
        int choice = 0;
        int amountInvested;
        while(choice >= 0) {
            choice = 0;
            assert masterList != null;
            for (int i = 0; i < masterList.size(); i++) {
                System.out.println(i + 1 + ".) " + masterList.get(i).getName() + " (" + masterList.get(i).getID() + ")");
            }
            System.out.println("Enter the number of the asset you would like to invest in: ");
            try {
                Scanner sc = new Scanner(System.in);
                choice = sc.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Invalid, Enter a number between 1 an 17 or enter -1 to exit");
            }
            if(choice > 17){
                System.out.println("Invalid choice, please enter a number from the list or enter negative number to exit.");
            }else if (choice < 0){
                break;
            }
            System.out.println("Enter amount to invest in " + masterList.get(choice-1).getName());
            Scanner sc2 = new Scanner(System.in);
            amountInvested = sc2.nextInt();
            Asset currentAsset = masterList.get(choice-1);
            int profit = currentAsset.valueInTenYears(amountInvested);
            System.out.println("Investment value after 10 years is: $" + profit);
            System.out.println("Press enter to continue: ");


            currentAsset.setAmountInvested(amountInvested);
            currentAsset.setProfit(profit);
            portfolio.add(currentAsset);
            Scanner sc3 = new Scanner(System.in);
            String pressEnter = sc3.nextLine();




        }
        System.out.println("+--------------+-----------------+--------------------+");
        System.out.println("| ASSET SYMBOL | AMOUNT INVESTED | VALUE IN TEN YEARS |");
        for (Asset asset : portfolio) {
            System.out.println(asset.getName() + asset.getAmountInvested() + asset.getProfit());
        }


    }

    public static ArrayList<Asset> readFile(String fileName){
        try{
            BufferedReader fileRead = null;
            fileRead = new BufferedReader(new FileReader(fileName));
            ArrayList<Asset> assetList = new ArrayList<>();
            String line = "";
            String[][] assetDetails2d = new String[18][5];
            int i = 0;
            while ((line = fileRead.readLine()) != null) {
                assetDetails2d[i] = line.split(",");
                for(int j = 0; j < assetDetails2d[i].length; j++){
                    if (assetDetails2d[i][j].length() == 0){
                        assetDetails2d[i][j] = "0";
                    }
                }
                if(assetDetails2d[i].length > 3){
                    Asset a = new Stocks(assetDetails2d[i][0], assetDetails2d[i][1], Double.parseDouble(assetDetails2d[i][2]),
                            Double.parseDouble(assetDetails2d[i][3]), Double.parseDouble(assetDetails2d[i][4]));
                    assetList.add(a);
                }
                else if (assetDetails2d[i].length <= 3 && isNumber(assetDetails2d[i][2])){
                    Asset a = new StableAssets(assetDetails2d[i][0],assetDetails2d[i][1],Double.parseDouble(assetDetails2d[i][2]));
                    assetList.add(a);
                }else {
                    System.out.println("Bad input data: " + Arrays.toString(assetDetails2d[i]));
                }
                i++;
            }
            return assetList;
        }
        catch(FileNotFoundException e){
            System.out.println("File not found.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static boolean isNumber(String number){
        try {
            double numDouble = Double.parseDouble(number);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }

}

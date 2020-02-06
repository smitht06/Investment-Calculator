import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        BufferedReader fileRead = null;
        try{
            fileRead = new BufferedReader(new FileReader("assetData.csv"));
            List<Stocks> stockList = new ArrayList<>();
            List<StableAssets> stableAssetsList = new ArrayList<>();
            String line = "";
            fileRead.readLine();
            while ((line = fileRead.readLine()) != null){
                String[] assetDetails = line.split(",");
                if(assetDetails.length > 3){
                    Stocks stk = new Stocks(assetDetails[0],assetDetails[1],Double.parseDouble(assetDetails[2]),Double.parseDouble(assetDetails[3]),Double.parseDouble(assetDetails[4]));
                    stockList.add(stk);
                }else if (assetDetails.length < 4){
                    StableAssets stb = new StableAssets(assetDetails[0],assetDetails[1],Double.parseDouble(assetDetails[2]));
                    stableAssetsList.add(stb);
                }
            }
            for(Stocks e : stockList){
                System.out.println(e.getName());
                System.out.println(e.getID());
                System.out.println(e.getExpected1YearReturn());
                System.out.println(e.getExpected90DayReturn());
                System.out.println(e.getExpected5YearReturn());
            }

            }
        catch(FileNotFoundException e){
            System.out.println("File not found.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

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
            String[] assetDetails = new String[17];
            String[][] assetDetails2d = new String[17][5];
            int i = 0;
            while ((line = fileRead.readLine()) != null) {
                assetDetails2d[i] = line.split(",");
                i++;

            }


            for(int j = 0; j < 17; j++){
                for(int k = 0; k < 5; k++){
                    System.out.println(assetDetails2d[j][k]);
                }
            }
            }
        catch(FileNotFoundException e){
            System.out.println("File not found.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

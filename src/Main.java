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
            List<Asset> assetList = new ArrayList<>();

            String line = "";
            fileRead.readLine();
            String[] assetDetails = new String[17];
            String[][] assetDetails2d = new String[17][5];
            int i = 0;
            while ((line = fileRead.readLine()) != null) {
                int j = 0;
                assetDetails2d[i] = line.split(",");
                i++;
                if(assetDetails2d[i].length > 3){
                    Asset a = new Stocks(assetDetails2d[i][0],assetDetails2d[i][1],Double.parseDouble(assetDetails2d[i][2]),Double.parseDouble(assetDetails2d[i][3]),Double.parseDouble(assetDetails2d[i][4]));
                    assetList.add(a);
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

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
            for(Asset e : assetList){
                System.out.println(e.toString());
                }
            }
        catch(FileNotFoundException e){
            System.out.println("File not found.");
        } catch (IOException e) {
            e.printStackTrace();
        }
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

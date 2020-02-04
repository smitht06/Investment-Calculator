import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        String[] assets = new String[18];
        String[][] assets2 = new String[18][5];
        try{
            FileInputStream fileStream = null;
            Scanner fileIn = null;
            fileStream = new FileInputStream("assetData.csv");
            fileIn = new Scanner(fileStream);
            int counter = 0;
            fileIn.useDelimiter("\n");
            fileIn.useDelimiter(",");
            while(fileIn.hasNext()){
                assets[counter] = fileIn.nextLine();

                counter++;
            }

            for(int i = 0; i < assets.length-1; i++){
                for(int j = 0; j < assets.length-1; j++){
                    assets2[i] = assets[i].split(",");
            }}


//            assets2[0] = assets[0].split(",");
            for(int i = 0; i < assets.length-1; i++){
                System.out.println(Arrays.toString(assets2[i]));
            }



        }catch(FileNotFoundException e){
            System.out.println("File not found.");
        }
    }
}

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Object[] assets = new Object[18];
        Object[][] assets2 = new Object[18][5];
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
                    System.out.println(assets[i]);
                }

        }catch(FileNotFoundException e){
            System.out.println("File not found.");
        }
    }
}

package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    //DataProvider 1
    @DataProvider(name ="LoginData")
    public String [][] getData() throws IOException{
        String path = ".\\testData\\ExcelData1.xlsx";

        ExcelUtility xlutil = new ExcelUtility(path);

        int totalRows = xlutil.getRowCount("Sheet1");
        String sheetName = "Sheet 1";
        System.out.println("Sheet name is correct");
        int totalCols = xlutil.getCellCount("Sheet1", 1);

        String[][] loginData = new String[totalRows][totalCols];

        for(int i=1; i<=totalRows; i++){
            for(int j=0; j<totalCols; j++){
                loginData[i-1][j] = xlutil.getCellData("Sheet1", i, j);
            }
        }
        return loginData;//returning 2D array
    }
    //DataProvider 2

    //DataProvider 3

    //DataProvider 4.....
}

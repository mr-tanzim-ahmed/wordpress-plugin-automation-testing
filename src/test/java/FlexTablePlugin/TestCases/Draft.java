package FlexTablePlugin.TestCases;
import FlexTablePlugin.TestCases.*;
import FlexTablePlugin.Pages.*;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static FlexTablePlugin.Pages.BasePage.copyPasteData;

public class Draft extends BaseTest{


    public static void main(String args[]) throws Exception {

        String googleSheetCsvFile = "https://docs.google.com/spreadsheets/d/11qRH9xUuglOTIZa7JnWTVBYuGMT32ZhFuJ5_xypApGM/export?format=csv";

        URL url = new URL(googleSheetCsvFile);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

        String line;
        List<String[]> rows = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            rows.add(line.split(",")); // CSV split
        }
        reader.close();

        // 1-indexed values requested:

        String r1c1 = rows.get(1 - 1)[1 - 1];   // row 1, col 1
        String r2c2 = rows.get(2 - 1)[2 - 1];   // row 2, col 2
        String r3c3 = rows.get(3 - 1)[3 - 1];   // row 3, col 3
        String r4c2 = rows.get(4 - 1)[2 - 1];   // row 4, col 2

        System.out.println("Row1 Col1 → " + r1c1);
        System.out.println("Row2 Col2 → " + r2c2);
        System.out.println("Row3 Col3 → " + r3c3);
        System.out.println("Row4 Col2 → " + r4c2);
    }

}

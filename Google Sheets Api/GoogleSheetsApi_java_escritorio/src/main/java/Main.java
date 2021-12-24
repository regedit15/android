import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.List;

public class Main {


//    public static void main(String[] args) {
//        System.out.println("holaaaaaaaaaaaa!");
//
//
//        //    -----------------
//
//        try {
//
//            // Build a new authorized API client service.
//            final String spreadsheetId = "1E1z-MY5q3jbX0dIX1W8KHxT7mpbwpMeWKYxutdpHd6E";
//            final String range = "Hoja1!A1:C2";
//
//            String CREDENTIALS_FILE_PATH = "googleSheetsApiCredential.json";
//
//            // "/src/initialization/Lifepaths.txt"
//            // "initialization/Lifepaths.txt"
//            // "Lifepaths.txt"
//
////            InputStream in = MainActivity.class.getClassLoader().getResourceAsStream("/src/initialization/" + CREDENTIALS_FILE_PATH);
////            InputStream in2 = MainActivity.class.getClassLoader().getResourceAsStream("/initializatio/n" + CREDENTIALS_FILE_PATH);
////            InputStream in3 = MainActivity.class.getClassLoader().getResourceAsStream("/" + CREDENTIALS_FILE_PATH);
////            InputStream in4 = MainActivity.class.getClassLoader().getResourceAsStream("src/initialization/" + CREDENTIALS_FILE_PATH);
////            InputStream in5 = MainActivity.class.getClassLoader().getResourceAsStream("initialization/" + CREDENTIALS_FILE_PATH);
////            InputStream in6 = MainActivity.class.getClassLoader().getResourceAsStream("initialization/" + CREDENTIALS_FILE_PATH);
////
////            InputStream in7 = this.getClass().getResourceAsStream("/src/initialization/" + CREDENTIALS_FILE_PATH);
////            InputStream in8 = this.getClass().getResourceAsStream("/initializatio/n" + CREDENTIALS_FILE_PATH);
////            InputStream in9 = this.getClass().getResourceAsStream("/" + CREDENTIALS_FILE_PATH);
////            InputStream in10 = this.getClass().getResourceAsStream("src/initialization/" + CREDENTIALS_FILE_PATH);
////            InputStream in11 = this.getClass().getResourceAsStream("initialization/" + CREDENTIALS_FILE_PATH);
////            InputStream in12 = this.getClass().getResourceAsStream("initialization/" + CREDENTIALS_FILE_PATH);
//
//            // InputStream is13 = new FileInputStream("/res/googleSheetsApiCredential.json");
//
//
////            InputStream contentsInputStream = getAssets().open(CREDENTIALS_FILE_PATH);
//
//            // InputStream inputStream = getResources().openRawResource(R.v  .googleSheetsApiCredential);
//
//
//            // if (in == null && in2 == null && in3 == null && in4 == null && in5 == null && in6 == null) {
//            //     throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
//            // }
//
////            File tokenFolder = new File(getExternalFilesDir("").getAbsolutePath() + "/tokens");
//
//
//            Sheets service = SheetsQuickstart.getGoogleSheetService();
//
//
//            ValueRange response = service.spreadsheets().values()
//                    .get(spreadsheetId, range)
//                    .execute();
//
//
//            List<List<Object>> values = response.getValues();
//            if (values == null || values.isEmpty()) {
//                System.out.println("No data found.");
//            } else {
//                System.out.println("Name, Major");
//                for (List row : values) {
//
//
//                    // Print columns A and E, which correspond to indices 0 and 4.
//                    System.out.printf("%s, %s\n", row.get(0), row.get(4));
//                }
//            }
//
//        } catch (Exception e) {
//            System.out.printf("ERRRRRRRRRRRRRRRROOOOOOOOOOOOOORRRRRR!!!");
//            e.printStackTrace();
//        }
//
//
//    }


    private static Sheets sheetsService;
    private static final String SPREADSHEET_ID = "1E1z-MY5q3jbX0dIX1W8KHxT7mpbwpMeWKYxutdpHd6E";


    public static void main(String[] args) throws GeneralSecurityException, IOException {
        System.out.println("holaaaaaaaaaaaa!");


        sheetsService = SheetsQuickstart222.getSheetsService();

        String range = "Hoja1!A1:C2";

        ValueRange response = sheetsService.spreadsheets().values()
                .get(SPREADSHEET_ID, range)
                .execute();

        List<List<Object>> values = response.getValues();

        if (values == null || values.isEmpty()) {
            System.out.println("No data found.");
        } else {
            for (List row : values) {
//                System.out.printf("%s, %s\n", row.get(0), row.get(4));
                System.out.printf("%s %s from %s\n", row.get(5), row.get(4), row.get(1));
            }
        }


    }

}

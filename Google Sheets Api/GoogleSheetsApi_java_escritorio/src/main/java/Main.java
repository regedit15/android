import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        //    ----------------- Ejemplo de Google oficial
        // nos anda perfecto pero solo en escritorio, en android no. Funciona igual que el otro, ni un problema

        try {
            //            // Build a new authorized API client service.
            //            final String spreadsheetId = "1E1z-MY5q3jbX0dIX1W8KHxT7mpbwpMeWKYxutdpHd6E";
            //            final String range = "Hoja1!A1:C2";
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
            //
            //            if (values == null || values.isEmpty()) {
            //                System.out.println("No data found.");
            //            } else {
            //                System.out.println("Name, Major");
            //                for (List row : values) {
            //                    // Print columns A and E, which correspond to indices 0 and 4.
            //                    System.out.printf("%s, %s\n", row.get(0), row.get(4));
            //                }
            //            }


            //    ----------------- Ejemplo de video:
            //            https://www.youtube.com/watch?v=8yJrQk9ShPg&ab_channel=Twilio
            // nos anda perfecto pero solo en escritorio, en android no. Funciona igual que el otro, ni un problema

            Sheets sheetsService;
            final String SPREADSHEET_ID = "1E1z-MY5q3jbX0dIX1W8KHxT7mpbwpMeWKYxutdpHd6E";


            sheetsService = SheetsQuickstart222.getSheetsService();

            String range = "Hoja1!A1:C2";

            ValueRange response = sheetsService.spreadsheets().values().get(SPREADSHEET_ID, range).execute();

            List<List<Object>> values = response.getValues();

            if (values == null || values.isEmpty()) {
                System.out.println("No data found.");
            } else {
                for (List row : values) {
                    System.out.printf("%s %s from %s\n", row.get(5), row.get(4), row.get(1));
                }
            }


        } catch (Exception e) {
            System.out.printf("ERRRRRRRRRRRRRRRROOOOOOOOOOOOOORRRRRR!!!");
            e.printStackTrace();
        }


    }


}

package service;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class AuditService {
    private AuditService(){}
    private static  String filename= "./audit.csv";
    public static void write_action(String action_Name) {
        ArrayList<String[]> actions = new ArrayList<>();

        try {
            File f = new File(filename);
            if (!f.exists()){
                f.createNewFile();

            }
            CSVReader reader = new CSVReader(new FileReader(filename));
            String[] line;
            // get file contents;
            while ((line = reader.readNext()) != null) {
                actions.add(line);
            }

            reader.close();
            // write all contents back
            CSVWriter writer = new CSVWriter(new FileWriter(filename));

            String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            writer.writeNext(new String[]{action_Name, date});

            for (String[] i : actions){
                writer.writeNext(i);
            }
            writer.close();


        } catch (FileNotFoundException e) {
            System.out.println("File not found!");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}

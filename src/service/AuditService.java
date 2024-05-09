package service;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.HashMap;
import java.util.Objects;

public class AuditService {
    private AuditService(){}
    private static  String filename= "./audit.csv";
    public static void write_action(String action_Name) {
        HashMap<String, Integer> actions = new HashMap<>();


        try {
            File f = new File(filename);
            if (!f.exists()){
                f.createNewFile();

            }
            CSVReader reader = new CSVReader(new FileReader(filename));
            String[] line;
            // get file contents;
            while ((line = reader.readNext()) != null) {
                actions.put(line[0], Integer.parseInt(line[1]));
            }
            if (!actions.containsKey(action_Name)) {
                actions.put(action_Name, 1);
            } else {
                actions.put(action_Name, actions.get(action_Name) + 1);
            }
            reader.close();
            // write all contents back
            CSVWriter writer = new CSVWriter(new FileWriter(filename));
            for (var pair : actions.entrySet()) {
                writer.writeNext(new String[]{pair.getKey(), pair.getValue().toString()});

            }
            writer.close();


        } catch (FileNotFoundException e) {
            System.out.println("File not found!");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}

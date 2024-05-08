package service;

import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class AuditService {
    public static  String filename= "audit.csv";
    public static void write_action(String action_Name)  {
        HashMap<String,Integer> actions = new HashMap<>();

        try{
            CSVReader reader = new CSVReader(new FileReader("./audit.css"));
            String [] line ;
            // get file contents;
            while ((line =reader.readNext())!=null){
                    actions.put(line[0], Integer.parseInt(line[1]));
            }
            if(!actions.containsKey(action_Name)){
                actions.put(action_Name,1);
            }
            else{
                actions.put(action_Name,actions.get(action_Name)+1);
            }

        }
        catch (FileNotFoundException e){
            File f = new File("./audit.css");
            try {
                f.createNewFile();
                write_action(action_Name);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            reader.close();
            f.close()

        }

    }

}

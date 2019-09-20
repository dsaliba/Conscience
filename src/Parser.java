import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Parser {
    String csvFile = "src/questions.csv";
    BufferedReader br = null;
    String line = "";
    String cvsSplitBy = ",";

    public void parse(Game g){

        try {

            br = new BufferedReader(new FileReader(csvFile));
            br.readLine();

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] cells = line.split(cvsSplitBy);
                int count = 0;
                int[] fR = new int[6];
                int[] sR = new int[6];
                String faction = "";
                String question = "";
                String first = "";
                String second = "";
                for (String s : cells) {
                    if (count == 0) { //Faction
                        faction = s;
                    }else if (count == 1){ //Question
                        question = s;
                    } else if (count == 2){ //Answer 1
                        first = s;
                    } else if (count < 9) { //Results
                        sR[count-3] = Integer.parseInt(s);
                    }else if (count == 9) { //Answer 2
                        second = s;
                    } else { //Results
                        sR[count-10] = Integer.parseInt(s);
                    }
                    count ++;
                }
                for (Faction f : g.factions){
                    if (!f.name.equals(faction)) continue;
                    f.questions.add(new Question(faction, question, first, second, fR, sR));
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



}

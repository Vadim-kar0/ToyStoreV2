package ModelService;

import Model.Data.LotteryParticipant;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    public static  void writeUserData(LotteryParticipant user){
        try (FileWriter fw = new FileWriter("Lottery.txt",true)){
            fw.append(user.getName()).append(" - выйграл: ").append(user.getToy().getName());
            fw.append("\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

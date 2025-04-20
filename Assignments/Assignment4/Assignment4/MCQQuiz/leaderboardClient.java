package MCQQuiz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class leaderboardClient {
    public String[][] sendScores(String name, String score, String timetaken) {

        try{

            Socket quizSocket = new Socket("localhost", 54123);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(quizSocket.getOutputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(quizSocket.getInputStream()));

            out.write(name+"\n");
            out.write(score+"\n");
            out.write(timetaken+"\n");
            out.flush();
            
            String[][] leaderboardWithRanks = new String[4][4];
            
            for (int i = 0; i < 4; i++){
                for (int j = 0; j < 4; j++){
                    leaderboardWithRanks[i][j] = in.readLine();
                }
            }
            
            in.close();
            out.close();
            quizSocket.close();
            return leaderboardWithRanks;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
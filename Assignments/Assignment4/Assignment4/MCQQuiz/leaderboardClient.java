package MCQQuiz;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class leaderboardClient {
    public void showLeaderboard(String name, String score, String timetaken) {

        try{
            Socket quizSocket = new Socket("localhost", 54123);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(quizSocket.getOutputStream()));
            
            out.write("String One\n");
            out.write("String Two\n");
            out.write("String Three\n");
            out.flush();

            out.close();
            quizSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

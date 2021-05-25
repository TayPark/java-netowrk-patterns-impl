import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerInitializer {
    public static void main(String args[]) {
        final int PORT = 5000;

        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            Socket connection;

            while (true) {
                connection = serverSocket.accept();
                InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line = bufferedReader.readLine();

                System.out.println("READ: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

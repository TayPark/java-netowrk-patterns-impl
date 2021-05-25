import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TestClient {
    public static void main(String args[]) {
        System.out.println("Client is running");

        final String HOST = "127.0.0.1";
        final int PORT = 5000;
        String message;

        try {
            Socket socket = new Socket(HOST, PORT);
            OutputStream out = socket.getOutputStream();
            message = "0x5001|홍길동|22";
            out.write(message.getBytes());
            socket.close();

            Socket socket2 = new Socket(HOST, PORT);
            OutputStream out2 = socket2.getOutputStream();
            message = "0x6001|Hong|1234|홍길동|22|남성";
            out2.write(message.getBytes());
            socket2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

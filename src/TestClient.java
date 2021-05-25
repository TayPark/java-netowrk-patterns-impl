import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TestClient {
    public static void main(String args[]) {
        System.out.println("Client is running");

        String message;

        try {
            Socket socket = new Socket("127.0.0.1", 5000);
            OutputStream out = socket.getOutputStream();
            message = "0x5001|홍길동|22";
            out.write(message.getBytes());
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

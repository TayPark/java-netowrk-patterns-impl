import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Dispatcher {

    private final int HEADER_SIZE = 6;

    public void dispatch(ServerSocket serverSocket) {
        try {
            Socket socket = serverSocket.accept();
            demultiplex(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void demultiplex(Socket socket) {
        InputStream inputStream = null;
        byte[] buffer = new byte[HEADER_SIZE];

        try {
            inputStream = socket.getInputStream();
            inputStream.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String header = new String(buffer);

        switch (header) {
            case "0x5001":
                SayHelloProtocol sayHelloProtocol = new SayHelloProtocol();
                sayHelloProtocol.handleEvent(inputStream);
                break;
            case "0x6001":
                UpdateProfileProtocol updateProfileProtocol = new UpdateProfileProtocol();
                updateProfileProtocol.handleEvent(inputStream);
                break;
        }

    }
}

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Dispatcher {

    private final int HEADER_SIZE = 6;

    public void dispatch(ServerSocket serverSocket, HandleMap handleMap) {
        try {
            Socket socket = serverSocket.accept();
            demultiplex(socket, handleMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void demultiplex(Socket socket, HandleMap handleMap) {
        InputStream inputStream = null;
        byte[] buffer = new byte[HEADER_SIZE];

        try {
            inputStream = socket.getInputStream();
            inputStream.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String header = new String(buffer);

        handleMap.get(header).handleEvent(inputStream);
    }
}

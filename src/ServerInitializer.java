import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerInitializer {
    public static void main(String args[]) {
        final int PORT = 5000;

        Reactor reactor = new Reactor(PORT);

        reactor.registerHandler(new SayHelloEventHandler());
        reactor.registerHandler(new UpdateProfileEventHandler());

//      만약 다른 프로토콜(핸들러)가 필요할 경우 switch-case를 쓰지 않고 여기서 추가한다.

        reactor.startServer();
    }
}

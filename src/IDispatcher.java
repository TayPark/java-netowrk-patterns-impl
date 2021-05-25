import java.net.ServerSocket;

public interface IDispatcher {
    public void dispatch(ServerSocket serverSocket, HandleMap handleMap);
}

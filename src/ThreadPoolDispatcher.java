import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadPoolDispatcher implements IDispatcher {

    static final String NUM_OF_THREAD = "10";
    static final String THREAD_DROP = "Threads";

    private int numOfThread;

    public ThreadPoolDispatcher() {
        numOfThread = Integer.parseInt(System.getProperty(THREAD_DROP, NUM_OF_THREAD));
    }

    @Override
    public void dispatch(ServerSocket serverSocket, HandleMap handleMap) {
        for (int i = 0; i < (numOfThread - 1); i++) {
            Thread thread = new Thread() {
                public void run() {
                    dispatchLoop(serverSocket, handleMap);
                }
            };

            thread.start();
            System.out.println("Created and started thread = " + thread.getName());
        }
        System.out.println("Iterative server starting in main thread " + Thread.currentThread().getName());
        dispatchLoop(serverSocket, handleMap);
    }

    private void dispatchLoop(ServerSocket serverSocket, HandleMap handleMap) {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                Runnable demux = new Demultiplexer(socket, handleMap);
                demux.run();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}


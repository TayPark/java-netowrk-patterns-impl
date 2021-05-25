
import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;

public class SayHelloProtocol {
    private static final int DATA_SIZE = 1024;
    private static final int TOKEN_NUM = 2;

    public void handleEvent(InputStream inputStream) {
        byte[] buffer = new byte[DATA_SIZE];

        try {
            inputStream.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String data = new String(buffer);

        String[] params = new String[TOKEN_NUM];
        StringTokenizer tokenizer = new StringTokenizer(data, "|");

        int i = 0;
        while (tokenizer.hasMoreTokens()) {
            params[i] = tokenizer.nextToken();
            i++;
        }
    }
}

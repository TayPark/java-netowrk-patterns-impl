import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UpdateProfileEventHandler implements EventHandler {
    private static final int DATA_SIZE = 1024;
    private static final int TOKEN_NUM = 5;

    @Override
    public String getHandler() {
        return "0x6001";
    }

    public void handleEvent(InputStream inputStream) {
        byte[] buffer = new byte[DATA_SIZE];

        try {
            inputStream.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String data = new String(buffer);

        String[] params = new String[TOKEN_NUM];
        StringTokenizer token = new StringTokenizer(data, "|");

        int i = 0;
        while (token.hasMoreTokens()) {
            params[i] = token.nextToken();
            i++;
        }

        sayHello(params);
    }

    private void sayHello(String[] params) {
        for (String param : params) {
            if (param != null) {
                System.out.println(param);
            }
        }
    }
}
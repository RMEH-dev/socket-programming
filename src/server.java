import java.io.IOException;
import java.net.ServerSocket;

public class server {
    public static void main(String[] args) throws IOException {

        //Socket -> ip + port
        // 1 port -> 1 process only

        ServerSocket serverSocket = new ServerSocket(5555);
        serverSocket.accept();
        System.out.println("Hello world!");
    }
}
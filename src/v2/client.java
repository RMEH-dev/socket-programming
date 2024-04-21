package v2;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class client {

    public static void main(String[] args) throws IOException {

System.out.println("connecting to the v1.server");
Socket socket = new Socket("localhost", 5555);
System.out.println("Connected to the v1.server");

//send data from the v1.client to the v1.server

        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeUTF("Hello v1.server.");
        dataOutputStream.flush();
        // as a best practice use flush to close the stream
        // as a best practice close the socket as well

        socket.close();


    }
}

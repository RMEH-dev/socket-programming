package v6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class serverClientThread extends Thread{

    private Socket socket;
    private final int clientCount;

    public serverClientThread (Socket socket, int clientCount){
        this.socket =socket;
        this.clientCount=clientCount;
    }

    @Override
    public void run() {

        try {
            System.out.println("Client connected. Client:" + clientCount);

            InputStream inputStream = socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);

            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            Scanner scanner = new Scanner(System.in);

            String message = "";
            while (!message.equals("stop")) {
                message = dataInputStream.readUTF();
                System.out.println("v6.client" + clientCount + " says: " + message);

                //send a message to the client

                String message2 = scanner.nextLine();
                dataOutputStream.writeUTF(message2);
                dataOutputStream.flush();
            }
        }catch (Exception e){
            e.printStackTrace(); //todo: better exception handling
        }
    }
}

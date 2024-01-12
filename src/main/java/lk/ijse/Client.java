package lk.ijse;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args){

        Scanner scanner=new Scanner(System.in);

        try {
            Socket remoteSocket = new Socket("localhost",3002);
            DataOutputStream dataOutputStream = new DataOutputStream(remoteSocket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(remoteSocket.getInputStream());
            // dataOutputStream.writeUTF("Hello Server");

            while (true){

                System.out.println(dataInputStream.readUTF());
                String s = scanner.nextLine();
                dataOutputStream.writeUTF(s);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

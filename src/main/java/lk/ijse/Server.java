package lk.ijse;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        try{
            ServerSocket serverSocket = new ServerSocket(3002);
            System.out.println("Server Socket Created");

            Socket localSocket = serverSocket.accept();
            System.out.println("Request accepted");

            DataInputStream dataInputStream = new DataInputStream(localSocket.getInputStream());


            DataOutputStream dataOutputStream = new DataOutputStream(localSocket.getOutputStream());

            while(true){
                String s1 = scanner.nextLine();
                dataOutputStream.writeUTF(s1);
                String s = dataInputStream.readUTF();
                System.out.println(s);
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

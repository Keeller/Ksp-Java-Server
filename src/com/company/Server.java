package com.company;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args){
        try(ServerSocket server =new ServerSocket(12345)) {
            Socket client=server.accept();
            DataOutputStream ds=new DataOutputStream(client.getOutputStream());
            DataInputStream is=new DataInputStream(client.getInputStream());

            while (!client.isClosed()){
                String entry=is.readUTF();

                if(entry.equalsIgnoreCase(":q")){
                    ds.writeUTF("Bye");
                    ds.flush();
                    break;
                }
                Sequence s=new Sequence(entry,";");
                ds.writeUTF(s.getResult());

            }
            is.close();
            ds.close();
            client.close();

        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
}

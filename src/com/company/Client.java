package com.company;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args){
        try{ Socket socket=new Socket("localhost",12345);
             DataInputStream ois=new DataInputStream(socket.getInputStream());
             DataOutputStream oos=new DataOutputStream(socket.getOutputStream());
             BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

             while (!socket.isOutputShutdown()){
                 if(br.ready()){
                     String clientCommand=br.readLine();
                     oos.writeUTF(clientCommand);
                     oos.flush();

                     if(clientCommand.equalsIgnoreCase(":q")){

                         if(ois.available()>0)     {

                             String in = ois.readUTF();
                             System.out.println(in);
                         }

                         break;
                     }

                     String in=ois.readUTF();
                     System.out.println(in);
                 }
             }



        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}

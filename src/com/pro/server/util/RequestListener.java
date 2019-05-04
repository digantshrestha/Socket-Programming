package com.pro.server.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class RequestListener extends Thread{
    private Socket socket;
    private PrintStream out;
    private Client client;
    private BufferedReader reader;
    private ClientHandler handler;
    
    public RequestListener(Socket socket, ClientHandler handler)
    throws IOException{
        this.socket=socket;
        this.handler=handler;
        out=new PrintStream(socket.getOutputStream());
        reader=new BufferedReader(new InputStreamReader(
            socket.getInputStream()));
    }

    @Override
    public void run() {
        try{
            login();
            while(true){
                out.println("(Me)>");
                String line=reader.readLine();
                out.println();
                if(line.equalsIgnoreCase("exit")){
                    client.getSocket().close();
                }
                for(Client c:handler.getClients()){
                    PrintStream ps=new PrintStream(
                        c.getSocket().getOutputStream());
                    ps.println(client.getUserName()+" says>"+line);
                }
            }
        }catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }

    public void login()throws IOException{
        out.println("Welcome to the chat server");
        out.println("Enter your name");
        String name=reader.readLine();
        out.println();
        out.println("Hello "+name);
        client=new Client(name, socket);
        handler.addClient(client);
    }
}
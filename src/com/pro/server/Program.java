package com.pro.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.pro.server.util.ClientHandler;
import com.pro.server.util.RequestListener;

public class Program{
    public static void main(String[] args) {
        int port=9000;
        try{
            ServerSocket server=new ServerSocket(port);
            System.out.println("Server is running at "+port);
            ClientHandler handler=new ClientHandler();
            while(true){
                Socket socket=server.accept();
                System.out.println("Connection request from: "+
                socket.getInetAddress().getHostAddress());
                RequestListener listener=new RequestListener(socket, handler);
                listener.start();
            }
        }catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }
}
package com.pro.server.util;

import java.net.Socket;

public class Client{
    private String userName;
    private Socket socket;

    public Client() {}

    public Client(String userName, Socket socket){
        this.userName=userName;
        this.socket=socket;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param socket the socket to set
     */
    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    /**
     * @return the socket
     */
    public Socket getSocket() {
        return socket;
    }
}
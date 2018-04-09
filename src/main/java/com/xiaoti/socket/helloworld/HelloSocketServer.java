package com.xiaoti.socket.helloworld;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloSocketServer {
    
    private static final int PORT = 9999;
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        
        //实例化一个服务器端的socket连接
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            System.err.println("Could not listen on port:9999");
            System.exit(1);
            e.printStackTrace();
        }
        
        Socket clientSocket = null;
        
        try {
            //用于接收来自客户端的连接
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("accept failed");
            System.exit(1);
            e.printStackTrace();
        }
        
        //客户端有数据了就向屏幕打印Hello World
        System.out.println("hello world");
        clientSocket.close();
        serverSocket.close();
        
    }
    
}
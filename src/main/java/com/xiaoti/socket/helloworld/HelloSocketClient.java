package com.xiaoti.socket.helloworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class HelloSocketClient {
    
    private static final int PORT = 9999;
    public static void main(String[] args) throws IOException{
        
        Socket socket = null;
        BufferedReader br = null;
        
        //下面这段程序，用于将输入输出流和Socket相关联
        try {
            socket = new Socket("localhost", PORT);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host:localhost");
            System.exit(1);
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Could not get I/O for the connection");
            System.exit(1);
        }
        
        System.out.println(br.readLine());
        br.close();
        socket.close();
    }
    
}

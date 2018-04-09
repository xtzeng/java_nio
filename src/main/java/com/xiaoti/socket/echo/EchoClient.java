package com.xiaoti.socket.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {
    
    private static final int PORT = 9998;
    
    private static final String HOST = "localhost";
    
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        PrintWriter pw = null;
        BufferedReader br = null;
        
        try {
            socket = new Socket(HOST, PORT);
            pw = new PrintWriter(socket.getOutputStream(), true);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know abount host:localhost");
            System.exit(1);
            e.printStackTrace();
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        
        System.out.println(br.readLine());
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput = null;
        //将客户端Socket输入流（即服务器端Socket的输出流）输出到标准输出上
        while((userInput = stdIn.readLine()) != null){
            pw.println(userInput);
            System.out.println(br.readLine());
        }
        
        pw.close();
        br.close();
        socket.close();
        
    }
    
    
    
}
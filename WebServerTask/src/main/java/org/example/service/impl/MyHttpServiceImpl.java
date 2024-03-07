package org.example.service.impl;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.example.ProjectUtils.HandlerClass;
import org.example.service.MyHttpService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static org.example.commons.HttpServer.PORT;

public class MyHttpServiceImpl implements MyHttpService {
    public void start(int port){
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(PORT);
            System.out.println("server started on port" +": "+ port);

            while (true){
                Socket socket =serverSocket.accept();
                System.out.println("New connection established");

               HandlerClass handlerClass = new HandlerClass(socket);
               Thread thread = new Thread(handlerClass);
               thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if(serverSocket != null){
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

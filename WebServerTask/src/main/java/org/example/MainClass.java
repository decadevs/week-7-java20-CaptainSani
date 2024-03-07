package org.example;

import org.example.service.MyHttpService;
import org.example.service.impl.MyHttpServiceImpl;

import static org.example.commons.HttpServer.PORT;

public class MainClass {
    public static void main(String[] args) {
       MyHttpService service = new MyHttpServiceImpl();
        service.start(PORT);
    }
}
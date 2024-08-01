package com.example.xiaoheihe.TestMain.nio;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Nioclient {
    private ServerSocketChannel server;

    private InetSocketAddress inetSocketAddress;

    public void start(){
        try {
            server = ServerSocketChannel.open();
            inetSocketAddress = new InetSocketAddress(18099);
            server.socket().bind(inetSocketAddress);
            server.configureBlocking(false);
            Selector selector = Selector.open();
            //注册selector
            server.register(selector, SelectionKey.OP_ACCEPT);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

package org.example.designpattern.proxy.remote;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            // 1、Server提供具体的实现类
            RemoteProxy realService = new RemoteProxyProxyImpl();

            // 2、将该服务注册到Registry中供客户端调用
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("HelloRemoteService", realService);

            System.out.println("======= 启动RMI服务成功! =======");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}

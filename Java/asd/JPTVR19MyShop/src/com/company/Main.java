package com.company;

import factory.ConnectSingleton;

public class Main {

    public static void main(String[] args) {
        App app = new App();
        try {
            app.run();
        } finally {
            ConnectSingleton connect = ConnectSingleton.getInstance();
            if(connect.getEntityManager() != null){
                connect.getEntityManager().close();
            }
            if(connect.getEntityManagerFactory() != null){
                connect.getEntityManagerFactory().close();
            }
        }
    }
}

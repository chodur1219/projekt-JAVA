package controllers;

import domain.Highscores;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

class MyDataBaseConnectionController {
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    private static MyDataBaseConnectionController instance;
    private MyDataBaseConnectionController(){}
    public static MyDataBaseConnectionController getInstance() {
        if(instance == null) {
            instance = new MyDataBaseConnectionController(); //SINGLETON + DAO (DATABASE ACCESS OBJECT )
        }
        return instance;
    }
    public void openDatabaseConnection() {
        System.out.println("Connecting to Database...");
        entityManagerFactory = Persistence.createEntityManagerFactory("mastermind");
        entityManager = entityManagerFactory.createEntityManager();
        System.out.println("Looking for records in DB...");
        Highscores records = entityManager.find(Highscores.class, 1);
    }


    public void closeDatabaseConnection() {
        entityManager.close();
        entityManagerFactory.close();
    }

}
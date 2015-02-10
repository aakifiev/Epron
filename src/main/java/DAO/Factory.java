package main.java.DAO;

public class Factory {
    private static Factory instance = null;

    public static synchronized Factory getInstance(){
          if (instance == null){
            instance = new Factory();
          }
          return instance;
    }
}

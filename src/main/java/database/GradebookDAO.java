package database;

public class GradebookDAO {
    DBConnector db;

    public GradebookDAO (){this.db = new DBConnector();}

//create method with username and password, get the password for username and login fails if password and email

    public static void main(String[]args){
        new GradebookDAO ();
    }
}

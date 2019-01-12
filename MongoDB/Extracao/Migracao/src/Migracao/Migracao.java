package Migracao;

import com.mongodb.*;

public class Migracao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            MongoClient mc = new MongoClient("localhost", 27017);
            DB db = mc.getDB("test");
            System.out.println("MongoDb connected");
        
            DBCollection coll = db.getCollection("test");
            DBCursor cursor = coll.find();
        
            while(cursor.hasNext()){
                int i = 1;
                System.out.println(cursor.next());
                i++;
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }    
}

package cuj.tdd.friendship;

import com.mongodb.*;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;

public class FriendsCollection {
    private MongoCollection friends;

    public FriendsCollection() {
        try{
            DB db = new MongoClient().getDB("friendships");
            friends = new Jongo(db).getCollection("friends");
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public Person findByName(String name){
        return friends.findOne("{_id: #}",name).as(Person.class);
    }

    public void save(Person friend){
        friends.save(friend);
    }
}

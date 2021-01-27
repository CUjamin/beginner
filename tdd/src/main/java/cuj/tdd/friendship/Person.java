package cuj.tdd.friendship;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;

    private List<String> friends;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
        this.friends = new ArrayList<String>();
    }

    public List<String> getFriends() {
        return friends;
    }

    public void addFriend(String friend){
        if(!friends.contains(friend)){
            friends.add(friend);
        }
    }
}

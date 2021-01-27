package cuj.tdd.friendship;

import org.jongo.MongoCursor;

import java.util.*;

/**
 * @author cujamin
 * @date 2020/6/27
 */
public class FriendshipsMongo {

    private FriendsCollection friends;

    public FriendshipsMongo() {
        this.friends = new FriendsCollection();
    }

    public List<String> getFriendsList(String personName) {
        Person p = friends.findByName(personName);
        if (null == p) {
            return Collections.emptyList();
        }
        return p.getFriends();
    }

    public boolean areFriends(String person1Name, String person2Name) {
        Person person1 = friends.findByName(person1Name);
        return null != person1 && person1.getFriends().contains(person2Name);
    }

    private void addFriend(String personName, String friendName) {
        Person person = friends.findByName(personName);
        if (null == person) {
            person = new Person();
        }
        person.addFriend(friendName);
        friends.save(person);
    }
}


package cuj.tdd.friendship;

import org.jongo.MongoCursor;

import java.util.*;

/**
 * @author cujamin
 * @date 2020/6/27
 */
public class Friendships {

    private final Map<String,List<String>> friendships = new HashMap<String, List<String>>();

    public void makeFriends(String person1Name,String person2Name){
        addFriend(person1Name,person2Name);
        addFriend(person2Name,person1Name);
    }

    public List<String> getFriendsList(String personName) {
        if(!friendships.containsKey(personName)){
            return Collections.emptyList();
        }
        return friendships.get(personName);
    }

    public boolean areFriends(String person1Name, String person2Name) {
        return friendships.containsKey(person1Name) && friendships.get(person1Name).contains(person2Name);
    }

    private void addFriend(String personName, String friendName) {
        if (!friendships.containsKey(personName)) {
            friendships.put(personName, new LinkedList<String>());
        }

        List<String> friends = friendships.get(personName);
        if (!friends.contains(friendName)) {
            friends.add(friendName);
        }
    }
}

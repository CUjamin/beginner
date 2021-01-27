package cuj.tdd.friendship;

import cuj.tdd.friendship.Friendships;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author cujamin
 * @date 2020/6/27
 */
public class FriendshipsTest {
    Friendships friendships;
    @Before
    public void setUp() throws Exception {
        friendships = new Friendships();
        friendships.makeFriends("Joe","Audrey");
        friendships.makeFriends("Joe","Peter");
        friendships.makeFriends("Joe","Michael");
        friendships.makeFriends("Joe","britney");
        friendships.makeFriends("Joe","Paul");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void makseFriends() {

    }

    @Test
    public void alexDoesNotHaveFriends() {
        Assert.assertTrue("Alex does not have friends",friendships.getFriendsList("Alex").isEmpty());
    }

    @Test
    public void joeHas5Friends(){
        Assert.assertEquals("Joe has 5 friends",5,friendships.getFriendsList("Joe").size());
    }

    @Test
    public void joeIsFriendWithEveryone(){
        List<String> friendsOfJoe = Arrays.asList("Audrey","Peter","Michael","britney","Paul");
        Assert.assertTrue(friendships.getFriendsList("Joe").containsAll(friendsOfJoe));
    }

    @Test
    public void areFriends() {
    }
}
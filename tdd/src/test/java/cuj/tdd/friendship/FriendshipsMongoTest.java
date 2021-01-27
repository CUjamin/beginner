package cuj.tdd.friendship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

@RunWith(MockitoJUnitRunner.class)
public class FriendshipsMongoTest {
    @InjectMocks
    FriendshipsMongo friendships;

    @Mock
    FriendsCollection friends;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void jeoHas5Friends(){
        List<String> expected = Arrays.asList("Audrey","Peter","Michael","britney","Paul");
        Person jeo = spy(new Person("Jeo"));
        doReturn(expected).when(jeo).getFriends();
        doReturn(jeo).when(friends).findByName("Jeo");
        Assert.assertEquals(5,friendships.getFriendsList("Jeo").size());
    }
}
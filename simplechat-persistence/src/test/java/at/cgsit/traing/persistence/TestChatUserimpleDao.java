package at.cgsit.traing.persistence;


import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import at.cgsit.training.persistence.ChatUserimpleDao;
import at.cgsit.training.persistence.entities.ChatUser;

import java.util.List;

@Ignore
public class TestChatUserimpleDao {

    @Test
    public void testOne () {

        ChatUserimpleDao usage  = new ChatUserimpleDao();
        ChatUser newUser = usage.doSomehting();
        Assert.assertNotNull(newUser);

    }


}

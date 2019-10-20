package at.cgsit.traing.persistence;


import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import at.cgsit.training.persistence.ChatUserImplDao;
import at.cgsit.training.persistence.entities.ChatUser;

@Ignore
public class TestChatUserImplDao {

    @Test
    public void testOne () {

        ChatUserImplDao usage  = new ChatUserImplDao();
        ChatUser newUser = usage.doSomehting();
        Assert.assertNotNull(newUser);

    }


}

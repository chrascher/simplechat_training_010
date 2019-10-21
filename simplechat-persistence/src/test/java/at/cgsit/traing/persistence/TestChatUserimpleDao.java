package at.cgsit.traing.persistence;


import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import at.cgsit.training.persistence.dao.ChatUserimpleDao;
import at.cgsit.training.persistence.entities.ChatUser;

@Ignore
public class TestChatUserimpleDao {

    @Test
    public void testOne () {

        ChatUserimpleDao usage  = new ChatUserimpleDao();
        ChatUser newUser = usage.doSomehting();
        Assert.assertNotNull(newUser);

    }


}

package at.cgsit.traing.persistence;


import at.cgsit.training.persistence.entities.ChatUserEntity;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import at.cgsit.training.persistence.dao.ChatUserimpleDao;

@Ignore
public class TestChatUserimpleDaoEntity {

    @Test
    public void testOne () {

        ChatUserimpleDao usage  = new ChatUserimpleDao();
        ChatUserEntity newUser = usage.doSomehting();
        Assert.assertNotNull(newUser);

    }


}

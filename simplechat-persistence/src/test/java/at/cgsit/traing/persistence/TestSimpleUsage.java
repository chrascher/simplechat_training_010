package at.cgsit.traing.persistence;


import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import at.cgsit.training.persistence.SimpleUsage;
import at.cgsit.training.persistence.entities.ChatUser;

import java.util.List;

@Ignore
public class TestSimpleUsage {

    @Test
    public void testOne () {

        SimpleUsage usage  = new SimpleUsage();

        List<ChatUser> chatUsers = usage.doSomehting();

        Assert.assertNotNull(chatUsers);

    }


}

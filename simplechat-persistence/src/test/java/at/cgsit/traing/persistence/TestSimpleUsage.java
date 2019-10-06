package at.cgsit.traing.persistence;

import at.cgsit.training.persistence.SimpleUsage;
import at.cgsit.training.persistence.entities.ChatUser;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestSimpleUsage {

    @Test
    public void testOne () {

        SimpleUsage usage  = new SimpleUsage();

        List<ChatUser> chatUsers = usage.doSomehting();

        Assert.assertNotNull(chatUsers);

    }


}

package at.cgsit.training.persistence.dao;

import at.cgsit.training.persistence.daobase.JpaDao;
import at.cgsit.training.persistence.entities.ChatUser;

/**
 * 
 */
public class ChatUserDao extends JpaDao<ChatUser> {

    @Override
    protected Class<ChatUser> getEntityClass() {
        return ChatUser.class;
    }


}

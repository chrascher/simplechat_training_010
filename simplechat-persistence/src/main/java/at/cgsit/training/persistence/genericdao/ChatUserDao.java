package at.cgsit.training.persistence.genericdao;

import at.cgsit.training.persistence.common.JpaDao;
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

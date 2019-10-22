package at.cgsit.training.persistence.genericdao;

import at.cgsit.training.persistence.common.JpaDao;
import at.cgsit.training.persistence.entities.ChatUserEntity;

/**
 * 
 */
public class ChatUserDao extends JpaDao<ChatUserEntity> {

    @Override
    protected Class<ChatUserEntity> getEntityClass() {
        return ChatUserEntity.class;
    }


}

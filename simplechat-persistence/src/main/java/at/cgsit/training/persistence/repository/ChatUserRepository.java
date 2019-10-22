package at.cgsit.training.persistence.repository;

import at.cgsit.training.persistence.entities.ChatUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatUserRepository extends JpaRepository<ChatUserEntity, Long> {
    ChatUserEntity findByName(String productName);

}
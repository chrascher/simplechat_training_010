package at.cgsit.training.persistence.repository;

import at.cgsit.training.persistence.entities.ChatUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatUserRepository extends JpaRepository<ChatUser, Long> {
    ChatUser findByName(String productName);
}
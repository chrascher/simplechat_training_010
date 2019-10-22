package at.cgsit.training.persistence.entities;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ChatRoom
 * <p>
 * JPA Annotation Documentation see:
 * <br/>
 * <ol>
 * <li> https://dzone.com/articles/all-jpa-annotations-mapping-annotations </li>
 * <li> https://docs.oracle.com/javaee/7/api/javax/persistence/Column.html </li>
 * <li> </li>
 * </ol>
 */
@Entity
public class ChatRoomEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "user_name", length = 50, nullable = false)
    private String roomName;

    @Column(name = "max_users", columnDefinition = "integer default 75")
    private int maxUsers;

    /**
     * if set it is the default room.
     * if not or null it is any chat room
     */
    @Column(name = "default_room", nullable = true)
    private Boolean defaultRoom;

    /**
     * if set it is a custom temporary room
     */
    @Column(name = "temp_room", nullable = true)
    private Boolean tempRoom;


    public ChatRoomEntity() {
        super();
    }

    public String getRoomName() {
        return this.roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMaxUsers() {
        return maxUsers;
    }

    public void setMaxUsers(int maxUsers) {
        this.maxUsers = maxUsers;
    }

    public Boolean getDefaultRoom() {
        return defaultRoom;
    }

    public void setDefaultRoom(Boolean defaultRoom) {
        this.defaultRoom = defaultRoom;
    }

	public Boolean getTempRoom() {
		return tempRoom;
	}

	public void setTempRoom(Boolean tempRoom) {
		this.tempRoom = tempRoom;
	}
}

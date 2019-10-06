package at.cgsit.training.persistence.entities;


import javax.persistence.*;
import java.util.Date;

/**
 *
 */
@Entity
@Table( name="chat_user")
public class ChatUser {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    // @Pattern(regexp = "\\w+@\\w+\\.\\w+(,\\s*\\w+@\\w+\\.\\w+)*")
    @Column(name="email", length= 100, nullable = false)
    private String email;

    @Column(name="nicname", length= 100, nullable = false)
    private String nicname;

    @Column(name="vorname", length= 100, nullable = true)
    private String vorname;

    @Column(name="name", length= 100, nullable = true)
    private String name;

    @Column(name="password", length= 100, nullable = true)
    private String password;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(name="createdAt", length= 100, nullable = false)
    private java.time.LocalDateTime createdAt;


}

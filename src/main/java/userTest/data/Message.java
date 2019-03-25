package userTest.data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "MESSAGES")
public class Message {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "TITLE")
    @NotNull
    private String title;

    // @Temporal(TemporalType.DATE)
    @Column(name = "DATE")
    private LocalDate date;

    @Column(name = "CONTENT")
    @NotNull
    private String content;

    @Column(name = "USER_GROUP")
    @NotNull
    private String userGroup;

    public Message() {
    }

    public Message(String title, LocalDate date, String content, String userGroup) {
        this.title = title;
        this.date = date;
        this.content = content;
        this.userGroup = userGroup;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", content='" + content + '\'' +
                ", userGroup='" + userGroup + '\'' +
                '}';
    }
}

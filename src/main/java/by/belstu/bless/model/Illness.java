package by.belstu.bless.model;

import javax.persistence.*;

@Entity
public class Illness {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String text;
    private String tag;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    public User user;

    public String GetUserName(){
        return user != null ? user.getUsername() : "<none>";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User author) {
        this.user = author;
    }

    public Illness() {
    }

    public Illness(String text, String tag, User user) {
        this.text = text;
        this.tag = tag;
        this.user = user;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

}

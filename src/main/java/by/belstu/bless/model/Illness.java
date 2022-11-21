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


    @ManyToOne
    @JoinColumn(name = "userfor_id")
    public User userfor;

    public User getUserfor() {
        return userfor;
    }

    public void setUserfor(User userfor) {
        this.userfor = userfor;
    }

    public String getUserName(){
        return user != null ? user.getUsername() : "none";
    }

    public String getUserFor(){
        return userfor != null ? userfor.getUsername() : "none";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User author) {
        this.user = author;
    }

    public Illness() {
    }

    public Illness(String text, String tag, User user, User userfor) {
        this.text = text;
        this.tag = tag;
        this.user = user;
        this.userfor = userfor;
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

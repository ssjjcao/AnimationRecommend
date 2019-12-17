package animation_recommend_backend.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "comment")
    private String comment;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "updateTime")
    private Timestamp updateTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "createTime")
    private Timestamp createTime;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "user_id")
    private User user;
    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "animation_id")
    private Animation animation;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Animation getAnimation() {
        return animation;
    }

    public void setAnimation(Animation animation) {
        this.animation = animation;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}

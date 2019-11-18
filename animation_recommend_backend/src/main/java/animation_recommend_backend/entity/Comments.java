package animation_recommend_backend.entity;

import animation_recommend_backend.entity.combineKey.CommentKey;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "comments")
@IdClass(CommentKey.class)
public class Comments {

    @Id
    @Column(name = "userID")
    private int userID;
    @Id
    @Column(name = "animationID")
    private int animationID;
    @Id
    @Column(name = "comment")
    private String comment;
    @Column(name = "updateTime")
    private Timestamp updateTime;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getAnimationID() {
        return animationID;
    }

    public void setAnimationID(int animationID) {
        this.animationID = animationID;
    }

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
}

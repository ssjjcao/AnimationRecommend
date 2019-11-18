package animation_recommend_backend.entity;

import animation_recommend_backend.entity.combineKey.AttitudeKey;

import javax.persistence.*;

@Entity
@Table(name = "attitude")
@IdClass(AttitudeKey.class)
public class Attitude {
    @Id
    @Column(name = "userID")
    private int userID;
    @Id
    @Column(name = "animationID")
    private int animationID;
    @Column(name = "favorite")
    private boolean favorite;

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

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
}

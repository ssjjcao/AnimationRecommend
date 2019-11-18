package animation_recommend_backend.entity.combineKey;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CommentKey implements Serializable {
    @Column(name = "userID")
    private int userID;

    @Column(name = "animationID")
    private int animationID;

    @Column(name = "comment")
    private int comment;
}

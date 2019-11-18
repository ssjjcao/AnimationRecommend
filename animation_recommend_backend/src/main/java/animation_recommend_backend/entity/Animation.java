package animation_recommend_backend.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "animation")
public class Animation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "recommendation")
    private String recommendation;
    @Column(name = "cover")
    private String cover;
    @Column(name = "detail")
    private String detail;
    @Column(name = "link")
    private String link;
    @Column(name = "pageView")
    private int pageView;
    @Column(name = "likeNum")
    private int likeNum;
    @Column(name = "unlikeNum")
    private int unlikeNum;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(name = "animation_type", joinColumns = @JoinColumn(name = "animationID")
            , inverseJoinColumns = @JoinColumn(name = "typeID"))
    private Set<Type> types = new HashSet<>();

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "referrerID")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "animation")
    private Set<Comment> comments = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "animation")
    private Set<Attitude> attitudes = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getPageView() {
        return pageView;
    }

    public void setPageView(int pageView) {
        this.pageView = pageView;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public int getUnlikeNum() {
        return unlikeNum;
    }

    public void setUnlikeNum(int unlikeNum) {
        this.unlikeNum = unlikeNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Type> getTypes() {
        return types;
    }

    public void setTypes(Set<Type> types) {
        this.types = types;
    }

    public void addType(Type type) {
        this.types.add(type);
    }

    public void removeType(Type type) {
        this.types.remove(type);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public void removeComment(Comment comment) {
        this.comments.remove(comment);
    }

    public Set<Attitude> getAttitudes() {
        return attitudes;
    }

    public void setAttitudes(Set<Attitude> attitudes) {
        this.attitudes = attitudes;
    }

    public void addAttitude(Attitude attitude) {
        this.attitudes.add(attitude);
    }

    public void removeAttitude(Attitude attitude) {
        this.attitudes.remove(attitude);
    }
}

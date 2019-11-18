package animation_recommend_backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "signature")
    private String signature;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(name = "user_type", inverseJoinColumns = @JoinColumn(name = "typeID", referencedColumnName = "id")
            , joinColumns = @JoinColumn(name = "userID", referencedColumnName = "id"))
    private Set<Type> types = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Animation> animations = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore//don't return password to frontend
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
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

    public Set<Animation> getAnimations() {
        return animations;
    }

    public void setAnimations(Set<Animation> animations) {
        this.animations = animations;
    }

    public void addAnimation(Animation animation) {
        this.animations.add(animation);
    }

    public void removeAnimation(Animation animation) {
        this.animations.remove(animation);
    }
}

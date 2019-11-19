package animation_recommend_backend.service;

import animation_recommend_backend.entity.User;

public interface UserService {

    User getUserByName(String name);

    void deleteUserById(Integer id);
}

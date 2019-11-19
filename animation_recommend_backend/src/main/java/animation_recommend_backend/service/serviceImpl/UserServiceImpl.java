package animation_recommend_backend.service.serviceImpl;

import animation_recommend_backend.entity.User;
import animation_recommend_backend.repository.UserRepository;
import animation_recommend_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByName(String name) {
        return this.userRepository.findByName(name);
    }

    @Override
    @Transactional
    public void deleteUserById(Integer id) {
        this.userRepository.deleteById(id);
    }


}

package animation_recommend_backend.service.serviceImpl;

import animation_recommend_backend.repository.AttitudeRepository;
import animation_recommend_backend.service.AttitudeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttitudeServiceImpl implements AttitudeService {
    @Autowired
    private AttitudeRepository attitudeRepository;
}

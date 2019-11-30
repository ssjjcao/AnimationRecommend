package animation_recommend_backend.securityUtils;

import lombok.Value;
import org.springframework.security.core.GrantedAuthority;

@Value
public class Authority implements GrantedAuthority {
    private String authority;
}

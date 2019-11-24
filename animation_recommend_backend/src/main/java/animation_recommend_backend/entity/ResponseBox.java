package animation_recommend_backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

@Value
public class ResponseBox {
    boolean result;
    String message;
}

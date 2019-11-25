package animation_recommend_backend.entity;

import lombok.Value;

@Value
public class ResponseDataBox {
    boolean result;
    String message;
    Object data;
}

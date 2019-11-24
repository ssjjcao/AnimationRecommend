package animation_recommend_backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

/**
 * 执行状态和返回信息的自定义包装体，
 */
@Value
public class ResponseBox {
    boolean result;
    String message;
}

package initiativep.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SendMessage {
    private String destination;
    private String content;
}

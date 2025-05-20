package initiativep.dto;

import lombok.Data;

@Data
public class MessageDto {
    private Long id;
    private Long sender_id;
    private Long receiver_id;
    private String content;


}

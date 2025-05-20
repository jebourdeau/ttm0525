package initiativep.dto;

import lombok.*;

@Data
public class ProjetDto {
    private Long id;
    private String title;
    private String description;
    private Long userId;

    public ProjetDto(){
    }
    public ProjetDto(Long id, String title, String description, Long userId){
        this.id = id;
        this.title = title;
        this.description = description;
        this.userId= userId;
    }

}

package initiativep.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
public class UploadDocumentDTO {
    private MultipartFile file;
    private String description;
}

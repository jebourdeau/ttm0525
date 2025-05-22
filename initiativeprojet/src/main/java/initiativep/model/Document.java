package initiativep.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "documents")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;
    private String fileType;
    private LocalDateTime uploadDate;

    public Document(String fileName, String fileType, LocalDateTime uploadDate) {
    this.fileName = fileName;
    this.fileType= fileType;
    this.uploadDate = uploadDate;
    }
}

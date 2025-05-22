package initiativep.services;

import initiativep.model.Document;
import initiativep.repository.DocumentRepository;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;


@Service
public class DocumentService {
    private DocumentRepository documentRepository;

    public String storeFile(MultipartFile file){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try{
        Path targetLocation = this.fileStorageLocation.resolve(fileName);
        Files.copy(file.getInputStream(), targetLocation,
                StandardCopyOption.REPLACE_EXISTING);
            Document doc = new Document(fileName, file.getContentType(), LocalDateTime.now());
            documentRepository.save(doc);
            return "File uploaded and metadata saved: " + fileName;
        }catch (IOException ex){
            throw new RuntimeException("Could not store file " + fileName, ex);
        }
    }
    private final Path fileStorageLocation =
            Paths.get("uploads").toAbsolutePath().normalize();

    public DocumentService(){
        try{
            Files.createDirectories(this.fileStorageLocation);
        }catch (Exception ex){
        throw new RuntimeException("Could not create upload directory", ex);
        }
    }
    public Resource loadFile(String fileName){
        Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
        return new FileSystemResource(filePath);
    }

}


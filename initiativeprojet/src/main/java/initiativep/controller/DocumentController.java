package initiativep.controller;

import initiativep.dto.DocumentDto;
import initiativep.model.Document;
import initiativep.services.DocumentService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@RestController
@RequestMapping("/documents")

public class DocumentController {
    private DocumentService documentService;

    public DocumentController(DocumentService documentService){
        this.documentService= documentService;
    }
    @PostMapping("/upload")
    public String uploadFile(@RequestParam('file'), MultipartFile file){
        return documentService.storeFile(file);
    }
    @GetMapping("/download/{filename: .+")
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename){
        Resource resource = documentService.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment, filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}

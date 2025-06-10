package initiativep.controller;

import initiativep.dto.UploadDocumentDTO;
import initiativep.model.Document;
import initiativep.model.User;
import initiativep.services.DocumentService;
import initiativep.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor

@RequestMapping("/documents")

public class DocumentController {
    private final DocumentService documentService;
    private final UserService userService;

    @GetMapping
    public String listDocuments(Model model) {
        List<Document> documents = documentService.findAll();
        model.addAttribute("documents", documents);
        return "pages/documents/list";
    }

    @GetMapping("/upload")
    public String showUploadForm(Model model) {
        model.addAttribute("document", UploadDocumentDTO.builder().build());
        return "pages/documents/upload";
    }

    @PostMapping("/upload")
    public String uploadDocument(@ModelAttribute UploadDocumentDTO uploadDocument, Authentication auth) throws IOException {
        User user = userService.findByUsername("").orElseThrow(()-> new RuntimeException("User not found"));

        MultipartFile file = uploadDocument.getFile();
        String description = uploadDocument.getDescription();
        Document document = Document.builder()
                .filename(file.getOriginalFilename())
                .contentType(file.getContentType())
                .data(file.getBytes())
                .description(description)
                .user(toString())
                .build();
        documentService.saveDocument(document);
        return "redirect:/documents";
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadDocument(@PathVariable String id) {
        Document document = documentService.findById(id).orElseThrow(() -> new RuntimeException("Document not found"));
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=\"" + document.getFilename() + "\"")
                .contentType(MediaType.parseMediaType(document.getContentType()))
                .body(document.getData());
    }

    @PostMapping("/delete/{id}")
    public String deleteDocument(@PathVariable String id) {
        documentService.deleteDocument(id);
        return "redirect:/documents";
    }
}

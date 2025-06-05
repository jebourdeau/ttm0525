package initiativep.services;

import initiativep.model.Document;

import java.util.List;
import java.util.Optional;


public interface DocumentService {
    Document saveDocument(Document document);
    Optional<Document> findById(Long id);
    List<Document> findAll();
    List<Document> findByUserId(Long userId);
    void deleteDocument(Long id);

}


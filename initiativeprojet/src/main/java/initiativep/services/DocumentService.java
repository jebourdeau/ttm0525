package initiativep.services;

import initiativep.model.Document;

import java.util.List;
import java.util.Optional;


public interface DocumentService {
    Document saveDocument(Document document);
    Optional<Document> findById(String id);
    List<Document> findAll();
    List<Document> findByUser(String userId);
    void deleteDocument(String id);

}


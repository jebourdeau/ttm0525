package initiativep.services.imp;


import initiativep.model.Document;
import initiativep.repository.jpa.DocumentRepository;
import initiativep.services.DocumentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentServiceImpl implements DocumentService {
    private final DocumentRepository documentRepository;
    public DocumentServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }
    @Override
    public Document saveDocument(Document document) {
        return documentRepository.save(document);
    }
    @Override
    public Optional<Document> findById(String id) {
        return documentRepository.findById(id);
    }
    @Override
    public List<Document> findAll() {
        return documentRepository.findAll();
    }
    @Override
    public List<Document> findByUser(String user) {
        return documentRepository.findByUser(user);
    }
    @Override
    public void deleteDocument(String id) {
        documentRepository.deleteById(id);
    }
}
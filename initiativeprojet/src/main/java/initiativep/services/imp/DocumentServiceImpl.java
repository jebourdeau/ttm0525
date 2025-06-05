package initiativep.services.imp;


import initiativep.model.Document;
import initiativep.repository.DocumentRepository;
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
    public Optional<Document> findById(Long id) {
        return documentRepository.findById(id);
    }
    @Override
    public List<Document> findAll() {
        return documentRepository.findAll();
    }
    @Override
    public List<Document> findByUserId(Long userId) {
        return documentRepository.findByUserId(userId);
    }
    @Override
    public void deleteDocument(Long id) {
        documentRepository.deleteById(id);
    }
}
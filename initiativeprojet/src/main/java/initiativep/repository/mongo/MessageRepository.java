//package initiativep.repository.mongo;
//
//import initiativep.model.Message;
//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.stereotype.Repository;
//
//public interface MessageRepository extends MongoRepository<Message, String> {
//    String findBySender(String sender);
//    String findByReceiver(String receiver);
//    String findByMessage(String message);
//    String findByTimestamp(String timestamp);
//}
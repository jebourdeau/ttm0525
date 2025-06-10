//package initiativep.services;
//
//import initiativep.dto.MessageDto;
//import initiativep.model.Message;
//import initiativep.repository.mongo.MessageRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//public class MessageService {
//
//    @Autowired
//    private MessageRepository messageRepository;
//
//    public List<MessageDto> getAllMessages() {
//        return messageRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
//    }
//
//    public MessageDto getMessageById(String id) {
//        Optional<Message> message = messageRepository.findById(id);
//        return message.map(this::convertToDto).orElse(null);
//    }
//
//    public MessageDto createMessage(MessageDto messageDto) {
//        Message message = convertToEntity(messageDto);
//        message = messageRepository.save(message);
//        return convertToDto(message);
//    }
//
//    public void deleteMessage(String id) {
//        messageRepository.deleteById(id);
//    }
//
//    private MessageDto convertToDto(Message message) {
//        MessageDto dto = new MessageDto();
//        dto.setId(message.getId());
//        dto.setSender_id(message.getSender_id());
//        dto.setReceiver_id(message.getReceiver_id());
//        dto.setContent(message.getContent());
//        return dto;
//    }
//
//    private Message convertToEntity(MessageDto dto) {
//        Message message = new Message();
//        message.setId(dto.getId());
//        message.setSender_id(dto.getSender_id());
//        message.setReceiver_id(dto.getReceiver_id());
//        message.setContent(dto.getContent());
//        return message;
//    }
//}

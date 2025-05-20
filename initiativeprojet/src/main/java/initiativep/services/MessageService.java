package initiativep.services;

import initiativep.dto.MessageDto;
import initiativep.model.Message;
import initiativep.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<MessageDto> getAllMessages(){
        return messageRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }
    public MessageDto getMessageById(Long id){
    return messageRepository.findById(id).map(this::convertToDto).orElse(null);
    }
    public MessageDto createMessage(MessageDto messageDto){
        Message message = convertToEntity(messageDto);
        message = messageRepository.save(message);
        return convertToDto(message);
    }
    public void deleteMessage(Long id){
        messageRepository.deleteById(id);
    }
    private MessageDto convertToDto(Message message){
        MessageDto messageDto = new MessageDto();
        messageDto.setId(message.getId());
        messageDto.setSender_id(message.getSender_id());
        messageDto.setReceiver_id(message.getReceiver_id());
        messageDto.setContent(message.getContent());
        return messageDto;
    }
    private Message convertToEntity(MessageDto messageDto){
        Message message = new Message();
        message.setId(messageDto.getId());
        message.setSender_id(messageDto.getSender_id());
        message.setReceiver_id(messageDto.getReceiver_id());
        message.setContent(messageDto.getContent());
        return message;
    }


}

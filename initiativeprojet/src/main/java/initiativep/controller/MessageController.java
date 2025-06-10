//package initiativep.controller;
//
//import initiativep.dto.MessageDto;
//import initiativep.services.MessageService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/messages")
//public class MessageController {
//    @Autowired
//    private MessageService messageService;
//
//    @GetMapping
//    public List<MessageDto> getAllMessages() {
//        return messageService.getAllMessages();
//    }
//    @GetMapping("/{id}")
//    public MessageDto getMessageById(@PathVariable String id) {
//        return messageService.getMessageById(id);
//    }
//    @PostMapping
//    public MessageDto createMessage(@RequestBody MessageDto messageDto) {
//        return messageService.createMessage(messageDto);
//    }
//    @DeleteMapping("/{id}")
//    public void deleteMessage(@PathVariable String id) {
//        messageService.deleteMessage(id);
//    }
//}

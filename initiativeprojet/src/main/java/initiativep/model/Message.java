//package initiativep.model;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.NonNull;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Document(collection ="messages")
//public class Message {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private String id;
//    private Long sender_id;
//    private Long receiver_id;
//
//    @ManyToOne
//    @NonNull
//    @JoinColumn(name = "owner")
//    private User owner;
//
//    @Column(columnDefinition = "TEXT")
//    private String content;
//
//    @Column(name = "is_draft")
//    private Boolean isDraft = false;
//
//    public void setReceiver_id(Long receiver_id) {
//        this.receiver_id = receiver_id;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//}

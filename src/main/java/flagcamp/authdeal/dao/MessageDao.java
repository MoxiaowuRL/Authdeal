package flagcamp.authdeal.dao;

import flagcamp.authdeal.entity.*;
import flagcamp.authdeal.repository.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MessageDao {

  @Autowired
  MessagesRepository messagesRepository;

  public Messages createMsg(Messages message) {
    return messagesRepository.save(message);
  }

  public Messages findMsgById(int messageId) {
    return messagesRepository.findById(messageId).get();
  }


  public List<Messages> FindAllMassageByUser(String userId){
    List<Messages> ret = new ArrayList<>();
    for(Messages messages : messagesRepository.findAllMessagesOfUser(userId)){
      ret.add(messages);
    }
    Collections.sort(ret, new Comparator<Messages>() {
      @Override
      public int compare(Messages o1, Messages o2) {
        return o2.getTimes().compareTo(o1.getTimes());
      }
    });
    return ret;
  }

  public List<Messages> findMsgByUser(String userName) {
    List<Messages> result = new ArrayList<>();
    for (Messages msg : messagesRepository.findAll()) {
      if (msg.getTo().getUserName().toLowerCase().equals(userName.toLowerCase())) {
        result.add(msg);
      }
    }
    result.sort(new Comparator<Messages>() {
      @Override
      public int compare(Messages o1, Messages o2) {
        return o1.getTimes().compareTo(o2.getTimes());
      }
    });
    return result;
  }

  public List<Messages> findMsgByReceiverAndSender(String sender, String receiver) {
    List<Messages> result = new ArrayList<>();
    for (Messages msg : messagesRepository.findAll()) {
      if (msg.getTo().getUserName().toLowerCase().equals(receiver.toLowerCase())
          && msg.getFrom().getUserName().toLowerCase().equals(sender.toLowerCase())) {
        result.add(msg);
      }
    }
    result.sort(new Comparator<Messages>() {
      @Override
      public int compare(Messages o1, Messages o2) {
        return o1.getTimes().compareTo(o2.getTimes());
      }
    });
    return result;
  }

  public List<Messages> findAllMsgs() {
    List<Messages> result = new ArrayList<>();
    for (Messages msg : messagesRepository.findAll()) {
      result.add(msg);
    }
    result.sort(new Comparator<Messages>() {
      @Override
      public int compare(Messages o1, Messages o2) {
        return o1.getMessageId() - o2.getMessageId();
      }
    });
    return result;
  }
}

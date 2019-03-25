package userTest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import userTest.dao.MessageDAO;
import userTest.data.Message;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class MessageService {

    private static final Logger LOG = LoggerFactory.getLogger(MessageService.class);

    private static final Integer ADMIN = 2;
    private static final Integer MANAGER = 1;
    private static final Integer STANDARD = 0;

    @Inject
    private MessageDAO messageDAO;

    public List<Message> getMessageForGroup(Integer userRole){
        if(userRole==ADMIN){
           return messageDAO.findByGroup("admin");
        }else if (userRole==MANAGER){
            return messageDAO.findByGroup("manager");
        }else if(userRole==STANDARD){
            return messageDAO.findByGroup("standard");
        }else{
            return null;
        }
    }


}

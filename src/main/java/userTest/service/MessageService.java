package userTest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import userTest.dao.MessageDAO;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class MessageService {
    private static final Logger LOG = LoggerFactory.getLogger(MessageService.class);

    @Inject
    private MessageDAO messageDAO;

    public List<>



}

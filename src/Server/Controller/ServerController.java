package Server.Controller;

import java.util.LinkedList;

import Server.DTO.ClientMessageDTO;
import Server.DTO.CommandMessageDTO;
import Server.DTO.MessageDTO;
import Server.Integration.ClientHandler;
import Server.Integration.HandlerCreator;
import Server.Integration.MorseMateHandler;
import Server.Model.MessageHandler;

public class ServerController {
    MessageHandler messageHandler;
    ClientHandler clientHandler;
    MorseMateHandler morseMateHandler;

    public ServerController(HandlerCreator handler) {
        this.messageHandler = handler.getMessageHandler();
        this.clientHandler = handler.getClientHandler();
        this.morseMateHandler = handler.getMorseMateHandler();
    }

    /**
     * Lets the Message Handler know the message is read.
     */
    public void messageIsRead() {
        messageHandler.removeRead();
    }

    /**
     * Adds message to messageHandler
     * 
     * @param msg clientMessageDTO from clientHandler.
     */
    public void addMessage(ClientMessageDTO msg) {
        messageHandler.addMessage(msg);
    }

    /**
     * Fetches the command message from messageHandler.
     * 
     * @param cmd String representation
     */
    public CommandMessageDTO fetchCommandMessage(String cmd) {
        return messageHandler.fetchCommandMessage(cmd);
    }

    /**
     * Fetches the message list
     * 
     * @return messageList containing messageDTO
     */
    public LinkedList<MessageDTO> fetchMessageList() {
        return messageHandler.fetchMessageList();
    }

}
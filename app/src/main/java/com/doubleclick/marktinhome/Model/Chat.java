package com.doubleclick.marktinhome.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created By Eslam Ghazy on 3/17/2022
 */
@Entity
public class Chat {

    @PrimaryKey(autoGenerate = true)
    private int primaryKey;
    private String message;
    private String type;
    private String sender;
    private String receiver;
    private long date;
    private String id;
    private String StatusMessage;
    private boolean seen;

    public Chat() {
    }

    public Chat(String message, String type, String sender, String receiver, long date, String id, String statusMessage, boolean seen) {
        this.message = message;
        this.type = type;
        this.sender = sender;
        this.receiver = receiver;
        this.date = date;
        this.id = id;
        StatusMessage = statusMessage;
        this.seen = seen;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "message='" + message + '\'' +
                ", type='" + type + '\'' +
                ", sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                ", date=" + date +
                ", id='" + id + '\'' +
                '}';
    }

    public String getStatusMessage() {
        return StatusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        StatusMessage = statusMessage;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public int getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(int primaryKey) {
        this.primaryKey = primaryKey;
    }
}

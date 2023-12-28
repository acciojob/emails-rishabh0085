package com.driver;

import java.util.*;

public class Gmail extends Email {

    private int inboxCapacity;
    private Queue<Mail> inbox;
    private Queue<Mail> trash;

    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity = inboxCapacity;
        this.inbox = new LinkedList<>();
        this.trash = new LinkedList<>();
    }

    public void receiveMail(Date date, String sender, String message) {
        if (inbox.size() == inboxCapacity) {
            trash.add(inbox.poll()); // Move the oldest mail to trash if inbox is full
        }
        inbox.add(new Mail(date, sender, message));
    }

    public void deleteMail(String message) {
        Iterator<Mail> iterator = inbox.iterator();
        while (iterator.hasNext()) {
            Mail mail = iterator.next();
            if (mail.getMessage().equals(message)) {
                trash.add(mail);
                iterator.remove();
                break;
            }
        }
    }

    public String findLatestMessage() {
        return inbox.isEmpty() ? null : inbox.peek().getMessage();
    }

    public String findOldestMessage() {
        return inbox.isEmpty() ? null : ((LinkedList<Mail>) inbox).getLast().getMessage();
    }

    public int findMailsBetweenDates(Date start, Date end) {
        int count = 0;
        for (Mail mail : inbox) {
            if (mail.getDate().compareTo(start) >= 0 && mail.getDate().compareTo(end) <= 0) {
                count++;
            }
        }
        return count;
    }

    public int getInboxSize() {
        return inbox.size();
    }

    public int getTrashSize() {
        return trash.size();
    }

    public void emptyTrash() {
        trash.clear();
    }

    public int getInboxCapacity() {
        return inboxCapacity;
    }

    private static class Mail {
        private Date date;
        private String sender;
        private String message;

        public Mail(Date date, String sender, String message) {
            this.date = date;
            this.sender = sender;
            this.message = message;
        }

        public Date getDate() {
            return date;
        }

        public String getMessage() {
            return message;
        }
    }
}

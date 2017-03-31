package org.arip;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Arip Hidayat on 3/31/2017.
 */
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id = UUID.randomUUID().toString();
    private String content;

    public Message() {}

    public Message(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

package org.example.pojo;

public abstract class WebsocketMessage {
    String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

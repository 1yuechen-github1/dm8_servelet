package org.example.pojo;

public class InitMessage<T> extends WebsocketMessage{
    private String resource;

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    private T message;

    public InitMessage(String resource, T message) {
        this.resource = resource;
        this.message = message;
    }

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }

    public InitMessage(String type, String resource, T message) {
        this.type = type;
        this.resource = resource;
        this.message = message;
    }

}

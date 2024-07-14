package org.example.pojo;

public class Directory {
    private String name;
    private Boolean isFile = false;

    public Directory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Directory{" +
                "name='" + name + '\'' +
                ", isFile=" + isFile +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getFile() {
        return isFile;
    }

    public void setFile(Boolean file) {
        isFile = file;
    }

    public Directory(String name, Boolean isFile) {
        this.name = name;
        this.isFile = isFile;
    }
}

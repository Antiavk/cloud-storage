package com.cloudstorage.storage.models;

import lombok.Data;

@Data
public class File {

    private String filename;
    private long size;

    public File(String name, long size) {
        this.filename = name;
        this.size = size;
        System.out.println(name + " " + size);
    }
}

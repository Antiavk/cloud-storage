package com.cloudstorage.storage.models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Files")
public class FilesTable {

    public FilesTable() {}

    public FilesTable(String userDir, String filename, long size) {
        this.userDir = userDir;
        this.filename = filename;
        this.size = size;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "user_dir")
    private String userDir;
    @Column
    private String filename;
    @Column
    private long size;
}

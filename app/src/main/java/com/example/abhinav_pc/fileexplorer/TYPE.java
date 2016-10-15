package com.example.abhinav_pc.fileexplorer;


/**
 * Created by AbHiNav-PC on 25-Sep-16.
 */
public class TYPE {
    Boolean isFolder;
    String Name;
    String path;
    boolean isFavorite;
    TYPE(Boolean isFolder,String Name,String path){
        this.isFolder=isFolder;
        this.Name =Name;
        this.path=path;
        this.isFavorite= false;
    }
}

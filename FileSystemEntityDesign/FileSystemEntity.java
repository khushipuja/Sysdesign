package FileSystemEntityDesign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class FileSystemEntity {

    private String name;
    private boolean isFile;
    private String content;
    private Map<String,FileSystemEntity> children;

    public FileSystemEntity(String name, boolean isFile) {
        this.name = name;
        this.isFile = isFile;
        this.content = null;
        this.children = new HashMap<String,FileSystemEntity>();
    }

    public boolean getIsFile() {
        return isFile;
    }

    public String getName(){
      return name;
    }

    public Map<String, FileSystemEntity> getChildren(){
        return this.children
    }

    public FileSystemEntity search(String path){
        List<FileSystemEntity> result = new ArrayList<FileSystemEntity>();
        FileSystemEntity current = this;
        String[] paths = path.split("/");
        for(String p : paths){
            if(children.containsKey(p)){
                current = children.get(p);
            }else{
                return null;
            }
        }
        return current;
    }

    public void insert(String path,boolean isFile){
        FileSystemEntity current = this;
        String[] paths = path.split("/");
        for(String p : paths){
            if(children.containsKey(p)){
                current = children.get(p);
            }else{
                Directory newDir = new Directory(p);
                current.children.put(p, newDir);
                current = newDir;
            }
        }
        if(isFile){
            current.isFile = true;
            current.content = paths[paths.length-1];
        }
    }
}

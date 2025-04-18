package FileSystemEntityDesign;

import java.util.List;
import java.util.Map;

public class FileSystemEntityManager {

    FileSystemEntity root;

    public FileSystemEntityManager() {
        root = new Directory("root");
    }

    public void ls(String path){

        String[] paths = path.split("/");
        FileSystemEntity result = root.search(path);

        List<FileSystemEntity> children_result = result.getChildren().values().stream().toList();

        for(FileSystemEntity node : children_result){
            if(node.getIsFile()){
                System.out.println("ls result for " + path + " is " + node.getName());
            }else{
                Map<String, FileSystemEntity> children = node.getChildren();
                System.out.println("ls result for " + path + " is  directory with contents :  " + node.getName());

                for(String  childrenName : children.keySet()){
                  System.out.println("name : " + childrenName);
                }

            }
        }
    }

    public void mkdir(String path,boolean isFile){
        root.insert(path,isFile);
    }
}

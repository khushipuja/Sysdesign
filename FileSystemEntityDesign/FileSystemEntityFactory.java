package FileSystemEntityDesign;

public class FileSystemEntityFactory {

    public static FileSystemEntity createFileSystemEntity(FileType fileType,String name) {

        switch (fileType) {
            case DIRECTORY: return new Directory(name);
            case FILE: return new File(name );
            default: return null;
        }

    }
}

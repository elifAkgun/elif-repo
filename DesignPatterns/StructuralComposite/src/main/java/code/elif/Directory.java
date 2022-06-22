package code.elif;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Composite in the composite pattern
public class Directory extends File {

   ArrayList<File> files;

    public Directory(String name) {
        super(name);
        this.files = new ArrayList<>();
    }

    @Override
    public void ls() {
        System.out.println(getName());
        files.forEach(File::ls);
    }

    @Override
    public void addFile(File file) {
        files.add(file);
    }

    @Override
    public File[] getFiles() {
        return (File[]) files.toArray();
    }

    @Override
    public boolean removeFile(File file) {
        return files.remove(file);
    }
}

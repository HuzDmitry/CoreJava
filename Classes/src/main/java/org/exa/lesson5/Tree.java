package org.exa.lesson5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Tree {

    public static void main(String[] args) {
        backupFiles("./Igra");
        print(new File("./Igra"), "", true);
    }

    /**
     * метод вывода в консоль дерева директорий и файлов
     * @param file
     * @param indent
     * @param isLast
     */
    public static void print(File file, String indent, boolean isLast){
        System.out.print(indent);
        if (isLast){
            System.out.print("└─");
            indent += "  ";
        }
        else{
            System.out.print("├─");
            indent += "│ ";
        }
        long sizeFile;
        if(file.isFile()) {
            sizeFile = file.length();
            System.out.printf("%s : %d (byte)\n",file.getName(), sizeFile);
        }else
            System.out.println(file.getName());

        File[] files = file.listFiles();
        if (files == null)
            return;

//        int subDirTotal = 0;
//        for (int i = 0; i < files.length; i++){
//            if (files[i].isDirectory())
//                subDirTotal++;
//        }

        int subDirCounter = 0;
        for (int i = 0; i < files.length; i++){
            subDirCounter++;
            print(files[i], indent, subDirCounter == files.length);

//            if (files[i].isDirectory()){
//                subDirCounter++;
//                print(files[i], indent, subDirCounter == subDirTotal);
//            }
        }

    }
    public static void backupFiles(String path){
        File files = new File(path);
        String newPath = path + "/backup";
        if (files.isDirectory()){
            File filebackup = new File(newPath);
            boolean created;
            if (filebackup.isDirectory())
                created = true;
            else
                created = filebackup.mkdir();
            if (created){
                File[]fileList = files.listFiles();
                String[] nameFileList = files.list();
                for (int i = 0; i<fileList.length; i++){
                    if (fileList[i].isFile()){
                        try {
                            Files.copy(fileList[i].toPath(),
                                    new File( newPath+"/"+nameFileList[i]).toPath());
                        } catch (IOException e) {
                            e.getStackTrace();
                        }
                    }
                }
            }else
                System.out.println("не удалось создать резервную директорию.");
        }else
            System.out.println("это не директория");
    }

}

package spbstu;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String from =  in.nextLine();
        String to =  in.nextLine();
        copyFile(from, to);
    }
    public static void copyFile( String from, String to ) throws IOException {

        File src = new File(from);
        File dest = new File(to);

        if(Files.exists(src.toPath())){
            if(!Files.exists(dest.toPath())) {
                Files.copy(src.toPath(), dest.toPath());
            }
            else {
                System.out.println("Have same file");
            }
        }
        else{
            System.out.println("Haven't source file");
        }
    }
}


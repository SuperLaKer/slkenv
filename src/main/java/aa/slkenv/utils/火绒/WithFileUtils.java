package aa.slkenv.utils.火绒;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Collection;

public class WithFileUtils {
    public static void main(String[] args) {
        String[] extensions = {"exe"};
        Collection<File> files = FileUtils.listFiles(new File("E:\\Program Files\\2345Soft"), extensions, true);
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
    }
}

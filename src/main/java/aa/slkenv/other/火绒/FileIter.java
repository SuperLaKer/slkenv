package aa.slkenv.other.火绒;

import com.alibaba.fastjson.JSON;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileIter {


    public static void main(String[] args) {
        List<DATA> tempList = new ArrayList<DATA>();
        List<DATA> dataList = getFiles("D:\\Program Files\\2345Soft", tempList);
        NetStruct netStruct = new NetStruct(dataList);
        String jsonString = JSON.toJSONString(netStruct);
        System.out.println(jsonString);
    }

    public static List<DATA> getFiles(String filePath, List<DATA> dataList) {
        // 不为空
        if (filePath == null) return null;
        File file = new File(filePath);
        if (!file.exists()) return null;

        // 文件夹
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null && files.length > 0) {
                for (File temp : files) {
                    getFiles(temp.getAbsolutePath(), dataList);
                }
            }
        } else {
            if (file.getAbsolutePath().endsWith(".exe")) {
                DATA data = new DATA(file.getAbsolutePath());
                dataList.add(data);
            }
        }
        return dataList;
    }
}

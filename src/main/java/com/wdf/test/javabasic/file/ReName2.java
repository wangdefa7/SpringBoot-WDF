package com.wdf.test.javabasic.file;

import java.io.File;

/**
 * 修改文件下面所有文件名字为 1，2，3，，，4
 */
public class ReName2 {

    public static void main(String[] args) {
        updateFileNames("F:\\多媒体\\视频\\短视频\\美甲\\小视频\\美甲");
    }

    public static void updateFileNames(String url) {
        //获取文件所在目录
        File file = new File(url);
        // 获取文件夹绝对路径
        String path = file.getAbsolutePath();
        // 判断文件目录是否存在，且是文件目录，非文件
        if (file.exists() && file.isDirectory()) {
            // 遍历文件夹下的所有文件
            File[] childFiles = file.listFiles();
            for (int i = 0; i < childFiles.length; i++) {
                File file2 = childFiles[i];
                if (file2.isFile()) {
                    String oldName = file2.getName();
                    String newName=i+".mp4";
                    oldName.replace(oldName, newName);
                    file2.renameTo(new File(path + "\\" + newName));
                    System.out.println(oldName+"完成了！");
                }
            }
        }
    }

}

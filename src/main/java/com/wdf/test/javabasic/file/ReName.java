package com.wdf.test.javabasic.file;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * 修改文件名字
 */
public class ReName extends JFrame{


        public static void main(String[] args) {
            new ReName("输入路径");
            //updateFileNames("F:\\多媒体\\视频\\短视频\\美甲\\4.2");

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
                        String newName=oldName+".mp4";
                        oldName.replace(oldName, newName);
                        file2.renameTo(new File(path + "\\" + newName));
                        System.out.println("完成了！");
                    }
                }
            }
        }

    public ReName(String title)
    {
        JFrame jf = new JFrame(title);
        jf.setLayout(new FlowLayout());
        Container conn = jf.getContentPane();    //得到窗口的容器
        JLabel L1 = new JLabel("输入路径");    //创建一个标签 并设置初始内容
        JButton btn = new JButton("确定");
        JTextField txt = new JTextField(30);

        txt.setEditable(true);
        conn.add(L1);
        conn.add(txt);
        conn.add(btn);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("点击按钮");
                String path = txt.getText();
                System.out.println(path);
                updateFileNames(path);
                txt.setText("成功了！");
            }
        });

        jf.setBounds(500,500,500,500); //设置窗口的属性 窗口位置以及窗口的大小
        jf.setVisible(true);//设置窗口可见
        jf.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //设置关闭方式 如果不设置的话 似乎关闭窗口之后不会退出程序


    }

}


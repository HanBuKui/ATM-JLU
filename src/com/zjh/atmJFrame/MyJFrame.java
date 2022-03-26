package com.zjh.atmJFrame;


import com.zjh.bank.ATM;

import javax.swing.*;
import java.awt.*;

//自己创造的界面的父类
public class MyJFrame extends JFrame {
    //设置字体供子类使用
    public static final Font FONT_SIZE_10 = new Font("宋体",Font.PLAIN,18);
    public static final Font FONT_SIZE_20 = new Font("宋体",Font.PLAIN,20);
    public static final Font FONT_SIZE_25 = new Font("宋体",Font.PLAIN,25);
    //给一个静态公共不可改变的ATM对象作为属性，供子类使用
    public static final ATM atm = new ATM();
    //创建窗体
    public MyJFrame(String title){
        super(title);
        //设置窗体不可改变
        setResizable(false);
        //设置窗体大小
        setSize(600,600);
        //设置窗体居中
        setLocationRelativeTo(null);
    }
    //无参构造，创建无标题窗体
    public MyJFrame(){
        this("");
    }
    //设置弹窗方法供子类使用（传入字符串并显示出）
    protected void showMessageDialog(String str){
        JOptionPane.showMessageDialog(this,str);
    }
}


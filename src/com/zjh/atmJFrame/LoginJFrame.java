package com.zjh.atmJFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//登录界面继承MyJFrame
public class LoginJFrame extends MyJFrame {
    public LoginJFrame(){
        super("欢迎使用ATM机");
        //设置窗体可关闭
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置组件
        init();
        //界面可视化
        setVisible(true);
    }
    //初始化界面
    private void init(){
        //创建面板对象，并定义为空布局
        JPanel jp = new JPanel(null);
        //添加标签
        JLabel jl1 = new JLabel("账号：");
        JLabel jl2 = new JLabel("密码：");
        //设置标签字体
        jl1.setFont(FONT_SIZE_20);
        jl2.setFont(FONT_SIZE_20);
        //设置标签在面板中的位置
        jl1.setBounds(100,100,70,70);
        jl2.setBounds(100,250,70,70);
        //添加文本框
        final JTextField jtf = new JTextField(20);
        //添加密码文本框
        final JPasswordField jpf = new JPasswordField(20);
        //设置文本框位置
        jtf.setBounds(200,115,200,40);
        jpf.setBounds(200,265,200,40);
        //添加按钮
        JButton jb = new JButton("登录");
        //设置按钮文字大小
        jb.setFont(FONT_SIZE_20);
        //设置按钮位置及大小
        jb.setBounds(250,400,100,50);
        //设置面板背景颜色
        jp.setBackground(Color.YELLOW);
        //内部类进行事件处理
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取输入的账号和密码
                String userName = jtf.getText();
                String userPassword = new String(jpf.getPassword());
                //验证是否正确
                boolean aBoolean = atm.login(userName,userPassword);
                if(aBoolean){
                    //登录成功
                    dispose();//关闭登录界面
                    //打开功能界面
                    new WorkingJFrame();
                }
                else
                    showMessageDialog("账号或密码错误");//调用父类弹窗方法
            }
        });
        //添加组件
        jp.add(jl1);
        jp.add(jtf);
        jp.add(jl2);
        jp.add(jpf);
        jp.add(jb);
        //窗体添加面板
        add(jp);
    }
    public static void main(String[] args) {
        new LoginJFrame();//先创建登录界面
    }
}


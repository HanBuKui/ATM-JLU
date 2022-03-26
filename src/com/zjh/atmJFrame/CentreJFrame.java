package com.zjh.atmJFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//中间窗口，存钱、取钱、转账、修改密码界面的父类
public class CentreJFrame extends MyJFrame {
    //空布局面板，自己设置组件位置及大小
    protected JPanel jp = new JPanel(null);
    //输入金额标签
    protected JLabel jl = new JLabel("请输入金额：");
    //输入金额文件框
    protected JTextField jtf = new JTextField(20);
    //确认、取消按钮
    protected JButton jb1 = new JButton("确认");
    protected JButton jb2 = new JButton("取消");

    //转账时转账账号标签
    protected JLabel jLabel = new JLabel("请输入转账账号：");
    //转账时转账账号文本框
    protected JTextField jTextField = new JTextField(20);

    //修改密码时新密码标签
    protected JLabel jLabelCP = new JLabel("请输入新密码(只能为数字)：");
    //修改密码时新密码文本框
    protected JTextField jTextFieldCP = new JTextField(20);

    //提醒用户输入金额为100的倍数
    private JLabel jle = new JLabel("( 提示：只能输入100的倍数 )");

    public CentreJFrame(String str){
        super(str);
        //判断要进行的操作
        if(str.equals("转账"))
            init1();
        else if(str.equals("修改密码"))
            init2();
        else
            init();
        one();//最后调用共有
    }
    //取钱和取钱特有组件
    private void init(){
        //输入金额标签，设置字体，位置及大小
        jl.setFont(FONT_SIZE_25);
        jl.setBounds(100,100,200,100);
        //输入金额文本框
        jtf.setBounds(300,250,200,50);
        //添加输入金额标签和输入金额文本框
        jp.add(jl);
        jp.add(jtf);
        setJLE();
    }
    //转账特有组件
    private void init1(){
        init();
        //输入账户标签
        jLabel.setFont(FONT_SIZE_25);
        jLabel.setBounds(100,10,200,40);
        //输入账户文本
        jTextField.setBounds(300,80,200,50);
        //添加输入账户标签和输入账户文本
        jp.add(jLabel);
        jp.add(jTextField);
    }
    //修改密码特有组件
    private void init2(){
        //输入新密码标签
        jLabelCP.setFont(FONT_SIZE_25);
        jLabelCP.setBounds(50,100,400,70);
        //输入新密码文本框
        jTextFieldCP.setBounds(300,215,200,40);
        //添加输入新密码标签和输入新密码文本框
        jp.add(jLabelCP);
        jp.add(jTextFieldCP);
    }
    //共有组件及操作
    private void one(){
        //按钮设置
        jb1.setFont(FONT_SIZE_20);
        jb2.setFont(FONT_SIZE_20);
        jb1.setBounds(300,350,100,50);
        jb2.setBounds(450,350,100,50);
        jp.add(jb1);
        jp.add(jb2);
        jp.setBackground(Color.GREEN);
        jb1.addActionListener(listener);
        jb2.addActionListener(listener);
        //添加到窗体
        add(jp);
        setVisible(true);
    }

    //设置提示
    private void setJLE(){
        jle.setFont(FONT_SIZE_10);
        jle.setBounds(100,180,300,50);
        jp.add(jle);
    }

    //创建监听器
    private ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {//按钮被点击后
            String actionCommand = e.getActionCommand();//获取按钮上的字
            switch(actionCommand){
                case "确认":
                    change();
                    break;
                case "取消":
                    new WorkingJFrame();//创建功能界面
                    dispose();//关闭此界面
                    break;
            }
        }
    };
    //点击确认按钮执行的操作，子类重写覆盖实现各自功能
    protected void change(){
    }

    //正则表达式判断输入是否为数字
    protected boolean isNumber(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if(!isNum.matches())
            return false;
        return true;
    }
}


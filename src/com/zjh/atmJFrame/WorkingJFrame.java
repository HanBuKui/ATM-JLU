package com.zjh.atmJFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//功能界面
public class WorkingJFrame extends MyJFrame {
    public WorkingJFrame(){
        super("功能界面");
        init();
        setVisible(true);
    }
    //初始化功能界面
    private void init(){
        //设置第一个面板对象
        JPanel jp1 = new JPanel();
        //创建标签，将标签添加到第一个面板上
        JLabel jb = new JLabel("请选择要进行的操作：");
        jb.setFont(FONT_SIZE_25);//设置标签字体大小
        jp1.add(jb);
        jp1.setBackground(Color.CYAN);
        //将第一个面板添加到窗体上方（JFrame窗体是边界布局）
        add(jp1, BorderLayout.NORTH);

        //创建第二个面板对象（空布局，自己设置按钮位置及大小），然后将按钮添加
        JPanel jp2 = new JPanel(null);
        //字符串数组存储各个按钮名字，然后循环设置按钮名字
        String[] str = {"1、余额查询","2、取钱","3、存钱","4、转账","5、修改密码","6、退出系统"};
        //int二维数组储存各个按钮位置及大小信息，循环设置
        int[][] xy = new int[][]{{50,100,200,50},{350,100,200,50},{50,200,200,50},{350,200,200,50},{50,300,200,50},{350,300,200,50}};
        for(int i = 0;i < str.length;i ++){
            JButton jButton = new JButton(str[i]);//创建按钮
            jButton.setFont(FONT_SIZE_20);//设置按钮字体大小
            jButton.setBounds(xy[i][0],xy[i][1],xy[i][2],xy[i][3]);//设置按钮位置及大小
            jButton.addActionListener(listener);//按钮注册监听器
            jp2.add(jButton);//将按钮添加
        }
        //设置jp2背景颜色
        jp2.setBackground(Color.GRAY);
        //将第二个面板添加到窗体(JFrame窗体中间)
        add(jp2);
    }
    //创建事件监听器
    private ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String actionCommand = e.getActionCommand();//获取按钮上的字
            //switch选择功能，且每次功能结束回到该界面，关闭已操作完的功能界面
            switch(actionCommand){
                case "1、余额查询":
                    getMoney();
                    break;
                case "2、取钱":
                    quMoney();
                    break;
                case "3、存钱":
                    cunMoney();
                    break;
                case "4、转账":
                    giveMoney();
                    break;
                case "5、修改密码":
                    changePassword();
                    break;
                case "6、退出系统":
                    over();
                    break;
            }
        }
    };
    //查询余额功能
    private void getMoney(){
        showMessageDialog("您的账户余额为：" + atm.getMoney1());//调用父类方法弹窗
    }
    //取钱功能
    private void quMoney(){
        new QuMoneyJFrame();//创建取钱界面
        dispose();//关闭该界面
    }
    //存钱功能
    private void cunMoney(){
        new CunMoneyJFrame();
        dispose();
    }
    //转账功能
    private void giveMoney(){
        new GiveMoneyJFrame();
        dispose();
    }
    //修改密码功能
    private void changePassword(){
        new ChangePasswordJFrame();
        dispose();
    }
    //退出系统功能
    private void over(){
        atm.over();//调用方法操作文件
        dispose();
    }
}


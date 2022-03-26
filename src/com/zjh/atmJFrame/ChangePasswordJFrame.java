package com.zjh.atmJFrame;


//修改密码界面
public class ChangePasswordJFrame extends CentreJFrame{
    public ChangePasswordJFrame(){
        super("修改密码");
    }

    protected void change(){
        String s = jTextFieldCP.getText();
        if(isNumber(s)){
            atm.changePassword(s);
            showMessageDialog("密码修改成功");
        }
        else
            showMessageDialog("您输入有误" );
        new WorkingJFrame();//创建功能界面
        dispose();//关闭此界面
    }

}


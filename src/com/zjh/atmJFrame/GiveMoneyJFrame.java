package com.zjh.atmJFrame;

//转账界面
public class GiveMoneyJFrame extends CentreJFrame {
    public GiveMoneyJFrame(){
        super("转账");
    }
    protected void change(){
        String s = jTextField.getText();
        boolean b = atm.anotherUser(s);
        if(b){
            //获取输入金额
            String s1 = jtf.getText();
            if(isNumber(s1)){//如果输入是数字
                Double money = Double.parseDouble(s1);
                atm.giveMoney(money);
                showMessageDialog("钱已转入\n您的账户余额为：" + atm.getMoney1());
            }
            else
                showMessageDialog("您输入有误" );
        }
        else
            showMessageDialog("您输入有误" );
        new WorkingJFrame();//创建功能界面
        dispose();//关闭此界面
    }
}



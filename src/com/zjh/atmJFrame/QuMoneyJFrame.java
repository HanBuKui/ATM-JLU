package com.zjh.atmJFrame;

//取钱界面
public class QuMoneyJFrame extends CentreJFrame {
    public QuMoneyJFrame(){
        super("取钱");
    }
    protected void change(){
        String s = jtf.getText();
        if(isNumber(s)){
            Double money = Double.parseDouble(s);
            boolean b = atm.quMoney(money);
            if(b){
                showMessageDialog("请收好您的钱\n您的账户余额为：" + atm.getMoney1());
            }
            else
                showMessageDialog("您输入有误" );
        }
        else
            showMessageDialog("您输入有误" );
        jtf.setText("");
    }

}


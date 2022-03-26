package com.zjh.atmJFrame;

//存钱界面
public class CunMoneyJFrame extends CentreJFrame {
    public CunMoneyJFrame(){
        super("存钱");
    }
    protected void change(){
        String s = jtf.getText();
        if(isNumber(s)){
            Double money = Double.parseDouble(s);
            boolean b = atm.saveMoney(money);
            if(b)
                showMessageDialog("您的钱钱已存入\n您的账户余额为：" + atm.getMoney1());
            else
                showMessageDialog("您输入有误" );
        }
        else
            showMessageDialog("您输入有误" );
        jtf.setText("");
    }

}


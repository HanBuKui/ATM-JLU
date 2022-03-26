package com.zjh.bank;

//ATM类
public class ATM {
    //有一个类操作数据的类
    private Data data = new Data();
    //ATM机里的数据
    private String userName;//用户账号且唯一
    private String userPassword;//用户密码
    private double userMoney;//用户账户里的钱
    private String user;//使用该台ATM机的用户全部信息
    private String antherUser;//被转账用户

    //登录方法
    public boolean login(String userNameString,String userPassword1){
        boolean b= false;
        String x = data.backUser(userNameString);
        //判断账户是否存在
        if(!x.equals("null")){
            user = x;//获取用户所有信息
            String[] str = user.split("\\*");//将用户信息分割
            userName = str[0];//用户名
            userPassword = str[1];//用户密码
            userMoney = Double.parseDouble(str[2]);//用户余额
            //密码正确
            if(userPassword.equals(userPassword1))
                b = true;
        }
        return b;
    }
    //获取账户余额
    public Double getMoney1(){
        return userMoney;
    }
    //存钱
    public boolean saveMoney(Double money1){
        boolean b = false;
        if(money1%100 == 0) { //如果存的钱正确
            userMoney = userMoney + money1;//存上
            b = true;
        }
        return b;
    }
    //取钱
    public boolean quMoney(Double money1){
        boolean b = false;
        if(money1%100 == 0 && money1 <= userMoney){
            userMoney = userMoney - money1;
            b = true;
        }
        return b;
    }
    //只判断用户账户是否存在
    public boolean anotherUser(String userName1){
        boolean b = false;
        String inUserName = userName1;
        String str = data.backUser(inUserName);
        //如果该账户存在
        if(!str.equals("null")) {
            antherUser = str;//获取被转账账户所有信息
            b = true;
        }
        return b;
    }
    //进行转账
    public void giveMoney(Double money1){
        String[] str1 = antherUser.split("\\*");//分割
        Double x = Double.parseDouble(str1[2]);//获取被转账账户余额
        x = x + money1;
        userMoney = userMoney - money1;
        antherUser = changeUser(str1[0], str1[1], x);//改变被转账账户信息
        data.saveData(antherUser,false);//将用户信息传给Data类保存被转账账户信息
    }
    //修改密码实现
    public void changePassword(String newPassword){
        userPassword = newPassword;
    }
    //办完业务后修改用户信息
    private String changeUser(String n,String w,Double d){
        String str = n + "*" + w + "*" + d;
        return str;
    }
    //办完所有业务
    public void over(){
        user = changeUser(userName,userPassword,userMoney);
        data.saveData(user,true);
    }
}


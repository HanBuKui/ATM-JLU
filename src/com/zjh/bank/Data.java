package com.zjh.bank;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//数据类是文件和ATM机之间操作用户信息的桥梁
public class Data {
    //Map储存数据库里所有用户的全部信息
    Map<String,String> userData = new HashMap();
    //返回用户的信息
    private String user;

    //创建数据类加载所有用户信息
    public Data(){
        getUsers();
    }

    private void getUsers(){
        String str;
        String[] string;
        File file = new File("src/com/zjh/bank/user.txt");
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try{
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while((str = bufferedReader.readLine())!=null){
                string = str.split("\\*",2);
                userData.put(string[0],string[1]);
            }
        }catch(Exception e){
            e.printStackTrace();
            if((fileReader!=null)&&(bufferedReader!=null)){
                try {
                    bufferedReader.close();
                    fileReader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    //告诉用户名，如果找到返回该用户所有信息，没找到返回null
    public String backUser(String userName){
        String str = "null";
        if(userData.containsKey(userName))
            str = userName + "*" + userData.get(userName);
        user = str;
        return user;
    }
    //修改用户数据并储存在userData图里
    public void saveData(String user,boolean aBoolean){
        String[] string = user.split("\\*",2);
        userData.remove(string[0]);
        userData.put(string[0],string[1]);
        if(aBoolean)//判断用户是否操作结束
            changeUser();
    }

    //用户操作完，将userData里所有的用户再写入文件里
    private void changeUser(){
        String str,string="";
        Set<String> keys = userData.keySet();
        for(String key : keys){
            str = key + "*" + userData.get(key);
            string = string + str + "\n";
        }
        File file = new File("src/com/zjh/bank/user.txt");
        FileWriter out = null;
        try {
            out = new FileWriter(file);
            out.write(string);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


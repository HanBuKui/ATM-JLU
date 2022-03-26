package com.zjh.bank.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Account
 * @Description: TODO
 * @author: zjh
 * @date: 2021/11/26  11:13
 * @Version: 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private String account;
    private String pwd;
    private int amount;
    private int is_freeze;
    private String name;
}

package main.java.hml.bank.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Manager
 * @Description: TODO
 * @author: zjh
 * @date: 2021/11/26  11:14
 * @Version: 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manager {
    private String managerID;
    private String pwd;
}

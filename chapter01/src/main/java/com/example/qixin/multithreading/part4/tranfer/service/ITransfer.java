package com.example.qixin.multithreading.part4.tranfer.service;

import com.example.qixin.multithreading.part4.tranfer.UserAccount;

/** 类说明：银行转账动作接口
 */
public interface ITransfer {

    void transfer(UserAccount from, UserAccount to, int amount) throws InterruptedException;
}

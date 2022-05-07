package com.example.studentsystem.pattern.state_reg;
//
public class Demo {

    public static void main(String[] args) {
        // 初始化上下文
        Context fanContext = new Context();
        // 调到高
        fanContext.shiftPending();
        // 调到低挡
        fanContext.shiftNotRegistered();
        // 关闭
        fanContext.shiftPending();
    }
}
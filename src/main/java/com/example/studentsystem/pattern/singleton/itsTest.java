package com.example.studentsystem.pattern.singleton;

public class itsTest
{
    public static void main(String[] args)
    {
//        获得日志单例对象
        FileLogger obj=FileLogger.getFileLogger();
        obj.write("hello");
        obj.write("hi");
        obj.close();
        System.out.println("end");
    }
}
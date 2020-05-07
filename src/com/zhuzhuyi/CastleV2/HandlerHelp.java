package com.zhuzhuyi.CastleV2;

public class HandlerHelp extends Handler{
    public HandlerHelp(CastleGame1 castleGame1) {
        super(castleGame1);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void doCmd(String words) {
        System.out.println("迷路了吗？你可以做的命令有：go bye help");
        System.out.println("如：\tgo east");
    }
}

package com.zhuzhuyi.CastleV2;

public class HandlerBye extends Handler {
    public HandlerBye(CastleGame1 castleGame1) {
        super(castleGame1);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean isBye() {
        return true;
    }

    @Override
    public void doCmd(String words) {
        System.out.println("欢迎您的光临，再见。");
    }
}

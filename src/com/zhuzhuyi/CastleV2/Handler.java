package com.zhuzhuyi.CastleV2;

public class Handler {
    protected CastleGame1 castleGame1;
    Handler (CastleGame1 castleGame1) {
        this.castleGame1 = castleGame1;
    }

    public void doCmd(String words) {}

    public boolean isBye() {
        return false;
    }
}

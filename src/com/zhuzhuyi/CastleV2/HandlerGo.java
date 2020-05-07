package com.zhuzhuyi.CastleV2;

public class HandlerGo  extends Handler{
    public HandlerGo(CastleGame1 castleGame1) {
        super(castleGame1);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void doCmd(String words) {
        castleGame1.goRoom(words);
    }
}

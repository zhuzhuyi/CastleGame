package com.zhuzhuyi.CastleV2;
import java.util.*;

public class CastleGame1 {
    private Room currentRoom;
    private HashMap<String, Handler> handlers = new HashMap<String, Handler>();

    public CastleGame1() {
//        handlers.put("go",new HandlerGo);
       handlers.put("bye",new HandlerBye(this));
       handlers.put("help",new HandlerHelp(this));
       handlers.put("go", new HandlerGo(this));
        createRooms();
    }

    public void createRooms() {
        Room outside,lobby,pub,study,bedroom;

        //创造房间
        outside = new Room("城堡外");
        lobby = new Room("大堂");
        pub = new Room("小酒吧");
        study = new Room("书房");
        bedroom = new Room("卧室");
/**
 * 三：扩展性改进
 */
        // 初始化房间的出口
        outside.setExit("east", lobby);
        outside.setExit("west", pub);
        outside.setExit("south", study);
        pub.setExit("east", outside);
        lobby.setExit("west", outside);
        study.setExit("north", outside);
        study.setExit("east", bedroom);
        bedroom.setExit("west", study);
        currentRoom = outside;        //从城堡门外开始
    }

    private void printWelcome()
    {
        System.out.println();
        System.out.println("欢迎来到城堡!");
        System.out.println("这是一个超级无聊的游戏。");
        System.out.println("如果需要帮助，请输入'help'");
        System.out.println();
        System.out.println("现在你在:" + currentRoom);
        System.out.println("欢迎来到城堡");
        System.out.println("出口有：");
        showPrompt();
    }

//  以下为用户命令

   /* private void printHelp()
    {
        System.out.println("迷路了吗？你可以做的命令有：go bye help");
        System.out.println("如：\tgo east");
    }*/

    public void goRoom(String direction){
        Room nextRoom = currentRoom.getExit(direction);
        if(nextRoom == null){
            System.out.println("那里没有门！");
        }
        else{
            currentRoom = nextRoom;
            showPrompt();
        }
    }
    /**
     *改进问题一：代码重复性,用函数来代替
     */
    public void showPrompt(){
        System.out.println("你在"+ currentRoom);
        System.out.println("出口有：");
        /**
         * 改进问题二：解耦合①
         */
        System.out.println(currentRoom.getExitDesc());
        System.out.println();
    }

    /**
     * 改进问题四：框架加数据
     * @param
     */
public void play(){
    Scanner in = new Scanner(System.in);
    while (true){
        String line = in.nextLine();
        String[] words = line.split(" ");
        Handler handler = handlers.get(words[0]);
        String value= "";
        if( words.length > 1 ) {
            value = words[1];
        }
        if( handler != null ) {
            handler.doCmd(value);
            if( handler.isBye() ) {
                break;
            }
        }
/*        if ( words[0].equals("help")){
            printHelp();
        }else if ( words[0].equals("go")){
            goRoom(words[1]);
        }else if ( words[0].equals("bye")){
            break;
        }*/
    }
    in.close();
}

    public static void main(String[] args) {
        CastleGame1 castleGame1 = new CastleGame1();
        castleGame1.printWelcome();
        castleGame1.play();
/*
        while (true){
            String line = in.nextLine();
            String[] words = line.split(" ");
            if ( words[0].equals("help")){
                castleGame1.printHelp();
            }else if ( words[0].equals("go")){
                castleGame1.goRoom(words[1]);
            }else if ( words[0].equals("bye")){
                break;
            }
        }*/
    }
}


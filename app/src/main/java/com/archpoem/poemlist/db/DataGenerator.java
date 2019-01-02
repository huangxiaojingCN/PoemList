package com.archpoem.poemlist.db;

import com.archpoem.poemlist.model.Poem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangxiaojing on 02/01/2019.
 */

public class DataGenerator {
    private static String[] poems = new String[] {
            "无言独上西楼，月如钩，寂寞梧桐深院锁清秋",
            "终易散，且长闲，莫教离恨捐朱颜",
            "人怜花似久，花不知人瘦",
            "纷纷凉月，一院丁香雪",
            "野桃含笑竹篱端，溪柳自摇沙水清",
            "红颜未老恩先断，斜倚熏笼坐到明",
            "星斗横幽馆，夜无眠灯花空老",
            "世间花叶不相伦，花入金盆也作尘",
            "未知明日事，余襟良已殚",
            "天生我材必有用，千金散尽还复来",
            "男儿不惜死，破胆与君尝",
            "流水落花春去也，天上人间",
            "月出皎兮，佼人僚兮",
            "西风多少恨，吹不散眉弯",
            "夕阳岛外，秋风原上，目断四天垂",
            "风也萧萧，雨也萧萧，瘦尽灯花又一宵",
            "到今来，海角逢春，天涯为客",
            "真珠帘卷玉楼空，天淡银河垂地",
            "最是人间留不住，朱颜辞镜花辞树",
            "好雨知时节，当春乃发生",
            "人间桂花落，夜静春山空",
            "江流天地外，山色有无中",
            "情人怨遥夜，竟夕起相思",
            "今夜山深处，断魂分付潮回去",
            "一道残阳铺水中，半江瑟瑟半江红",
            "人之生也柔弱，其死也坚强",
            "月影疑流水，春逢含夜梅",
            "深林人不知，明月来相照"

    };


    public static List<Poem> productPoems() {
        ArrayList<Poem> poems = new ArrayList<>();

        for (int i = 0; i < DataGenerator.poems.length; i++) {
            Poem poem = new Poem();
            poem.setId(i);
            poem.setPoemContent(DataGenerator.poems[i]);

            poems.add(poem);
        }

        return poems;
    }
}

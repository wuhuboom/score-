package com.score.system.domain.scoreVo;

import com.alibaba.fastjson2.annotation.JSONField;

public class ScoresVo {

    @JSONField(name="1")
    private Score one;

    @JSONField(name="2")
    private Score two;


    public Score getOne() {
        return one;
    }

    public void setOne(Score one) {
        this.one = one;
    }

    public Score getTwo() {
        return two;
    }

    public void setTwo(Score two) {
        this.two = two;
    }
}

 class Score {
    private  String home;

    private String away;

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getAway() {
        return away;
    }

    public void setAway(String away) {
        this.away = away;
    }
}
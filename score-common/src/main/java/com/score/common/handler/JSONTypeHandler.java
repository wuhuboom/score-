package com.score.common.handler;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;

import java.util.List;

public class JSONTypeHandler extends FastjsonTypeHandler {

    private final Class<? extends Object> type;

    public JSONTypeHandler(Class<?> type) {
        super(type);
        this.type = type;
    }

    @Override
    protected List parse(String json) {
        return JSON.parseArray(json, type);
//        return JSON.parseObject(json, type);
    }

    @Override
    protected String toJson(Object obj) {
        return super.toJson(obj);
    }

}

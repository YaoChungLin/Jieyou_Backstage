package com.jieyou.manage.mapper;

import java.util.List;

import com.github.abel533.mapper.Mapper;
import com.jieyou.manage.pojo.Item;

public interface ItemMapper extends Mapper<Item>{

	/*
     * 根据title模糊查询商品
     */
    public List<Item> findItemByItemname(String value) throws Exception;
}

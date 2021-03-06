package com.jieyou.manage.mapper;

import java.util.List;

import com.github.abel533.mapper.Mapper;
import com.jieyou.manage.pojo.Content;

public interface ContentMapper extends Mapper<Content> {

    /**
     * 根据categoryId查询内容列表，并且按照更新时间倒序排序
     * 
     * @return
     */
    public List<Content> queryContentList(Long categoryId);

}

package com.jieyou.manage.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jieyou.manage.mapper.ItemMapper;
import com.jieyou.manage.pojo.Item;
import com.jieyou.manage.service.ItemService;

@RequestMapping("api/item")
@Controller
public class ApiItemController {

    @Autowired
    private ItemService itemService;
    
    @Autowired
    private ItemMapper itemMapper;
    
    
    /*
     * 对外接口服务，根据商品id查询商品的基本数据
     *
     */
    @RequestMapping(value="{itemId}",method=RequestMethod.GET)
    public ResponseEntity<Item> queryById(@PathVariable("itemId") Long itemId){
        try {
            Item item = this.itemService.queryById(itemId);
            if (item.getStatus()!=1) {
            	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}
            if(null==item){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.ok(item);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
    
    
    
    
    /*
     * 对外接口服务，根据商品分类查询商品的基本数据
     *
     */
    @RequestMapping(value="catitem",method=RequestMethod.GET)
    public ResponseEntity<List<Item>> queryItemByCatId(Long itemCatId){
        try {
        	Item record=new Item();
        	record.setCid(itemCatId);
            List<Item> item = this.itemService.queryListByWhere(record);
            for (int i = 0; i < item.size(); i++) {
				if (item.get(i).getStatus()!=1) {
					item.remove(i);
				}		
			}
            if(null==item){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.ok(item);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
    
    
    /*
     * 对外接口服务，查询所有商品的基本数据
     *
     */
    @RequestMapping(value="allitem",method=RequestMethod.GET)
    public ResponseEntity<List<Item>> queryAllItem(){
        try {
            List<Item> item = this.itemService.queryAll();
            for (int i = 0; i < item.size(); i++) {
				if (item.get(i).getStatus()!=1) {
					item.remove(i);
				}		
			}
            if(null==item){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.ok(item);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
    
    /*
     * 对外接口服务，根据标题查询商品的基本数据
     *
     */
    @RequestMapping(value="title",method=RequestMethod.GET)
    public ResponseEntity<List<Item>> queryItemByTitle(String q){
        try {
        	List<Item> item = this.itemMapper.findItemByItemname(q);
            for (int i = 0; i < item.size(); i++) {
				if (item.get(i).getStatus()!=1) {
					item.remove(i);
				}	
            }
            if(null==item){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.ok(item);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}





















package com.jieyou.manage.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jieyou.manage.pojo.ItemDesc;
import com.jieyou.manage.service.ItemDescService;

@RequestMapping("api/item/desc")
@Controller
public class ApiItemDescController {
  
    @Autowired
    private ItemDescService itemDescService;
    
    /*
     * 查询商品的描述数据
     */
    @RequestMapping(value="{itemId}",method=RequestMethod.GET)
    public ResponseEntity<ItemDesc> queryItemDescByItemId(@PathVariable("itemId") Long itemId){
    	try {
			ItemDesc itemDesc = this.itemDescService.queryById(itemId);
			if(null==itemDesc) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}
			return ResponseEntity.ok(itemDesc);
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}





















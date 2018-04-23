package com.jieyou.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jieyou.common.EasyUIResult;
import com.jieyou.manage.pojo.Item;
import com.jieyou.manage.service.ItemService;

@RequestMapping("item")
@Controller
public class ItemController  {

    @Autowired
    private ItemService itemService;
    
    /*
     * 新增商品
     */
    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> saveItem(Item item,@RequestParam("desc") String desc){

        try {
           if(StringUtils.isEmpty(item.getTitle())){
               //参数有误,400
               return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
           }
            /*//初始值
            item.setStatus(1);
            item.setId(null);//出于安全考虑，强制设置id为null，通过数据库自增长得到
            this.itemService.save(item);
            
            ItemDesc itemDesc=new ItemDesc();
            itemDesc.setItemId(item.getId());
            itemDesc.setItemDesc(desc);
            this.itemDescService.save(itemDesc);*/
         Boolean bool = this.itemService.saveItem(item,desc);
          if(!bool){
              //保存失败
              return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
          }
            
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
           e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        
        
    }
    
    /*
     * 查询商品列表
     */
    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<EasyUIResult> queryItemList(
            @RequestParam(value="page",defaultValue="1") Integer page,
            @RequestParam(value="rows",defaultValue="30") Integer rows){
        try {
            return ResponseEntity.ok(this.itemService.queryItemList(page, rows));
        } catch (Exception e) {
            // TODO: handle exception
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
    
    /*
     * 编辑商品
     */
    @RequestMapping(method=RequestMethod.PUT)
    public ResponseEntity<Void> updateItem(Item item,@RequestParam("desc") String desc){
        try {
            if(StringUtils.isEmpty(item.getTitle())){
                //参数有误,400
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }  
          Boolean bool = this.itemService.updateItem(item,desc);
           if(!bool){
               //保存失败
               return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
           }
             
             return ResponseEntity.status(HttpStatus.CREATED).build();
         } catch (Exception e) {
            e.printStackTrace();
         }
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    
    /*
     * 删除商品
     */
    @RequestMapping(value="delete",method=RequestMethod.POST)
    public ResponseEntity<Void> deleteItem(@RequestParam("ids") Long ids){
    	 try {
             if(ids==null){
                 //参数有误,400
                 return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
             }  
           Boolean bool = this.itemService.deleteItem(ids);
            if(!bool){
                //保存失败
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
              
              return ResponseEntity.status(HttpStatus.CREATED).build();
          } catch (Exception e) {
             e.printStackTrace();
          }
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    
    
    /*
     * 商品下架
     */
    @RequestMapping(value="remove",method=RequestMethod.POST)
    public ResponseEntity<Void> removeItem(@RequestParam("ids") Long ids){
    	 try {
             if(ids==null){
                 //参数有误,400
                 return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
             }  
            Boolean boolean1 = this.itemService.removeItem(ids);
            if(!boolean1){
                //保存失败
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
              
              return ResponseEntity.status(HttpStatus.CREATED).build();
          } catch (Exception e) {
             e.printStackTrace();
          }
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    
    /*
     * 商品上架
     */
    @RequestMapping(value="reshelf",method=RequestMethod.POST)
    public ResponseEntity<Void> reshelfItem(@RequestParam("ids") Long ids){
    	 try {
             if(ids==null){
                 //参数有误,400
                 return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
             }  
            Boolean boolean1 = this.itemService.reshelfItem(ids);
            if(!boolean1){
                //保存失败
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
              
              return ResponseEntity.status(HttpStatus.CREATED).build();
          } catch (Exception e) {
             e.printStackTrace();
          }
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}


























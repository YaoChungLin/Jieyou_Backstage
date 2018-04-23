package com.jieyou.manage.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.jieyou.common.ItemCatResult;
import com.jieyou.manage.service.ItemCatService;
import com.jieyou.manage.service.api.ApiItemCatService;

@RequestMapping("api/item/cat")
@Controller
public class ApiItemCatController {

    @Autowired
    private ApiItemCatService apiItemCatService;
   
    
    
    /*
     * 对外提供接口查询商品类目数据
     */
    
    /* private static final ObjectMapper MAPPER=new ObjectMapper();
     
      @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<String> queryItemCat(
            @RequestParam(value="callback",required=false) String callback){
        try {
            ItemCatResult itemCatResult=this.itemCatService.queryAllToTree();
            String json=MAPPER.writeValueAsString(itemCatResult);
            if(StringUtils.isEmpty(callback)){
                return ResponseEntity.ok(json);
            }
            
            return ResponseEntity.ok(callback+"("+json+")");
           
        } catch (Exception e) {
          e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }*/
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<ItemCatResult> queryItemCatList() {
        try {
            ItemCatResult itemCatResult = this.apiItemCatService.queryAllToTree();
            return ResponseEntity.ok(itemCatResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}

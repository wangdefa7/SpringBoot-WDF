package com.wdf.test.spring.swagger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: SwaggerTestController
 * @Author WDF
 * @Description swagger文档测试 控制类
 *
 * @Api描述了整个控制器
 * @ApiOperation用于方法级别的描述
 * @ApiParam用于方法参数
 *
 * @Date 2020/10/30 11:06
 * @Copyright Dareway 2020/10/30
 * @Version 1.0
 **/
@RestController
@RequestMapping("/swagger")
@Api(description = "Api SwaggerTestController 类描述")
public class SwaggerTestController {

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ApiOperation("方法级别的描述")
    public List getAllPersons() {
        List list = new ArrayList();
        list.add("1");
        list.add("2");
        return list;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}", produces = "application/json")
    @ApiOperation("ApiOperation方法级别的描述,有参")
    public String getPersonById(@ApiParam("Id of the person to be obtained. Cannot be empty.") @PathVariable int id) {
        return id+"";
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @ApiOperation("删除方法")
    public void deletePerson(@ApiParam("ApiParam变量描述") @PathVariable int id) {

    }


    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    //@ApiOperation("post方法描述")
    @ApiOperation(
            value = "Find purchase order by ID",
            notes = "For valid response try integer IDs with value <= 5 or > 10. Other values will generated exceptions",
            response = SwaggerTestController.class,
            tags = { "Pet Store" })
    @ApiResponse(code = 400, message = "Invalid user supplied")
    public String createPerson(@ApiParam("变量描述") @RequestBody String str ) {
        return str;
    }


}
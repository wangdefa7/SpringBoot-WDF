package com.wdf.test.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: JsonTest
 * @Description:
 * @Auther: WDF
 * @Date: 2020/4/2211:30
 * @Version: 1.0
 **/
public class JsonTest {

    public static void main(String[] args) {
        JsonTest jsonTest = new JsonTest();
        jsonTest.toJson();

        /***
         * JSONObject (map)
         **/
        JSONObject json = new JSONObject();
        json.put("a","a");
        System.out.println(json.toString());
        System.out.println(json.toJSONString());

        /***
         * JSONArray（list）
         **/
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(0, "this is a jsonArray value");
        jsonArray.add(1, "this is another jsonArray value");
        System.out.println(jsonArray.toString());
        System.out.println(jsonArray.toJSONString());
        /***
         * list 转  JSONArray
         **/
        List list = new ArrayList();
        list.add("a");
        list.add("b");
        JSONArray jsonArrayList = new JSONArray(list);
        System.out.println(jsonArrayList.toJSONString());
    }

    public void toJson(){
        String str = "{jyqd=00, czybh=439, bcjyjzkh=372926198701182818, rzbm=dw1001, hzxm=高长海, jkmc=banktranspw, qqjybw=0100000000000001                                                                                                                                                                                , dyfwybs=20201124P00003106DAREWAY, czyxm=孙勇, yybh=10003, hzblh=null, jylybh=123}";
        System.out.println(JSONObject.toJSONString(str));
        str = str.replace("=",":");
        str = str.replace(", ",",");
        System.out.println(JSONObject.toJSONString(str));

        String out;
      /*  Object succesResponse = JSON.parse(str); //先转换成baiObject
        Map map = (Map)succesResponse;   //Object强转换为Map
        System.out.println(map.toString());*/
        //        System.out.println(JSON.toJSON(str));

//        map = (Map) JSON.toJSON(str);
//        System.out.println();
      /*  JSON json = (JSON) JSON.toJSON(str);
        System.out.println(json);*/
        System.out.println(JSONObject.toJSON(str));

        /*JSONObject jsonObject = (JSONObject) JSON.toJSON(str);
        System.out.println(jsonObject);
       // JSONObject jsonObject = new JSONObject();
        System.out.println(JSON.toJSONString(str));*/
    }

}

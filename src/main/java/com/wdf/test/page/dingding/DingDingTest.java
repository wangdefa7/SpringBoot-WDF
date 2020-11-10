package com.wdf.test.page.dingding;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.request.OapiMessageCorpconversationAsyncsendV2Request;
import com.dingtalk.api.request.OapiMessageCorpconversationGetsendresultRequest;
import com.dingtalk.api.request.OapiUserGetByMobileRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.dingtalk.api.response.OapiMessageCorpconversationAsyncsendV2Response;
import com.dingtalk.api.response.OapiMessageCorpconversationGetsendresultResponse;
import com.dingtalk.api.response.OapiUserGetByMobileResponse;
import com.taobao.api.ApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: DingDingTest
 * @Author WDF
 * @Description 钉钉测试类
 * @Date 2020/11/10 14:18
 * @Copyright Dareway 2020/11/10
 * @Version 1.0
 **/

@RequestMapping("/ding")
@Controller
public class DingDingTest {
    private static Logger logger = LoggerFactory.getLogger(DingDingTest.class);

    /**
     * @Author WDF
     * @Description 访问钉钉页面
     * @Date 2020/11/10 16:00
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping("/ding")
    public String openDingPage(){
        logger.info("访问钉钉...");
        return "/dingding/dingding";
    }

    /**
     * @Author WDF
     * @Description 调用后推送到钉钉消息
     * @Date 2020/11/10 19:03
     * @Param [message, phone]
     * @return java.lang.String
     * errorCode:0 errorMsg:ok 推送成功
     * errorCode:1 errorMsg:失败原因 推送失败
     **/
    @RequestMapping("pushMsg")
    @ResponseBody
    public String pushMsg(@RequestParam String message,@RequestParam String phone){
        StringBuffer msg = new StringBuffer();
        //去钉钉开发平台查看获取(凭证与基础信息)
        Long AgentId = 969328899L;
        String Appsecret = "fN3fKALWNdVVyzO7JsyeMVgJPAOWFNdGYetI7Cm5JycTxpJa3gr5nU_Tt9pqOXuM";
        String Appkey = "dingtmxapbfluxgjzunb";
        String accessToken = null;
        String UserId = null;
        Long TaskId = null;
        Map map = new HashMap();
        String info = null;

        logger.info("手机号" + phone + "   消息内容"+message);
        //获取access_token(一段时间的有效期)
        try {
            DefaultDingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/gettoken");
            OapiGettokenRequest request = new OapiGettokenRequest();
            request.setAppkey(Appkey);//appkey
            request.setAppsecret(Appsecret);//appsecret
            request.setHttpMethod("GET");
            OapiGettokenResponse response = client.execute(request);
            logger.info(response.getBody());
            info = response.getErrmsg();
            msg.append(response.getBody());
            accessToken = response.getAccessToken();
            if (!response.getErrorCode().equals("0")){
                map.put("errorCode",1);
                map.put("errorMsg",response.getBody());
                return map.toString();
            }
        } catch (ApiException e) {
            map.put("errorCode",1);
            map.put("errorMsg",info);
            e.printStackTrace();
            logger.error(e.getErrMsg());
            return map.toString();
        }

        //根据手机号获取UserId
        try {
            DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/user/get_by_mobile");
            OapiUserGetByMobileRequest req = new OapiUserGetByMobileRequest();
            if (StringUtils.isEmpty(phone)){
                phone = "17865316817";
            }
            req.setMobile(phone);
            req.setHttpMethod("GET");
            OapiUserGetByMobileResponse rsp = client.execute(req, accessToken);
            info = rsp.getErrmsg();
            logger.info(rsp.getBody());
            msg.append("<br>获取用户信息"+rsp.getBody());
            UserId = rsp.getUserid();
            if (!rsp.getErrorCode().equals("0")){
                map.put("errorCode",1);
                map.put("errorMsg",rsp.getBody());
                return map.toString();
            }
        } catch (ApiException e) {
            map.put("errorCode",1);
            map.put("errorMsg",info);
            e.printStackTrace();
            logger.error(e.getErrMsg());
            return map.toString();
        }

        //推送消息
        try {
            DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/message/corpconversation/asyncsend_v2");
            OapiMessageCorpconversationAsyncsendV2Request req = new OapiMessageCorpconversationAsyncsendV2Request();
            req.setAgentId(AgentId);//配置应用中获取(AgentId),应用凭证获取
            req.setUseridList(UserId);//推送用户的UserId
            //req.setToAllUser(true);//推送给全部用户
            OapiMessageCorpconversationAsyncsendV2Request.Msg obj1 = new OapiMessageCorpconversationAsyncsendV2Request.Msg();
            obj1.setMsgtype("text");
            OapiMessageCorpconversationAsyncsendV2Request.Text obj2 = new OapiMessageCorpconversationAsyncsendV2Request.Text();
            obj2.setContent(message);
            obj1.setText(obj2);
            req.setMsg(obj1);
            OapiMessageCorpconversationAsyncsendV2Response rsp = client.execute(req, accessToken);
            info = rsp.getErrmsg();
            logger.info(rsp.getBody());
            TaskId = rsp.getTaskId();
            msg.append("<br>消息发送："+rsp.getBody());
            if (!rsp.getErrorCode().equals("0")){
                map.put("errorCode",1);
                map.put("errorMsg",rsp.getBody());
                return map.toString();
            }
        } catch (ApiException e) {
            map.put("errorCode",1);
            map.put("errorMsg",info);
            e.printStackTrace();
            logger.error(e.getErrMsg());
            return map.toString();
        }

        //查询发送状态
        try {
            DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/message/corpconversation/getsendresult");
            OapiMessageCorpconversationGetsendresultRequest req = new OapiMessageCorpconversationGetsendresultRequest();
            req.setAgentId(AgentId);
            req.setTaskId(TaskId);
            OapiMessageCorpconversationGetsendresultResponse rsp = client.execute(req, accessToken);
            info = rsp.getErrmsg();
            msg.append("<br>发送状态"+rsp.getBody());
            logger.info("发送状态"+rsp.getBody());
            if (!rsp.getErrorCode().equals("0")){
                map.put("errorCode",1);
                map.put("errorMsg",rsp.getBody());
                return map.toString();
            }
        } catch (ApiException e) {
            map.put("errorCode",1);
            map.put("errorMsg",info);
            e.printStackTrace();
            logger.error(e.getErrMsg());
            return map.toString();
        }
        logger.info(msg.toString());
        if (map.containsKey("errorCode")&& map.get("errorCode") == "1"){
            return map.toString();
        }
        map.put("errorCode",0);
        map.put("errorMsg","ok");

        return map.toString();
    }
}

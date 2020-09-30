package com.wdf.test.json.recon;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.dom4j.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class XmlUtil {
	// 日志初始化
	protected static Logger logger = LoggerFactory.getLogger(XmlUtil.class);

    /**
     * @return java.lang.String
     * @Author yrd
     * @Description map转xml(支持复杂格式 ， 支持数组 ， 支持DataObject 、 DataStore)
     * @Date 10:47 2019/11/14
     * @Param [map, rootName, encoding]
     **/
    public static String mapToXml(Map<String, Object> map, String rootName, String encoding) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        org.w3c.dom.Document doc = builder.newDocument();
        org.w3c.dom.Element root = doc.createElement(rootName);
        doc.appendChild(root);
        map2xml(map, root, doc);

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        DOMSource source = new DOMSource(doc);
        transformer.setOutputProperty("encoding", encoding);
        transformer.setOutputProperty("indent", "yes");
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        transformer.transform(source, result);
        String output = writer.getBuffer().toString();
        try {
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }

	@SuppressWarnings("unchecked")
	private static org.w3c.dom.Element map2xml(Map<String, Object> map, org.w3c.dom.Element body, org.w3c.dom.Document doc) {
        Iterator<Map.Entry<String, Object>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, Object> entry = entries.next();
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key.startsWith("@")) { //属性
                body.setAttribute(key.substring(1, key.length()), value.toString());
            } else if (key.equals("#text")) { //有属性时的文本
                body.setTextContent(value.toString());
            } else {
                if (value instanceof List) {
                    List<?> list = (List<?>) value;
                    Object obj;
                    for (int i = 0; i < list.size(); i++) {
                        obj = list.get(i);
                        //list里是map或String，不会存在list里直接是list的，
                        if (obj instanceof Map) {
                            org.w3c.dom.Element subElement = doc.createElement(key);
                            body.appendChild(subElement);
                            map2xml((Map<String, Object>) list.get(i), subElement, doc);
                        } else {
                            org.w3c.dom.Element subElement = doc.createElement(key);
                            subElement.setTextContent((String) list.get(i));
                            body.appendChild(subElement);
                        }
                    }
                } else if (value instanceof Map) {
                    org.w3c.dom.Element subElement = doc.createElement(key);
                    body.appendChild(subElement);
                    map2xml((Map<String, Object>) value, subElement, doc);
                } else {
                    org.w3c.dom.Element subElement = doc.createElement(key);
                    subElement.setTextContent(value.toString());
                    body.appendChild(subElement);
                }
            }
        }
        return body;
    }

    /**
     * @return com.alibaba.fastjson.JSONObject
     * @Author yrd
     * @Description xml转json
     * @Date 19:03 2019/11/12
     * @Param [xmlStr]
     **/
    public static JSONObject xmlToJson(String xmlStr) throws DocumentException {
        Document doc = DocumentHelper.parseText(xmlStr);
        JSONObject json = new JSONObject();
        dom4jToJson(doc.getRootElement(), json);
        return json;
    }

    /**
     * @return void
     * @Author yrd
     * @Description dom4jToJson
     * @Date 19:04 2019/11/12
     * @Param [element, json]
     **/
    public static void dom4jToJson(Element element, JSONObject json) {
        //如果是属性
        for (Object o : element.attributes()) {
            Attribute attr = (Attribute) o;
            if (!isEmpty(attr.getValue())) {
                json.put("@" + attr.getName(), attr.getValue());
            }
        }
        @SuppressWarnings("unchecked")
		List<Element> chdEl = element.elements();
        if (chdEl.isEmpty() && !isEmpty(element.getText())) {//如果没有子元素,只有一个值
            json.put(element.getName(), element.getText());
        }

        for (Element e : chdEl) {//有子元素
            if (!e.elements().isEmpty()) {//子元素也有子元素
                JSONObject chdjson = new JSONObject();
                dom4jToJson(e, chdjson);
                Object o = json.get(e.getName());
                if (o != null) {
                    JSONArray jsona = null;
                    if (o instanceof JSONObject) {//如果此元素已存在,则转为jsonArray
                        JSONObject jsono = (JSONObject) o;
                        json.remove(e.getName());
                        jsona = new JSONArray();
                        jsona.add(jsono);
                        jsona.add(chdjson);
                    }
                    if (o instanceof JSONArray) {
                        jsona = (JSONArray) o;
                        jsona.add(chdjson);
                    }
                    json.put(e.getName(), jsona);
                } else {
                    if (!chdjson.isEmpty()) {
                        json.put(e.getName(), chdjson);
                    }
                }
            } else {//子元素没有子元素
                for (Object o : element.attributes()) {
                    Attribute attr = (Attribute) o;
                    if (!isEmpty(attr.getValue())) {
                        json.put("@" + attr.getName(), attr.getValue());
                    }
                }
                if (!e.getText().isEmpty()) {
                    json.put(e.getName(), e.getText());
                }
            }
        }
    }

    /**
     * @return boolean
     * @Author yrd
     * @Description 字符串判空
     * @Date 19:05 2019/11/12
     * @Param [str]
     **/
    public static boolean isEmpty(String str) {

        if (str == null || str.trim().isEmpty() || "null".equals(str)) {
            return true;
        }
        return false;
    }
}

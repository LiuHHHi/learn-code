package json1;

import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.TypeReference;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

/**
 * @author Lemon
 * @date 2022/12/30 13:51
 */
public class JsonTest {

    /*
     * Json数据格式，可以描述 6 种数据格式
     * 分别是：字符串、数值、布尔值、空、对象、数组
     * 数值：包含全部数字，包含小数，没有长度限制
     * 对象、数组：可互相嵌套，为了让数据有一定意义和规律，嵌套会有一定的规则。
     * 数组：每个元素的数据格式应该保持一致。
     * 例子：JsonData.json
     */
    @Test
    public void json1() {
        URL resource = getClass().getResource("JsonData.json");
        JSONObject jsonObject = JSON.parseObject(resource);
        if (jsonObject == null) {
            return;
        }
        String name = jsonObject.getString("name");
        System.out.println(name);
        Integer age = jsonObject.getInteger("age");
        System.out.println(age);
        Long createDate = jsonObject.getLong("createDate");
        System.out.println(createDate);
        // 把剩下的挨个试试
        // 获取 role 下的第 3个元素
        // 获取 otherInfo 下的 qq 数据
    }

    /*
     * Json数据中的 对象、数组与Java类的对应关系
     * Json数据 - 对象  : Java中的 类、Map<String, Object>、JsonObject（FastJson）
     * Json数据 - 对象  : Java中的 List<Object>、JsonArray（FastJson）
     */
    @Data
    public static class BookEntity {
        private String bookName;
        private Double price;
    }
    @Test
    public void json2() {
        URL resource = getClass().getResource("JsonData2.json");

        // 使用 FastJson中的 JSONArray 和 JSONObject 接收
        JSONArray jsonArray = JSON.parseArray(resource);
        if (jsonArray != null) {
            System.out.println(jsonArray);
        }
        if (resource == null) {
            return;
        }
        String readString = FileUtil.readString(resource, StandardCharsets.UTF_8);
        // 使用 List Map 接收
        List<Map<String, Object>> result = JSON.parseArray(readString, new TypeReference<Map<String, Object>>(){}.getType());
        System.out.println(result);
        // 使用 List 与 类 接收
        List<BookEntity> bookEntityList = JSON.parseArray(readString, BookEntity.class);
        System.out.println(bookEntityList);
    }
    @Test
    public void json3() {
        // 1。将 JsonData.json 的数据 转成 使用 Map 接收参数
        // 2。将 JsonData.json 的数据 转成 使用 类  接收参数
    }
}

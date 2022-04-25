package cn.luoyanze.common.contract.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/25 5:21 PM
 */


public class RequestHeadTest {

    @Test
    public void test() {
        String s = "{\n" +
                "    \"timestamp\":\"1650877776685\",\n" +
                "    \"username\":\"luoyanze\",\n" +
                "    \"token\":\"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI4MTY5OTE4MC02NDliLTRhN2EtOTVlOC0xNjg3YTU2NTZiNDMiLCJBQ0NPVU5UIjoibHVveWFuemUiLCJpc3MiOiIzOGU5ZDQwNi01ODIwLTQxMDQtYTYzNy1mMzEzOGE4NDIxM2UiLCJleHAiOjE2NTM0Njk3NzZ9.I3lTfcuf0Sw9b1Acp9lbZFHg-pjF2Ex445Q1hJueOII\"\n" +
                "}";

        RequestHead requestHead = JSON.parseObject(s, RequestHead.class);
        System.out.println(requestHead);
    }
}

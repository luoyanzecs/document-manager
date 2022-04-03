package cn.luoyanze.common.contract;

import cn.luoyanze.common.contract.entity.Menu;
import cn.luoyanze.common.contract.entity.ResponseHead;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 1:48 PM
 */


public class FileMenuHttpResponse {

    /**
     * 头信息
     */
    @JsonProperty("head")
    private ResponseHead head;

    /**
     * 目录列表
     */
    @JsonProperty("items")
    private List<Menu> menus;

    public FileMenuHttpResponse(ResponseHead head, List<Menu> menus) {
        this.head = head;
        this.menus = menus;
    }


    public ResponseHead getHead() {
        return head;
    }

    public void setHead(ResponseHead head) {
        this.head = head;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}

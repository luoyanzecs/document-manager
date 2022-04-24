package cn.luoyanze.documentmanager.model;

import lombok.Data;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/6 10:32 PM
 */

@Data
public class DocVO {

    private Integer id;

    private Integer parentId;

    private String title;
}

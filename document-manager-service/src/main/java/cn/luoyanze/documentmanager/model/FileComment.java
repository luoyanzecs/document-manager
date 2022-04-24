package cn.luoyanze.documentmanager.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/5 10:46 PM
 */

@Data
public class FileComment {

    private Integer userId;

    private String username;

    private String avatar;

    private String ctx;

    private Integer parentId;

    private LocalDateTime time;

    private Integer commentId;
}

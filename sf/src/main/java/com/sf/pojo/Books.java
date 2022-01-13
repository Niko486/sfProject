package com.sf.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Books implements Serializable {
    @TableId
    private int id;
    private String bookName;
    private String type;
    private int typeId;
    private String bookUrl;
    private String imgUrl;
    private int userId;
    private Date created;
    private Date updated;
    private Long words;
    private Long readCounts;
}

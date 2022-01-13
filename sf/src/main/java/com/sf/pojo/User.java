package com.sf.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
public class User implements Serializable{
    @TableId
    private int id;
    private String username;
    private String password;
    private Date created;
    private Date updated;
    private boolean isMember;
    private Date memberCreated;
    private Date memberUpdated;
    private double points;
    private boolean isWriter;
    private int bookCounts;
}

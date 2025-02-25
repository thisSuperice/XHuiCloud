/*
 * MIT License
 * Copyright <2021-2022>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * @Author: Sinda
 * @Email:  xhuicloud@163.com
 */

package com.xhuicloud.generator.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: XHuiCloud
 * @description: 表字段信息
 * @author: Sinda
 * @create: 2020-06-22 12:14
 */
@Data
public class TableColumnsInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 数据库原字段名 例如 create_time
     */
    private String columnName;

    /**
     * 数据库字段名 小驼峰 例如 createTime
     */
    private String smallColumnName;

    /**
     * 数据原类型
     */
    private String dataType;

    /**
     * 数据库类型 对应java
     */
    private String javaDataType;

    /**
     * 字段描述
     */
    private String columnComment;

    /**
     * 其他信息
     */
    private String extra;

    /**
     * 列键
     */
    private String columnKey;

    /**
     * 是否能为空
     */
    private String isNullable;

}

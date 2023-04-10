package com.ruibin.queryvo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SearchBlog {
    private String title;
    private Long typeId;
}

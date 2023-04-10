package com.ruibin.pojo;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Type {
    private Long id;
    @NotBlank(message = "分类名称不能为空")
    private String name;
    private List<Blog> blogs = new ArrayList<>();
}

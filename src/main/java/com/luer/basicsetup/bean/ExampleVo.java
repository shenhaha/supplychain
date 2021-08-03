package com.luer.basicsetup.bean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.List;

@Api(description = "list数组封装类")
@Data
public class ExampleVo {
    @ApiModelProperty(value = "id集合")
    private List<String> ids;
}

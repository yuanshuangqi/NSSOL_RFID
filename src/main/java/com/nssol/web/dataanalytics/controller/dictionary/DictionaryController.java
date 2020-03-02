package com.nssol.web.dataanalytics.controller.dictionary;

import com.nssol.web.common.vo.R;
import com.nssol.web.dataanalytics.service.dictionary.DictionaryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DictionaryController {

    @Resource
    DictionaryService dictionaryService;
    @GetMapping(value = "/api/dictionary/{dictype}")
    @ApiOperation(value = "根据设备类型查询产线")
    public R getDictionaryByDicType(@PathVariable("dictype")String dictype){
        return dictionaryService.getDictionary(dictype);
    }
}

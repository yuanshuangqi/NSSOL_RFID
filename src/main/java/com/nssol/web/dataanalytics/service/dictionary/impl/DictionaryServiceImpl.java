package com.nssol.web.dataanalytics.service.dictionary.impl;

import com.nssol.dao.master.DictionaryDao;
import com.nssol.web.common.vo.R;
import com.nssol.web.dataanalytics.model.DictionaryInfo;
import com.nssol.web.dataanalytics.service.dictionary.DictionaryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DictionaryServiceImpl implements DictionaryService{
    @Resource
    DictionaryDao dictionaryDao;
    @Override
    public R getDictionary(String dicType) {
        List<DictionaryInfo> dictionaryInfos = dictionaryDao.getDictionary(dicType);
        return R.ok().data(dictionaryInfos);
    }
}

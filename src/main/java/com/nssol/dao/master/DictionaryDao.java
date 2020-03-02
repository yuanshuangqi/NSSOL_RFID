package com.nssol.dao.master;

import com.nssol.web.dataanalytics.model.DictionaryInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface DictionaryDao {
    List<DictionaryInfo> getDictionary(@Param("dicType")String dicType);
}

package com.etf.adapter;

import com.etf.adapter.dto.SearchRequestDto;
import com.etf.adapter.dto.ResponseDto;
import com.etf.utils.QueryUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Auther: etf
 * @Date: 2020-05-15 11:41
 * @Description:
 */
@Slf4j
@Component
public class SearchAdapter {


    public ResponseDto searchResult(SearchRequestDto searchRequestDto) {

        String obj = QueryUtils.generateSearchParamDTO(searchRequestDto);

        ResponseDto responseDto = new ResponseDto();
        responseDto.setResult(obj);
        return responseDto;
    }
}

package controller;

import adapter.dto.RequestDto;
import org.springframework.stereotype.Controller;

import java.util.Collections;
import java.util.Map;

/**
 * @author etf
 */
@Controller
public class AnnotationController {

    public Map<String, Object> test() {

        RequestDto requestDto = new RequestDto();

        return Collections.emptyMap();
    }


}

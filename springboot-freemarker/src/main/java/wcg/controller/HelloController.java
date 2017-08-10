package wcg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author chengangw
 * @date 7/8/2017 11:43 AM
 */
@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }

    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("host", "http://www.baidu.com/");
        return "index";
    }
}

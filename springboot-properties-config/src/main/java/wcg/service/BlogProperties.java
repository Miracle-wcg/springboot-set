package wcg.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author chengangw
 * @date 7/8/2017 6:33 PM
 */
@Component
public class BlogProperties {
    @Value("${com.wcg.blog.name}")
    private String name;
    @Value("${com.wcg.blog.title}")
    private String title;
    @Value("${com.wcg.blog.desc}")
    private String desc;

    @Value("${com.wcg.blog.value}")
    private String value;
    @Value("${com.wcg.blog.number}")
    private String number;
    @Value("${com.wcg.blog.bignumber}")
    private String bignumber;
    @Value("${com.wcg.blog.test1}")
    private String test1;
    @Value("${com.wcg.blog.test2}")
    private String test2;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBignumber() {
        return bignumber;
    }

    public void setBignumber(String bignumber) {
        this.bignumber = bignumber;
    }

    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1;
    }

    public String getTest2() {
        return test2;
    }

    public void setTest2(String test2) {
        this.test2 = test2;
    }
}

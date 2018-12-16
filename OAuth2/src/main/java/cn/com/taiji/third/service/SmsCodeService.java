package cn.com.taiji.third.service;
import org.springframework.stereotype.Service;

/**
 * @Author: zxx
 * @Date: 2018/12/10 12:31
 * @Version 1.0
 */

@Service
public class SmsCodeService {
	
	
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
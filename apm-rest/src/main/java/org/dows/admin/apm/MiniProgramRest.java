package org.dows.admin.apm;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MiniProgramRest {

    /**
     * 小程序token 验证
     *
     * @param token
     * @return
     */
    @GetMapping("mp/verify/token")
    public String verifyToken(String token) {

        log.info("token:{}", token);
        return "ok";
    }
}

package org.dows.apm.open;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Tag(name = "小程序", description = "小程序相关接口")
@RequiredArgsConstructor
public class OpenMiniProgramRest {

    /**
     * 小程序token 验证
     *
     * @param token
     * @return
     */
    @Operation(summary = "小程序Token验证[GET]")
    @GetMapping("/v1/open/mp/verify/token")
    public String verifyToken(String token) {

        log.info("get method verify token:{}", token);
        return "ok";
    }


    @Operation(summary = "小程序Token验证[POST]")
    @PostMapping("/v1/open/mp/verify/token")
    public String ppostVerifyToken(String token) {

        log.info("post method verify token:{}", token);
        return "ok";
    }
}

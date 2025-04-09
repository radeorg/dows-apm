package org.dows.apm.open;

import lombok.Data;

@Data
public class RequestParams {
    private String signature;
    private String echostr;
    private String timestamp;
    private String nonce;
}
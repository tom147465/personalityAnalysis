package com.zz.web310.model;

import lombok.Builder;
import lombok.Data;

@Data //setter & getter
@Builder
public class ConversationBizResult {

    public static final boolean SUCC = true;
    public static final boolean FAILED = true;

    private boolean status;
    private String msg;
}

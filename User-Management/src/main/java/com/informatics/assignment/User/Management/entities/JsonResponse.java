package com.informatics.assignment.User.Management.entities;


import ch.qos.logback.core.spi.ErrorCodes;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class JsonResponse {

    private String operation;
    private int responseCode;
    private String responseDesc;
    private Object data;

}

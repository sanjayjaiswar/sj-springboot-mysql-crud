package com.sj.backend.data;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;


/**
 * Created by Sanjay Jaiswar on 7/23/19.
 */
@Data
public class Request {

    @NotEmpty
    private Integer entityId;

    @NotEmpty
    private String entityName;
}


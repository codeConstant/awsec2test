package com.aws.ec2.deploy.opaque;

import lombok.Data;

@Data
public class WeatherRequest {

    private String location;
    private String fromDate;
    private String toDate;
    private String period;
}

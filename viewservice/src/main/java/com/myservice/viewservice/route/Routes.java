package com.myservice.viewservice.route;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Routes {
    @Value("${app.route.loginservice}")
    private String loginRoute;
    @Value("${app.route.dataservice}")
    private String dataRoute;

    public String getLoginRoute(){
        return loginRoute;
    }

    public String getDataRoute(){
        return dataRoute;
    }
}

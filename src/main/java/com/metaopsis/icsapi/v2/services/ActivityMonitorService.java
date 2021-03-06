package com.metaopsis.icsapi.v2.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.metaopsis.icsapi.v2.dom.ActivityMonitorEntry;
import com.metaopsis.icsapi.v2.dom.User;
import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ActivityMonitorService {
    final static Logger logger = Logger.getLogger(ActivityMonitorService.class);
    private ObjectMapper mapper;
    private RestTemplate rest;
    private HttpHeaders headers;
    private User user;

    public ActivityMonitorService(User user)
    {
        this.user = user;

        // Set HttpHeaders for request
        this.headers = new HttpHeaders();
        this.headers.add("Content-Type", "application/json");
        this.headers.add("Accept", "application/json");
        this.headers.add("icSessionId", user.getIcSessionId());

        // Set ObjectMapper
        this.mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // Set RestTemplate
        this.rest = new RestTemplate();
        this.rest.setErrorHandler(new CustomResponseErrorHandler());
    }

    public ActivityMonitorEntry[] monitor(boolean details) throws InformaticaCloudException
    {
        logger.info(this.getClass().getName()+"::monitor::enter");
        HttpEntity<String> requestEntity = null;
        ResponseEntity<String> responseEntity = null;
        ActivityMonitorEntry[] response = null;
        try {


            requestEntity = new HttpEntity<String>(null, headers);

            responseEntity = rest.exchange(user.getServerUrl()+"/api/v2/activity/activityMonitor?details=" + details , HttpMethod.GET, requestEntity, String.class);

            logger.info("Informatica Cloud V2 Activity Monitor " + responseEntity.getStatusCode().toString());
            if (responseEntity.getStatusCode().is2xxSuccessful())
            {
                response = mapper.readValue(responseEntity.getBody(), ActivityMonitorEntry[].class);
            } else {
                logger.error(responseEntity.toString());
                throw new InformaticaCloudException(responseEntity.toString());
            }
        } catch(Exception e)
        {
            throw new InformaticaCloudException(e.getMessage());
        }

        logger.info(this.getClass().getName()+"::monitor::exit");
        return response;
    }
}

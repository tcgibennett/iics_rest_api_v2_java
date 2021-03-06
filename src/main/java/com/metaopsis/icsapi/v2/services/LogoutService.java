package com.metaopsis.icsapi.v2.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.metaopsis.icsapi.v2.dom.ErrorObject;
import com.metaopsis.icsapi.v2.dom.User;
import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class LogoutService {
    private User user = null;
    final static Logger logger = Logger.getLogger(LogoutService.class);
    private ObjectMapper mapper;
    private RestTemplate rest;
    private HttpHeaders headers;

    public LogoutService(User user)
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

    public void logout() throws InformaticaCloudException
    {
        logger.debug(user.toString());
        logger.info(this.getClass().getName()+"::logout::enter");

        HttpEntity<String> requestEntity = null;
        ResponseEntity<String> responseEntity = null;
        ErrorObject errorObject = null;
        try {

            requestEntity = new HttpEntity<String>(null, headers);

            responseEntity = rest.exchange(user.getServerUrl()+"/api/v2/user/logout", HttpMethod.POST, requestEntity, String.class);

            logger.info("Informatica Cloud V2 Logout " + responseEntity.getStatusCode().toString());

            if (!responseEntity.getStatusCode().is2xxSuccessful())
            {
                errorObject = mapper.readValue(responseEntity.getBody(), ErrorObject.class);
                logger.error(responseEntity.toString());
                throw new InformaticaCloudException(errorObject.toString());
            }
        } catch(Exception e)
        {
            throw new InformaticaCloudException(e.getMessage());
        }

        logger.info(this.getClass().getName()+"::logout::exit");

    }
}

package com.metaopsis.icsapi.v2.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.metaopsis.icsapi.v2.dom.Credentials;
import com.metaopsis.icsapi.v2.dom.ErrorObject;
import com.metaopsis.icsapi.v2.dom.User;
import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class LogoutAllService {
    private Url url = null;
    final static Logger logger = Logger.getLogger(LogoutAllService.class);
    private ObjectMapper mapper;
    private RestTemplate rest;
    private HttpHeaders headers;

    public LogoutAllService(Url url)
    {
        this.url = url;

        // Set HttpHeaders for request
        this.headers = new HttpHeaders();
        this.headers.add("Content-Type", "application/json");
        this.headers.add("Accept", "application/json");

        // Set ObjectMapper
        this.mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // Set RestTemplate
        this.rest = new RestTemplate();
        this.rest.setErrorHandler(new CustomResponseErrorHandler());
    }

    public void logoutAll(Credentials credentials, User user) throws InformaticaCloudException
    {
        logger.debug(credentials.toString());
        logger.info(this.getClass().getName()+"::logoutAll::enter");

        HttpEntity<String> requestEntity = null;
        ResponseEntity<String> responseEntity = null;
        ErrorObject errorObject = null;
        try {
            this.headers.add("icSessionId", user.getIcSessionId());
            requestEntity = new HttpEntity<String>(null, headers);

            responseEntity = rest.exchange(url.toString(), HttpMethod.POST, requestEntity, String.class);

            logger.info("Informatica Cloud V2 LogoutAll " + responseEntity.getStatusCode().toString());

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

        logger.info(this.getClass().getName()+"::logoutAll::exit");
    }
}

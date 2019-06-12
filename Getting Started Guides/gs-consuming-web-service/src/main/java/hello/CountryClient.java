package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import hello.wsdl.GetCountryRequest;
import hello.wsdl.GetCountryResponse;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class CountryClient extends WebServiceGatewaySupport {

    private static final Logger logger = LoggerFactory.getLogger(CountryClient.class);

    public GetCountryResponse getCountry(String country) {
        GetCountryRequest request = new GetCountryRequest();
        request.setName(country);

        logger.info("Requesting location for " + country);

        GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/countries",request,
                        new SoapActionCallback("http://spring.io/guides/gs-producing-web-service/GetCountryRequest"));
        return response;
    }
}

package net.ph4te.sample.ascserver;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;

import javax.xml.ws.Endpoint;


@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Autowired
    private Bus bus;

    @Autowired
    private GetAuthSessionPolicyImpl getAuthSessionPolicyImpl;

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, getAuthSessionPolicyImpl);
        endpoint.publish("/GetAuthSessionPolicy");
        return endpoint;
    }
}

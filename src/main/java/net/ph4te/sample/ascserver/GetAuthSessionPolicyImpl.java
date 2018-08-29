package net.ph4te.sample.ascserver;


import com.acmepacket.asc.ws.callouts.AuthSessionPolicyPortType;
import com.acmepacket.asc.ws.common.*;
import org.springframework.stereotype.Service;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.jws.WebService;

@Service
@WebService(serviceName = "GetAuthSessionPolicy", portName = "AuthSessionPolicyPort", endpointInterface = "com.acmepacket.asc.ws.callouts.AuthSessionPolicyPortType", targetNamespace = "http://www.acmepacket.com/asc/ws/callouts")
public class GetAuthSessionPolicyImpl implements AuthSessionPolicyPortType
{

    private static void logAndPrint(String s) {
        System.out.println(s);
    }

    @PayloadRoot(namespace = "http://www.acmepacket.com/asc/ws/mgmt", localPart = "getAuthSessionPolicyRequest")
    public @ResponsePayload SessionConfigSetType getAuthSessionPolicy(@RequestPayload SIPAuthInputsType parameters) {

        logAndPrint("getAuthSessionPolicy received!s");

        SessionConfigSetType type = new SessionConfigSetType();
        //SessionConfig config = new SessionConfig();
        SessionConfigType configType = new SessionConfigType();

        // Demonstrates to allow policy
        logAndPrint("Sending an allow policy.");
        SIPDirectiveSettingsType directiveSettingsType = new SIPDirectiveSettingsType();
        SIPDirective.Allow allow = new SIPDirective.Allow();

        // create sip directive
        SIPDirective directive = new SIPDirective();
        directive.setAllow(allow);

        /* Demonstrates to refuse policy
         * Return a reject.
         *logAndPrint("Sending a reject policy.");

		SIPDirective.Refuse refuse = new SIPDirective.Refuse();
		refuse.setResultCode((long)404);
		refuse.setResultString("External getAuthSesssionPolicy callout is refusing this!");
		directive.setRefuse(refuse);
		*/

        directiveSettingsType.setDirective(directive);
        configType.setSipDirective(directiveSettingsType);
        type.getSessionConfig().add(configType);
        return type;
    }
}
package mff.betse.nswi145.food_delivery_app;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;

public class ClientPasswordCallback implements CallbackHandler {

	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		for (Callback callback : callbacks) {
            WSPasswordCallback pc = (WSPasswordCallback) callback;
            if ("betse".equals(pc.getIdentifier())) {
                pc.setPassword("admin123");
                return;
            }
        }

	}

}

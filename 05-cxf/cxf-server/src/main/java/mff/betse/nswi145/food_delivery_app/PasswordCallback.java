package mff.betse.nswi145.food_delivery_app;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;

public class PasswordCallback implements CallbackHandler {
	private Map<String, String> passwords = new HashMap<>();

    public PasswordCallback() {
        passwords.put("betse", "admin123");
        passwords.put("betse1", "admin321");
    }

	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		for (Callback callback : callbacks) {
            WSPasswordCallback pc = (WSPasswordCallback) callback;
            String pass = passwords.get(pc.getIdentifier());
            if (pass != null) {
                pc.setPassword(pass);
                return;
            }
        }
        throw new IOException("No password found for user: " + ((WSPasswordCallback) callbacks[0]).getIdentifier());

	}

}

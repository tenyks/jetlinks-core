package org.jetlinks.core.device;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetlinks.core.message.codec.Transport;

/**
 * @author zhouhao
 * @since 1.0.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MqttAuthenticationRequest implements AuthenticationRequest {

    private static final long serialVersionUID = -6083205376193989944L;

    private String clientId;

    private String username;

    private String password;

    private Transport transport;

    private JSONObject  extra;
}

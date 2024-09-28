package org.jetlinks.core.device;

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
public class TcpAuthenticationRequest implements AuthenticationRequest {

    private static final long serialVersionUID = 1468625253591912222L;

    private String      clientId;

    private String      password;

    private Transport   transport;
}

package javax.security.auth.message.module;

import java.util.Map;
 
import javax.security.auth.callback.CallbackHandler; 
import javax.security.auth.message.AuthException;
import javax.security.auth.message.ClientAuth;
import javax.security.auth.message.MessagePolicy;

/**
 *  <p>A ClientAuthModule secures request messages, and validates received 
 *  response messages.</p>
 *  <p>A module implementation should assume it may be used to secure different 
 *  requests as different clients. A module should also assume it may be used 
 *  concurrently by multiple callers. It is the module implementation�s responsibility 
 *  to properly save and restore any state as necessary. A module that does not need 
 *  to do so may remain completely stateless. </p>
 *  
 *  <p>Every implementation of the interface must provide a public zero argument 
 *  contructor.</p>
 *  
 *  @see ClientAuthContext
 *  @author <a href="mailto:Anil.Saldhana@jboss.org">Anil Saldhana</a>
 *  @author Charlie Lai, Ron Monzillo (Javadoc for JSR-196)</a> 
 *  @since  May 12, 2006 
 *  @version $Revision$
 */
public interface ClientAuthModule extends ClientAuth
{
   /**
    * Get the one or more Class objects representing the message 
    * types supported by the module.
    * @return an array of Class objects where each element defines a message 
    *         type supported by the module. A module should return an array 
    *         containing at least one element. An empty array indicates that the
    *         module will attempt to support any message type. This method never 
    *         returns null.
    */
   public Class[] getSupportedMessageTypes();
   
   /**
    * <p>Initialize this module with request and response message policies to 
    *    enforce, a CallbackHandler, and any module-specific configuration 
    *    properties.</p>
    * <p>The request policy and the response policy must not both be null.</p>
    * 
    * @param requestPolicy the request policy this module must enforce, or null.
    * @param responsePolicy the response policy this module must enforce, or null.
    * @param handler CallbackHandler used to request information.
    * @param options a Map of module-specific configuration properties.
    * @throws AuthException - if module initialization fails, including for the case 
    *                         where the options argument contains elements that are 
    *                         not supported by the module.
    */
   public void initialize(MessagePolicy requestPolicy, MessagePolicy responsePolicy,
         CallbackHandler handler, Map options) throws AuthException; 
}

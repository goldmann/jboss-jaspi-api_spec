package javax.security.auth.message.config;

import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.message.AuthException;

/**
 *  <p>This interface describes a configuration of ServerAuthConfiguration 
 *  objects for a message layer and application context (e.g., the messaging 
 *  context of a specific application, or set of applications).</p>
 *  <p>Implementations of this interface are returned by an AnthConfigProvider. </p>
 *  <p>Callers interact with a ServerAuthConfig to obtain ServerAuthContext 
 *  objects suitable for processing a given message exchange at the layer and 
 *  within the application context of the ServerAuthConfig. Each ServerAuthContext 
 *  object is responsible for instantiating, initializing, and invoking the one 
 *  or more ServerAuthModules encapsulated in the ServerAuthContext.</p>
 *  <p>After having acquired a ServerAuthContext, a caller operates on the context 
 *  to cause it to invoke the encapsulated ServerAuthModules to validate service 
 *  requests and to secure service responses.</p>
 *  
 *  @author <a href="mailto:Anil.Saldhana@jboss.org">Anil Saldhana</a>
 *  @author Charlie Lai, Ron Monzillo (Javadoc for JSR-196)</a> 
 *  @since  May 12, 2006 
 *  @version $Revision$
 */
public interface ServerAuthConfig extends AuthConfig
{
   /**
    * <p>Get a ServerAuthContext instance from this ServerAuthConfig.</p>
    * <p>The implementation of this method returns a ServerAuthContext instance that 
    * encapsulates the ServerAuthModules used to validate requets and secure responses 
    * associated with the given <i>operation</i>.</p>
    * <p>Specifically, this method accesses this ServerAuthConfig object with the argument 
    * operation to determine the ServerAuthModules that are to be encapsulated in the 
    * returned ServerAuthContext instance.</p>
    * <p>The ServerAuthConfig object establishes the request and response MessagePolicy 
    * objects that are passed to the encapsulated modules when they are initialized by 
    * the returned ServerAuthContext instance. It is the modules� responsibility to 
    * enforce these policies when invoked.</p>
    * 
    * @param operation an operation identifier used to index the provided config, or null. 
    *                  This value must be identical to the value returned by the 
    *                  getOperation method for all AuthParam objects passed to the 
    *                  validateRequest method of the returned ServerAuthContext.
    * @param properties a Map object that may be used by the caller to augment the 
    *                  properties that will be passed to the encapsulated modules at 
    *                  module initialization. The null value may be passed for this 
    *                  parameter.
    * @return a ServerAuthContext instance that encapsulates the ServerAuthModules used 
    *                 to secure and validate requests/responses associated with the 
    *                 given operation, or null (indicating that no modules are configured).
    * @throws AuthException if this operation fails.
    */
   public ServerAuthContext getAuthContext(String authContextID,
         Subject serviceSubject, Map properties) throws AuthException;
}

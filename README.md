kerberos-debug-agent
====================

This Java agent enables Kerberos debugging by setting system property sun.security.krb5.debug to true and an internal debug flag inside sun.security.krb5.internal.crypto.dk.DkCrypto to true.

The implementation may not work on all JDKs.

The compiled library is available in release/kerberosDebug-0.1.jar

In order to use it start you application with -javaagent:kerberosDebug-0.1.jar, for example:

java -classpath kerberosDebug-0.1.jar -javaagent:kerberosDebug-0.1.jar Test

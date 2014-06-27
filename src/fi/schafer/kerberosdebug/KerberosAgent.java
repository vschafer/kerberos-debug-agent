package fi.schafer.kerberosdebug;

import sun.security.krb5.internal.crypto.dk.DkCrypto;

import java.lang.instrument.Instrumentation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class KerberosAgent {

    /**
     * Enables Kerberos and DkCrypto debugging.
     */
    public static void premain(String agentArgument, Instrumentation instrumentation) throws Exception {
        System.setProperty("sun.security.krb5.debug", "true");
        setFinalStatic(DkCrypto.class.getDeclaredField("debug"), true);
        System.out.println("Enabled Kerberos debug");
    }

    private static void setFinalStatic(Field field, Object newValue) throws Exception {
        field.setAccessible(true);
        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
        field.set(null, newValue);
    }

}

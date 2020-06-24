package org.jasypt.encryption.pbe;

import org.jasypt.iv.StringFixedIvGenerator;
import org.jasypt.salt.ZeroSaltGenerator;

import junit.framework.TestCase;

public class PBEWITHHMACSHA512ANDAES_256EncryptorTest extends TestCase {

    public void test1() throws Exception {

        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword("test1");
        encryptor.setSaltGenerator(new ZeroSaltGenerator());
        encryptor.setKeyObtentionIterations(10000);
        encryptor.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");
        encryptor.setIvGenerator(new StringFixedIvGenerator("0000000000000000"));
        

        // This will output the following value.
        // C2oB8G27F/4XmqrMLxCIVw==
        String encryptedMsg = encryptor.encrypt("password1");
        System.out.println("Test encr: " + encryptedMsg);
        
        // This is the output of the python script and we try to decrypt it here.
        // 6tCAZbswCh9DZ1EK8utRuA==
        String decryptedMsg = encryptor.decrypt("6tCAZbswCh9DZ1EK8utRuA==");
        System.out.println("Test decr: " + decryptedMsg);
        
        
        assertTrue(decryptedMsg.equals("password1"));
    }
}

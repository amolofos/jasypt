package org.jasypt.encryption.pbe;

import org.jasypt.iv.RandomIvGenerator;
import org.jasypt.salt.ZeroSaltGenerator;

import junit.framework.TestCase;

public class PBEWITHHMACSHA512ANDAES_256EncryptorTest extends TestCase {

    public void test1() throws Exception {

        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword("test1");
        encryptor.setSaltGenerator(new ZeroSaltGenerator());
        encryptor.setKeyObtentionIterations(10000);
        encryptor.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");
        //encryptor.setIvGenerator(new ByteArrayFixedIvGenerator("0000000000000000".getBytes()));
        encryptor.setIvGenerator(new RandomIvGenerator());
        

        // This will output the following value.
        // MDAwMDAwMDAwMDAwMDAwMAtqAfBtuxf+F5qqzC8QiFc=
        String encryptedMsg = encryptor.encrypt("password1");
        System.out.println("Test encr: " + encryptedMsg);
        
        // This is the output of the python script and we try to decrypt it here.
        // MDAwMDAwMDAwMDAwMDAwMKWsWH+Ku37n7ddfj0ayxp8=
        String decryptedMsg = encryptor.decrypt("MDAwMDAwMDAwMDAwMDAwMMltCEyHFIJ7/fLpBcwCJYo=");
        System.out.println("Test decr: " + decryptedMsg);
        
        
        assertTrue(decryptedMsg.equals("password1"));
    }
}

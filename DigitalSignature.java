import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.PrivateKey;
import java.security.Signature;
import java.util.Base64; 

/* KeyPairGenerator → key generation
KeyPair → key container
SHA256withRSA → secure signature algorithm
initSign → sign with private key
initVerify → verify with public key
Base64 → binary to text encoding */

public class DigitalSignature {
    public static void main(String args[]) {

        try {
            // 1. Create KeyPairGenerator
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);

            // 2. Generate KeyPair
            KeyPair pair = keyGen.generateKeyPair();

            // 3. Separate keys
            PublicKey publicKey = pair.getPublic();
            PrivateKey privateKey = pair.getPrivate();

            System.out.println("Public Key: " + publicKey);
            System.out.println("Private Key: " + privateKey);

            // 4. Data to sign
            String data = "welcome to digital signature";

            // 5. Create Signature & sign data
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initSign(privateKey);
            signature.update(data.getBytes());

            byte[] signedData = signature.sign();
            System.out.println("Data signed successfully");

            // Show signed data in Base64
            System.out.println("Signed Data: " + Base64.getEncoder().encodeToString(signedData));

            // 6. Verify signature
            Signature signatureVerify = Signature.getInstance("SHA256withRSA");
            signatureVerify.initVerify(publicKey);
            signatureVerify.update(data.getBytes());

            boolean isVerified = signatureVerify.verify(signedData);

            if (isVerified) {
                System.out.println("Signature verified successfully");
            } else {
                System.out.println("Signature verification failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

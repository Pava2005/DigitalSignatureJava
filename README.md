# Digital Signature Program in Java

This is a simple Java program that explains how a digital signature works using RSA and SHA-256.  
The main aim of this program is to understand how data can be signed and verified securely.

## About the Program
In this program, a public key and private key are generated using the RSA algorithm.  
The private key is used to sign the data, and the public key is used to verify whether the data is original or not.

If the data is changed, the signature verification will fail.  
This ensures data integrity and authenticity.

## Concepts Used
- RSA public key and private key
- SHA-256 hashing
- Digital Signature
- Java Security API
- Base64 encoding

## Steps Performed
1. Generate RSA key pair
2. Sign a text message using the private key
3. Encode the signature using Base64
4. Verify the signature using the public key

## How to Run the Program
1. Compile the file:
   javac DigitalSignature.java
2. Run the program:
   java DigitalSignature

## Output
The program displays:
- Generated public and private keys
- Signed data in Base64 format
- Signature verification result (success or failure)

## Why This Program
This program is useful for beginners to understand how digital signatures work in real applications such as secure communication and authentication systems.

## Author
Pava2005

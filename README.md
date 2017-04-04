# Generates cert

openssl genrsa -out mykey.pem 2048

## Export private key

openssl pkcs8 -topk8 -inform PEM -outform PEM -in mykey.pem -out private_key.pem -nocrypt

## Esport public PEM key

openssl rsa -in private_key.pem -outform PEM -pubout -out public_key.pem

# Generate keys for java (DER)

## Export private key

openssl pkcs8 -topk8 -inform PEM -outform DER -in private_key.pem -out private_key.der -nocrypt

## Export public key

openssl rsa -in private_key.pem -pubout -outform DER -out public_key.der

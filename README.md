# Web3j
 use web3j to develop contract

we will use web3j to develop contract!
first, we should install some software(base on ubuntu server1604)!

java:
> apt-get install default-jdk (jdk 1.8)

solc:
> apt-get install solc (solc 4.2.6+)

get web3j:
> wget  https://github.com/web3j/web3j/releases/download/v3.3.1/web3j-3.3.1.tar

build solc:
> solc --abi --bin --optimize -o solc-output Deno.sol //Deno.sol is my contract

get solc-java:
> ./web3j solidity generate solc-output/Deno_sol_Deno.bin solc-output/Deno_sol_Deno.abi -o /root/eclipse-workspace/Web3j -p src.web3j
web3j is command in web3j-3.3.1, and we should modify path of package in Deno_sol_deno.java

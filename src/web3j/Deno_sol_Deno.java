package web3j;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Int256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tuples.generated.Tuple4;
import org.web3j.tuples.generated.Tuple6;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.3.1.
 */
public class Deno_sol_Deno extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b6118238061001e6000396000f3006060604052600436106100a35763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416632de4a1bf81146100a857806352da6ea8146100d25780635bce2471146100f4578063602b386e1461019757806371fa0a0c1461029e5780638a1d85e81461030b578063a41e095d14610436578063a5faa12514610616578063f415eb71146106a0578063f6da629b146106d7575b600080fd5b34156100b357600080fd5b6100d0600160a060020a03600435811690602435166044356106f6565b005b34156100dd57600080fd5b6100d0600160a060020a0360043516602435610a16565b34156100ff57600080fd5b6100d060046024813581810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284378201915050505050509190803590602001908201803590602001908080601f01602080910402602001604051908101604052818152929190602084018383808284375094965050600160a060020a0385351694602001359350610a9492505050565b34156101a257600080fd5b6101b6600160a060020a0360043516610b68565b604051808060200180602001848152602001838103835286818151815260200191508051906020019080838360005b838110156101fd5780820151838201526020016101e5565b50505050905090810190601f16801561022a5780820380516001836020036101000a031916815260200191505b50838103825285818151815260200191508051906020019080838360005b83811015610260578082015183820152602001610248565b50505050905090810190601f16801561028d5780820380516001836020036101000a031916815260200191505b509550505050505060405180910390f35b34156102a957600080fd5b6102bd600160a060020a0360043516610cf3565b60405180806020018581526020018481526020018381526020018281038252868181518152602001915080519060200190808383600083811015610260578082015183820152602001610248565b341561031657600080fd5b6100d060046024813581810190830135806020601f820181900481020160405190810160405281815292919060208401838380828437509496863596602080820135600160a060020a03169750919550606081019450604090810135860180830194503592508291601f83018190048102019051908101604052818152929190602084018383808284378201915050505050509190803590602001908201803590602001908080601f01602080910402602001604051908101604052818152929190602084018383808284378201915050505050509190803590602001908201803590602001908080601f0160208091040260200160405190810160405281815292919060208401838380828437509496505093359350610e0392505050565b341561044157600080fd5b610455600160a060020a0360043516610f66565b604051808060200187815260200180602001806020018060200186815260200185810385528b818151815260200191508051906020019080838360005b838110156104aa578082015183820152602001610492565b50505050905090810190601f1680156104d75780820380516001836020036101000a031916815260200191505b50858103845289818151815260200191508051906020019080838360005b8381101561050d5780820151838201526020016104f5565b50505050905090810190601f16801561053a5780820380516001836020036101000a031916815260200191505b50858103835288818151815260200191508051906020019080838360005b83811015610570578082015183820152602001610558565b50505050905090810190601f16801561059d5780820380516001836020036101000a031916815260200191505b50858103825287818151815260200191508051906020019080838360005b838110156105d35780820151838201526020016105bb565b50505050905090810190601f1680156106005780820380516001836020036101000a031916815260200191505b509a505050505050505050505060405180910390f35b341561062157600080fd5b61062961124a565b60405160208082528190810183818151815260200191508051906020019080838360005b8381101561066557808201518382015260200161064d565b50505050905090810190601f1680156106925780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34156106ab57600080fd5b6106c5600160a060020a036004351660243560443561128c565b60405190815260200160405180910390f35b34156106e257600080fd5b6106c5600160a060020a036004351661140e565b6000806000806000806107076115cd565b6000881361071457600080fd5b600160a060020a038a8116908a16141561072d57600080fd5b89600160a060020a031633600160a060020a03161415151561074e57600080fd5b88600160a060020a031633600160a060020a03161415151561076f57600080fd5b600160a060020a03808a166000818152600260205260409020600601549091161461079957600080fd5b600160a060020a0389166000908152600260205260408120600781015460059091015403975087136107ca57600080fd5b600160a060020a038a1660009081526003602081905260409091200154889012156107f457600080fd5b86880395506000861315610806578697505b600160a060020a03808b16600090815260036020818152604080842092830180548e900390558d851684526002808352818520938101549095168452600490915291829020549201965089955060019190910193508492506080905190810160405280868054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156108fe5780601f106108d3576101008083540402835291602001916108fe565b820191906000526020600020905b8154815290600101906020018083116108e157829003601f168201915b5050509183525050602080820187905260408083018790526060909201859052600160a060020a03808e166000908152600383528381206002015490911681526004909152208054919250906001810161095883826115fc565b6000928352602090922083916004020181518190805161097c92916020019061162d565b50602082015181600101556040820151816002015560608201516003909101555050600160a060020a03891660009081526002602052604090206007810180548a0190556008018054600181016109d383826116ab565b506000918252602090912001805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a039b909b169a909a17909955505050505050505050565b60008113610a2357600080fd5b81600160a060020a031633600160a060020a031614151515610a4457600080fd5b600160a060020a0380831660008181526003602052604090206002015490911614610a6e57600080fd5b600160a060020a0390911660009081526003602081905260409091200180549091019055565b60008113610aa157600080fd5b600160a060020a038083166000818152600360205260409020600201549091161415610acc57600080fd5b600160a060020a038216600081815260036020526040902060028101805473ffffffffffffffffffffffffffffffffffffffff1916909217909155600101838051610b1b92916020019061162d565b50600160a060020a0382166000908152600360205260409020848051610b4592916020019061162d565b50600160a060020a03909116600090815260036020819052604090912001555050565b610b706116cf565b610b786116cf565b600160a060020a038084166000818152600360205260408120600281015491939092911614610ba657600080fd5b806000018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610c3e5780601f10610c1357610100808354040283529160200191610c3e565b820191906000526020600020905b815481529060010190602001808311610c2157829003601f168201915b50505050509350806001018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610cdd5780601f10610cb257610100808354040283529160200191610cdd565b820191906000526020600020905b815481529060010190602001808311610cc057829003601f168201915b5050505050925080600301549150509193909250565b610cfb6116cf565b600160a060020a03821660009081526004602052604081208054829182918290819011610d2757600080fd5b816000815481101515610d3657fe5b90600052602060002090600402019050806000018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610dde5780601f10610db357610100808354040283529160200191610dde565b820191906000526020600020905b815481529060010190602001808311610dc157829003601f168201915b5050505050955080600101549450806002015493508060030154925050509193509193565b84600160a060020a031633600160a060020a031614151515610e2457600080fd5b60008113610e3157600080fd5b600160a060020a038086166000818152600260205260409020600601549091161415610e5c57600080fd5b600160a060020a0385166000908152600260205260409020878051610e8592916020019061162d565b50600160a060020a03851660009081526002602081905260409091206001810188905501848051610eba92916020019061162d565b50600160a060020a0385166000908152600260205260409020600301838051610ee792916020019061162d565b50600160a060020a0385166000908152600260205260409020600401828051610f1492916020019061162d565b50600160a060020a039094166000818152600260205260408120600581019690965560078601556006909401805473ffffffffffffffffffffffffffffffffffffffff19169094179093555050505050565b610f6e6116cf565b6000610f786116cf565b610f806116cf565b610f886116cf565b600160a060020a038087166000818152600260205260408120600681015491939092911614610fb657600080fd5b806000018054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561104e5780601f106110235761010080835404028352916020019161104e565b820191906000526020600020905b81548152906001019060200180831161103157829003601f168201915b5050505050965080600101549550806002018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156110f45780601f106110c9576101008083540402835291602001916110f4565b820191906000526020600020905b8154815290600101906020018083116110d757829003601f168201915b50505050509450806003018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156111935780601f1061116857610100808354040283529160200191611193565b820191906000526020600020905b81548152906001019060200180831161117657829003601f168201915b50505050509350806004018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156112325780601f1061120757610100808354040283529160200191611232565b820191906000526020600020905b81548152906001019060200180831161121557829003601f168201915b50505050509250806005015491505091939550919395565b6112526116cf565b60408051908101604052600781527f416c6c656e636500000000000000000000000000000000000000000000000000602082015290505b90565b6000808080841361129c57600080fd5b85600160a060020a031633600160a060020a0316141515156112bd57600080fd5b600160a060020a03808716600081815260036020526040902060020154909116146112e757600080fd5b5050600160a060020a038085166000908152600360209081526040808320600201549093168252600490529081205b80548210156113ff5784818381548110151561132e57fe5b90600052602060002090600402016002015414156113f457808281548110151561135457fe5b90600052602060002090600402016003015460001415151561137557600080fd5b83818381548110151561138457fe5b906000526020600020906004020160030154121515156113a357600080fd5b8381838154811015156113b257fe5b60009182526020909120600360049092020101805491909103905580548190839081106113db57fe5b9060005260206000209060040201600201549250611405565b600182019150611316565b60001992505b50509392505050565b60008080808061141f6001826115fc565b50600061142c81806116ab565b5084600160a060020a031633600160a060020a03161415151561144e57600080fd5b600160a060020a0380861660008181526002602052604090206006015490911614156114a257600160a060020a0385166000908152600260205260408120600801805461149c9291906116e1565b5061150d565b600160a060020a03808616600081815260036020526040902060020154909116141561150d5760008054600181016114da83826116ab565b506000918252602090912001805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0387161790555b600080541161151b57600080fd5b600092505b6000548310156115c557600091506004600060036000808781548110151561154457fe5b6000918252602080832090910154600160a060020a0390811684528382019490945260409283018220600201549093168452918301939093529101902090505b80548210156115ba57808281548110151561159b57fe5b9060005260206000209060040201600201549350600182019150611584565b600183019250611520565b505050919050565b6080604051908101604052806115e16116cf565b81526020016000815260200160008152602001600081525090565b81548183558181151161162857600402816004028360005260206000209182019101611628919061172d565b505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061166e57805160ff191683800117855561169b565b8280016001018555821561169b579182015b8281111561169b578251825591602001919060010190611680565b506116a7929150611765565b5090565b81548183558181151161162857600083815260209020611628918101908301611765565b60206040519081016040526000815290565b8280548282559060005260206000209081019282156117215760005260206000209182015b82811115611721578254825591600101919060010190611706565b506116a792915061177f565b61128991905b808211156116a757600061174782826117b0565b50600060018201819055600282018190556003820155600401611733565b61128991905b808211156116a7576000815560010161176b565b61128991905b808211156116a757805473ffffffffffffffffffffffffffffffffffffffff19168155600101611785565b50805460018160011615610100020316600290046000825580601f106117d657506117f4565b601f0160209004906000526020600020908101906117f49190611765565b505600a165627a7a723058207d41ff92d1476b6484dbc5c4e2a9ab7163677309cb31ec9d401a1d856b51e3810029";

    protected Deno_sol_Deno(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Deno_sol_Deno(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<TransactionReceipt> donate_to_project(String fromAddr, String toAddr, BigInteger amount) {
        final Function function = new Function(
                "donate_to_project", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(fromAddr), 
                new org.web3j.abi.datatypes.Address(toAddr), 
                new org.web3j.abi.datatypes.generated.Int256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> add_user_balance(String user_address, BigInteger amount) {
        final Function function = new Function(
                "add_user_balance", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(user_address), 
                new org.web3j.abi.datatypes.generated.Int256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> create_user(String donate_user_name, String donate_user_phone, String donate_user_addr, BigInteger user_balance) {
        final Function function = new Function(
                "create_user", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(donate_user_name), 
                new org.web3j.abi.datatypes.Utf8String(donate_user_phone), 
                new org.web3j.abi.datatypes.Address(donate_user_addr), 
                new org.web3j.abi.datatypes.generated.Int256(user_balance)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple3<String, String, BigInteger>> getUsers(String userAddres) {
        final Function function = new Function("getUsers", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(userAddres)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Int256>() {}));
        return new RemoteCall<Tuple3<String, String, BigInteger>>(
                new Callable<Tuple3<String, String, BigInteger>>() {
                    @Override
                    public Tuple3<String, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<String, String, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue());
                    }
                });
    }

    public RemoteCall<Tuple4<String, BigInteger, BigInteger, BigInteger>> getBill(String billAddress) {
        final Function function = new Function("getBill", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(billAddress)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Int256>() {}, new TypeReference<Int256>() {}, new TypeReference<Int256>() {}));
        return new RemoteCall<Tuple4<String, BigInteger, BigInteger, BigInteger>>(
                new Callable<Tuple4<String, BigInteger, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple4<String, BigInteger, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<String, BigInteger, BigInteger, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> create_project(String donate_type, BigInteger donate_id, String project_address, String donate_name, String donate_object_id, String commander_name, BigInteger donate_aim_balance) {
        final Function function = new Function(
                "create_project", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(donate_type), 
                new org.web3j.abi.datatypes.generated.Int256(donate_id), 
                new org.web3j.abi.datatypes.Address(project_address), 
                new org.web3j.abi.datatypes.Utf8String(donate_name), 
                new org.web3j.abi.datatypes.Utf8String(donate_object_id), 
                new org.web3j.abi.datatypes.Utf8String(commander_name), 
                new org.web3j.abi.datatypes.generated.Int256(donate_aim_balance)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple6<String, BigInteger, String, String, String, BigInteger>> getProjects(String projectAddress) {
        final Function function = new Function("getProjects", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(projectAddress)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Int256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Int256>() {}));
        return new RemoteCall<Tuple6<String, BigInteger, String, String, String, BigInteger>>(
                new Callable<Tuple6<String, BigInteger, String, String, String, BigInteger>>() {
                    @Override
                    public Tuple6<String, BigInteger, String, String, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple6<String, BigInteger, String, String, String, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (String) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue());
                    }
                });
    }

    public RemoteCall<String> getAuthor() {
        final Function function = new Function("getAuthor", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> print_bill(String user_address, BigInteger bill_id, BigInteger amount) {
        final Function function = new Function(
                "print_bill", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(user_address), 
                new org.web3j.abi.datatypes.generated.Int256(bill_id), 
                new org.web3j.abi.datatypes.generated.Int256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> get_log(String get_address) {
        final Function function = new Function(
                "get_log", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(get_address)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<Deno_sol_Deno> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Deno_sol_Deno.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Deno_sol_Deno> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Deno_sol_Deno.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static Deno_sol_Deno load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Deno_sol_Deno(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Deno_sol_Deno load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Deno_sol_Deno(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}

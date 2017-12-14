package uxfac.noh;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    List<block> blockchain = new ArrayList<block>();

    public static void main(String[] args) throws NoSuchAlgorithmException {


        String[] transactions = {"Hosang sent 1k Bitcoins to Zuckerberg."};
        block genesisBlock = new block(new blockHeader(null, transactions), transactions);
        System.out.println("Block Hash : " + genesisBlock.getBlockHash());

        // Transaction Forgery
        transactions[0] = "Hosang sent 10k Bitcoins to Zuckerberg.";
        genesisBlock = new block(new blockHeader(null, transactions), transactions);
        System.out.println("Block Hash : " + genesisBlock.getBlockHash());

        // Second block
        String[] secondTransactions = {"Zuckerberg sent 500 Bitcoins to Hosang."};
        block secondBlock = new block(new blockHeader(genesisBlock.getBlockHash().getBytes(), secondTransactions), secondTransactions);
        System.out.println("Second Block Hash : " + secondBlock.getBlockHash());

        // Third block
        String[] thirdTransactions = {"Hosang sent 500 Bitcoins to Moon."};
        block thirdBlock = new block(new blockHeader(secondBlock.getBlockHash().getBytes(), thirdTransactions), thirdTransactions);
        System.out.println("Third Block Hash : " + thirdBlock.getBlockHash());

        /*String temp;
        temp = sha256.sha256("test");
        System.out.println(temp);
        temp = sha256.sha256("test.");
        System.out.println(temp);
        */
    }

}

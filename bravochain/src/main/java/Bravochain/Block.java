package Bravochain;

import Bravochain.Utils.StringUtil;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.Date;

public class Block {
    private String selfHash;
    private Data data;
    private String prevHash;
    private long timastamp;
    private int nonce;

    public Block(Data data, String prevHash) {
        this.data = data;
        this.prevHash = prevHash;
        this.timastamp = new Date().getTime();
        this.nonce = 0;

        this.selfHash = culculateHash();
    }

    public String getSelfHash() {
        return selfHash;
    }

    public Data getData() {
        return data;
    }

    public String getPrevHash() {
        return prevHash;
    }

    private String culculateHash() {
        return Hashing.sha256()
                .hashString(prevHash +
                        data.getData() +
                        timastamp +
                        nonce, StandardCharsets.UTF_8)
                .toString();
    }

    void mine(int difficulty) {
        String target = StringUtil.difficaltyToString(difficulty);
        long startTime = System.nanoTime();

        while (!selfHash.substring(0, difficulty).equals(target)) {
            nonce++;
            selfHash = culculateHash();
        }

        long endTime = System.nanoTime();
        System.out.println(String.format("Block mined for %f sec",
                StringUtil.fromNanosecondToSecond(endTime - startTime)));
    }
}

package Bravochain;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class Bravochain {
    private static int difficulty = 5;
    private Block lastBlock;

    public static void main(String... args) {
        String sha256hex = Hashing.sha256()
                .hashString("hello, world", StandardCharsets.UTF_8)
                .toString();

        System.out.println(sha256hex);

        System.out.println(String.valueOf(new char[difficulty]).replace("\0", "0"));
    }

    /**
     * Create genesis block
     */
    private void createChain() {
        addBlock(new Block(new Data("Genesis block"), "0"));
    }

    /**
     * Add new block in blockchain
     * @param newBlock is new block
     */
    private void addBlock(Block newBlock) {
        if (newBlock != null) {
            newBlock.mine(difficulty);
            lastBlock = newBlock;
        }
    }
}

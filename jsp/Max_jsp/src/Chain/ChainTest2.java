package Chain;

import java.util.ArrayList;

import com.google.gson.GsonBuilder;

public class ChainTest2 {
	public static ArrayList<Block> blockchain = new ArrayList<>();
	
	public static void main(String args[]) {
		blockchain.add(new Block("2000","0"));
		blockchain.add(new Block("3000",blockchain.get(blockchain.size()-1).hash));
		blockchain.add(new Block("5000",blockchain.get(blockchain.size()-1).hash));
		String jsonBlockChain 
					= new GsonBuilder().setPrettyPrinting()
										.create().toJson(blockchain);
		System.out.println(jsonBlockChain);
	}
}

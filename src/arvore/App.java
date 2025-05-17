package arvore;

public class App {

	public static void main(String[] args) {
			BinaryTree bt = new BinaryTree();
			
			bt.insert(6);
			bt.insert(8);
			bt.insert(2);
			bt.insert(4);
			bt.insert(4);
			bt.print(-1);
			System.out.println("\nApós remoção: ");
			bt.remove(4);
			bt.print(1);
			
	}

}

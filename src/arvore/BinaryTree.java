package arvore;

public class BinaryTree {

	private BinaryNode root;

	class BinaryNode {
		private int element;
		private BinaryNode left;
		private BinaryNode right;
		private int qtd;

		BinaryNode(int element, BinaryNode left, BinaryNode right) {
			this.element = element;
			this.left = left;
			this.right = right;
			this.qtd = 1;
		}
	}

	public BinaryTree() {
		root = null;
	}

	public void clear() {
		root = null;
	}

	public boolean isEmpty() {
		return (root == null);
	}

	public boolean find(int valor) {
		return find(valor, root) != null;
	}

	public BinaryNode find(int valor, BinaryNode no) {
		if (no == null) {
			return null;
		} else if (valor < no.element) {
			return find(valor, no.left);
		} else if (valor > no.element) {
			return find(valor, no.right);
		} else {
			return no;
		}
	}

	public int findMin() throws Exception {
		if (isEmpty()) {
			throw new Exception("Sem valor mínimo(Árvore vazia)");
		}
		return findMin(root).element;
	}

	public BinaryNode findMin(BinaryNode no) {
		if (no.left == null) {
			return no;
		}
		return findMin(no.left);
	}

	public int findMax() throws Exception {
		if (isEmpty()) {
			throw new Exception("Sem valor Máximo (Árvore vazia)");
		}
		return findMax(root).element;
	}

	public BinaryNode findMax(BinaryNode no) {
		if (no.right == null) {
			return no;
		}
		return findMax(no.right);
	}

	public void insert(int valor) {
		root = insert(valor, root);
	}

	public BinaryNode insert(int valor, BinaryNode no) {
		if (no == null) {
			return new BinaryNode(valor, null, null);
		}
		if (valor < no.element) {
			no.left = insert(valor, no.left);

		} else if (valor > no.element) {
			no.right = insert(valor, no.right);
		} else {
			no.qtd = no.qtd + 1;
		}
		return no;
	}

	public void remove(int valor) {
		root = remove(valor, root);
	}

	public BinaryNode remove(int valor, BinaryNode no) {
		if (no == null) {
			return null;
		}
		if (valor < no.element) {
			no.left = remove(valor, no.left);
		} else if (valor > no.element) {
			no.right = remove(valor, no.right);
		} else if (no.left != null && no.right != null) {
			no.element = findMin(no.right).element;
			no.right = remove(no.element, no.right);
		} else if (no.left != null) {
			no = (no.left != null) ? no.left : no.right;
		} else {
			no.qtd = no.qtd -1;
		}
		return no;
	}

	public void print_em_ordem(BinaryNode no) {
		if (no != null) {
			print_em_ordem(no.left);
			System.out.print(no.element+"("+no.qtd+")" + ", ");
			print_em_ordem(no.right);
		}
	}

	public void print_pos_ordem(BinaryNode no) {
		if (no != null) {
			System.out.print(no.element+"("+no.qtd+")" + ", ");
			print_pos_ordem(no.left);
			print_pos_ordem(no.right);
		}
	}

	public void print(int valor) {
		if (valor == 1) {
			System.out.println("Saida em ordem: ");
			print_em_ordem(root);
		} else if (valor == -1) {
			System.out.println("Lista pós-ordem: ");
			print_pos_ordem(root);
		} else {
			System.out.println("Use os argumentos -1 e 1");
		}
	}
}
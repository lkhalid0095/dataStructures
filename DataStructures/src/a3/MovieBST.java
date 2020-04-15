package a3;

public class MovieBST {

	Movie root;

	public void addNode(String key, int year) {

		Movie newNode = new Movie(key, year);

		if(root == null) {

			root = newNode;
		} else {

			Movie temp = root;

			Movie parent; 

			while(true) {
				parent = temp;
				//checks if the String is smaller then the title
				//for alphabetical purposes
				if(key.compareTo(temp.title)<0) {

					temp = temp.left;

					//if the left child is empty you add the new node
					if(temp == null) {

						parent.left = newNode;
						return;
					}
				} else {
					//if the right child is empty add the new node here
					temp = temp.right;
					
					if(temp == null) {
						parent.right = newNode;
						return;
					}
				}
			}
		}
	}
    void printInorder(Movie node) 
    { 
    	
    
    	
        if (node == null) 
            return; 
  
        /* first recur on left child */
        printInorder(node.left); 
  
        /* then print the data of node */
        System.out.print(node.title + " "); 
  
        /* now recur on right child */
        printInorder(node.right); 
    } 

	public void subSet(Movie node, String start, String end) {

		
	}
}

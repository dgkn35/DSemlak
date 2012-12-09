
public class tree {
	private kisiNode root;
	public int sayac=0;
    public int duzey,duzeytop=0,derinlik;
	
	public tree()//Constructor
	{
		root=null;
	}
	
	public kisiNode find(kisiNode bir_node)//Arama
	{
		kisiNode current=root;
		while(current.getAd()!=bir_node.getAd())
		{
			
			if(bir_node.getAd().compareTo(current.getAd())<0)
				current=current.leftchild;
	
			else
				current=current.rightchild;
				
			if (current==null)
				return null;
			
		}
		
		return current;
	}
	
	public void ekle(kisiNode bir_node)
	{
		if(root==null)
		{
	        root=bir_node;
		}
		else
		{
			kisiNode parent;
			kisiNode current=root;
			
			while (true)
            {
                parent=current;
                if(current.getAd().compareTo(bir_node.getAd())<0)
                {
                	current=current.leftchild;
                	if(current==null)
                	{
                		parent.leftchild=bir_node;
                		return;
                	}
                	   
                }
                else
                {
                	current=current.rightchild;
                	if(current==null)
                	{
                		parent.rightchild=bir_node;
                		return;
                	}   	   
                }
            } 	
		}
	}
	
	public boolean sil(String isim){
		kisiNode current = root;
	      kisiNode parent = root;
	      boolean isLeftChild = true;

	      while(current.getAd().compareTo(isim) !=0 )        // search for node
	         {
	         parent = current;
	         if(current.getAd().compareTo(isim)>0)         // go left?
	            {
	            isLeftChild = true;
	            current = current.leftchild;
	            }
	         else                            // or go right?
	            {
	            isLeftChild = false;
	            current = current.rightchild;
	            }
	         if(current == null)             // end of the line,
	            return false;                // didn't find it
	         }  // end while
	      // found node to delete

	      // if no children, simply delete it
	      if(current.leftchild==null && current.rightchild==null)
	         {
	         if(current == root)             // if root,
	            root = null;                 // tree is empty
	         else if(isLeftChild)
	            parent.leftchild = null;     // disconnect
	         else                            // from parent
	            parent.rightchild = null;
	         }

	      // if no right child, replace with left subtree
	      else if(current.rightchild==null)
	         if(current == root)
	            root = current.leftchild;
	         else if(isLeftChild)
	            parent.leftchild = current.leftchild;
	         else
	            parent.rightchild = current.leftchild;

	      // if no left child, replace with right subtree
	      else if(current.leftchild==null)
	         if(current == root)
	            root = current.rightchild;
	         else if(isLeftChild)
	            parent.leftchild = current.rightchild;
	         else
	            parent.rightchild = current.rightchild;

	      else  // two children, so replace with inorder successor
	         {
	         // get successor of node to delete (current)
	         kisiNode successor = getSuccessor(current);

	         // connect parent of current to successor instead
	         if(current == root)
	            root = successor;
	         else if(isLeftChild)
	            parent.leftchild = successor;
	         else
	            parent.rightchild = successor;

	         // connect successor to current's left child
	         successor.leftchild = current.leftchild;
	         }  // end else two children
	      // (successor cannot have a left child)
	      return true;                                // success
	      }  // end delete()
	
	private kisiNode getSuccessor(kisiNode delNode)
    {
    kisiNode successorParent = delNode;
    kisiNode successor = delNode;
    kisiNode current = delNode.rightchild;   // go to right child
    while(current != null)               // until no more
       {                                 // left children,
       successorParent = successor;
       successor = current;
       current = current.leftchild;      // go to left child
       }
                                         // if successor not
    if(successor != delNode.rightchild)  // right child,
       {                                 // make connections
       successorParent.leftchild = successor.rightchild;
       successor.rightchild = delNode.rightchild;
       }
    return successor;
    }
	
	public void preOrder(kisiNode localRoot)
	{
		if(localRoot!=null)
		{
			//display sonra yapılcak
			preOrder(localRoot.leftchild);
			preOrder(localRoot.rightchild);
			bulmaca();
		}
	}
	
	public void inOrder(kisiNode localRoot)
	{
		if(localRoot!=null)
		{
			inOrder(localRoot.leftchild);
			//display sonra yapılcak
			inOrder(localRoot.rightchild);
			bulmaca();
		}
	}
	
	public void postOrder(kisiNode localRoot)
	{
		if(localRoot!=null)
		{
			postOrder(localRoot.leftchild);
			postOrder(localRoot.rightchild);
			//display sonra yapılcak
			bulmaca();
		}
	}
	
	public void agacBilgiTopla(kisiNode etkin)
	{
		if(etkin!=null)
		{
			duzey++;
			agacBilgiTopla(etkin.leftchild);
			sayac++;
			if(duzey>derinlik)
				derinlik=duzey;
			duzeytop+=duzey;
			agacBilgiTopla(etkin.rightchild);
			duzey--;
		}
	}
	
	public void bulmaca()
	{
		duzey=-1;
		derinlik=-1;
		sayac=0;
		agacBilgiTopla(root);
		System.out.println("Eleman sayisi = " + sayac);
		System.out.println("Derinlik      = " + derinlik);
		System.out.println("Ort. derinlik = " + (float)duzeytop/sayac);
	}
	
}

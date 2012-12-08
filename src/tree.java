
public class tree {
	private kisiNode root;
	public int sayac=0;
    public int duzey,duzeytop=0,derinlik;
	
	public tree()
	{
		root=null;
	}
	
	public kisiNode find(kisiNode bir_node)
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

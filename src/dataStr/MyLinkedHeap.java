package dataStr;

public class MyLinkedHeap<Type> {
	private MyHeapNode root = null;
	private int counter = 0;
	private MyHeapNode lastParent = null;
	
	//TODO uzrakstīt dokumentāciju koemntārus
	
	public boolean isFull()
	{
		try
		{
			MyHeapNode temp = new MyHeapNode<>((Type)new Object());
			return false;
		}
		catch (OutOfMemoryError e) {
			return true;
		}
	}
	public boolean isEmpty()
	{
		return (counter==0);
	}
	
	public int size()
	{
		return counter;
	}
	public void makeEmpty()
	{
		root = null;
		counter = 0;
		lastParent = null;
		System.gc();
	}
	
	public Type dequeue() throws Exception
	{
		if(isEmpty())
			throw new Exception("Kaudze ir tukša, tāpēc nevaar neko izdzēst");
		
		Type result = (Type) root.getElementValue();
		
		if(counter==1)
		{
			makeEmpty();
			return result;
		}
		else
		{
			//1. paņemt pēdejo elementu un to ielikt kā root
			MyHeapNode lastNode = getLastNode();
			root.setElementValue(lastNode.getElementValue());
			//2. dzēst pēdejo mezglu
			deleteLastNode();
			//2.1. noskaidrot nākamo šo lastParent
			
			//3.reheapDown funkcijas izsaukums
			//4. samazināt counter par 1
			
			return result;
		}
		
	}
	private MyHeapNode getLastNode()
	{
		if(lastParent.getRightCh()!=null)
		{
			return lastParent.getRightCh();
		}
		else
		{
			return lastParent.getLeftCh();
		}
	}
	
	private void deleteLastNode()
	{
		if(lastParent.getRightCh()!=null)
		{
			lastParent.setRightCh(null); //iznīcinam saiti no vecāku puses uz labo bēŗnu
		}
		else
		{
			lastParent.setLeftCh(null);//iznīcinam saiti no vecāku puses uz kreiso bērnu
		}
	}
	
	private void identifyPreviousLastParent()
	{
		//1. vecākam ir izdzest labais bērns, bet kreisais paliek, 
		//līdz ar to lastParent pliek kā lastParent
		if(lastParent.getLeftCh()!=null && lastParent.getRightCh()==null)
		{
			
		}
		else if(lastParent.getLeftCh()==null && lastParent.getRightCh()==null)
		{
			//noskidrot vecku šim lastParent
			MyHeapNode parentTemp = lastParent.getParent();
			//2. lastparent vairāk bērnu nav, td jānoskaidro, vai lastParent ir pats kā kreisai vai labais bērns
			if(parentTemp.getLeftCh() == lastParent) //lastParent ir kā kreisais bērns
			{
				//2.2. ja lastPrent ir kreisais bērns, td nākaiams laastParent vais nebšū brālis, 
				//bet būs jāmeklē tuvākais labāis bērns caur kreio pusi
			}
			else //lastParent ir kā labais bērns
			{
				//2.1 ja lastParent ir labais bērns, tad nākamais lastParent būs šī mezgla brālis kreisajā pusē
				lastParent = parentTemp.getLeftCh();
			}
			
				
		}
	}
	
}

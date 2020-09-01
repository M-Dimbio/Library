
public class FileExistsException extends Exception  
{
	
	public FileExistsException() 
	{
		super("Exception: There is already an existing file for that author. File will be renamed as BU, and older BU files will be deleted!");
	}
	/**
	 * @param msg send the message
	 */
	public FileExistsException(String msg) 
	{
		super (msg);
	}
}

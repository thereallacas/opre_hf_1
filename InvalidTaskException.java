package opre_hf_01;

public class InvalidTaskException extends Exception {
	public InvalidTaskException(String msg){
		super(msg+"   Wrong parameters confirm?");
	}
}

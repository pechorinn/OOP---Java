package employee;

import docs.SecretDocument;

public interface IHandleSecretDocs {

	public default void getPassword(SecretDocument doc) {
            System.out.println(doc.getPassword());
	}
	
	
}

package Model;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Client.class)
public abstract class Client_ {

	public static volatile SingularAttribute<Client, String> firstName;
	public static volatile SingularAttribute<Client, String> lastName;
	public static volatile SingularAttribute<Client, String> personalID;
	public static volatile SingularAttribute<Client, Address> address;
	public static volatile SingularAttribute<Client, Boolean> archive;
	public static volatile SingularAttribute<Client, Long> id;
	public static volatile SingularAttribute<Client, Integer> age;
	public static volatile SingularAttribute<Client, Integer> currentRents;

	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String PERSONAL_ID = "personalID";
	public static final String ADDRESS = "address";
	public static final String ARCHIVE = "archive";
	public static final String ID = "id";
	public static final String AGE = "age";
	public static final String CURRENT_RENTS = "currentRents";

}


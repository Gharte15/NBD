package Model;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDateTime;
import javax.annotation.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Rent.class)
public abstract class Rent_ {

	public static volatile SingularAttribute<Rent, Item> item;
	public static volatile SingularAttribute<Rent, Double> rentCost;
	public static volatile SingularAttribute<Rent, Client> client;
	public static volatile SingularAttribute<Rent, Long> id;
	public static volatile SingularAttribute<Rent, LocalDateTime> beginTime;
	public static volatile SingularAttribute<Rent, LocalDateTime> endTime;

	public static final String ITEM = "item";
	public static final String RENT_COST = "rentCost";
	public static final String CLIENT = "client";
	public static final String ID = "id";
	public static final String BEGIN_TIME = "beginTime";
	public static final String END_TIME = "endTime";

}


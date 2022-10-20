package Model;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Item.class)
public abstract class Item_ {

	public static volatile SingularAttribute<Item, String> creator;
	public static volatile SingularAttribute<Item, Boolean> rented;
	public static volatile SingularAttribute<Item, String> releaseDate;
	public static volatile SingularAttribute<Item, String> genre;
	public static volatile SingularAttribute<Item, Boolean> archive;
	public static volatile SingularAttribute<Item, Long> id;
	public static volatile SingularAttribute<Item, String> title;
	public static volatile SingularAttribute<Item, Integer> version;
	public static volatile SingularAttribute<Item, Double> basePrice;

	public static final String CREATOR = "creator";
	public static final String RENTED = "rented";
	public static final String RELEASE_DATE = "releaseDate";
	public static final String GENRE = "genre";
	public static final String ARCHIVE = "archive";
	public static final String ID = "id";
	public static final String TITLE = "title";
	public static final String VERSION = "version";
	public static final String BASE_PRICE = "basePrice";

}


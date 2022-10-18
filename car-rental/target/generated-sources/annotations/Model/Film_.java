package Model;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Film.class)
public abstract class Film_ extends Model.Item_ {

	public static volatile SingularAttribute<Film, String> duration;
	public static volatile SingularAttribute<Film, AgeCategory> category;

	public static final String DURATION = "duration";
	public static final String CATEGORY = "category";

}


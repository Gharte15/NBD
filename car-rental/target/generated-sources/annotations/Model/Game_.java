package Model;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Game.class)
public abstract class Game_ extends Model.Item_ {

	public static volatile SingularAttribute<Game, AgeCategory> category;
	public static volatile SingularAttribute<Game, String> platform;

	public static final String CATEGORY = "category";
	public static final String PLATFORM = "platform";

}


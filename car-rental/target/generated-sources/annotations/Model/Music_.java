package Model;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Music.class)
public abstract class Music_ extends Model.Item_ {

	public static volatile SingularAttribute<Music, String> duration;
	public static volatile SingularAttribute<Music, String> album;

	public static final String DURATION = "duration";
	public static final String ALBUM = "album";

}


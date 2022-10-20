package Model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class ClientTypeConverter implements AttributeConverter<ClientType, String> {

    @Override
    public String convertToDatabaseColumn(ClientType clientType) {
        return clientType.toString();
    }

    @Override
    public ClientType convertToEntityAttribute(String s) {
        if (s.equals("Premium")) {
            return new Premium();
        }
        if (s.equals("Normal")) {
            return new Normal();
        }
        return null;
    }
}
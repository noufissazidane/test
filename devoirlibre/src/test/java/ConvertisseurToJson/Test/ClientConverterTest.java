package ConvertisseurToJson.Test;




import com.exemple.devoirlibre.client;
import ConvertisseurToJson.ClientConverter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClientConverterTest {

    @Test
    public void testToJson() {
        client client = new client(1, "Dupont", "Jean", "123 Rue de la République", "0123456789", "jean.dupont@example.com");
        String json = ClientConverter.toJson(client);
        assertNotNull(json);
        assertTrue(json.contains("Dupont"));
    }

    @Test
    public void testFromJson() {
        String json = "{\"numClient\":1,\"nom\":\"Dupont\",\"prenom\":\"Jean\",\"adresse\":\"123 Rue de la République\",\"numeroDeTel\":\"0123456789\",\"email\":\"jean.dupont@example.com\"}";
        client client = ClientConverter.fromJson(json);
        assertNotNull(client);
        assertEquals("Dupont", client.getNom());
        assertEquals("Jean", client.getPrenom());
    }
}


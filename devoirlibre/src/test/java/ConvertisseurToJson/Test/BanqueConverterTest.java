package ConvertisseurToJson.Test;



import com.exemple.devoirlibre.banque;
import ConvertisseurToJson.BanqueConverter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BanqueConverterTest {

    @Test
    public void testToJson() {
        banque banque = new banque(1, "France");
        String json = BanqueConverter.toJson(banque);
        assertNotNull(json);
        assertTrue(json.contains("France"));
    }

    @Test
    public void testFromJson() {
        String json = "{\"id\":1,\"pays\":\"France\"}";
        banque banque = BanqueConverter.fromJson(json);
        assertNotNull(banque);
        assertEquals(1, banque.getId());
        assertEquals("France", banque.getPays());
    }
}

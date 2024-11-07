package ConvertisseurToJson.Test;



import com.exemple.devoirlibre.compte;
import ConvertisseurToJson.CompteConverter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CompteConverterTest {

    @Test
    public void testToJson() {
        compte compte = new compte(12345, LocalDate.now(), LocalDate.now(), "EUR", null, null, new ArrayList<>(), 1000.0);
        String json = CompteConverter.toJson(compte);
        assertNotNull(json);
        assertTrue(json.contains("EUR"));
    }

    @Test
    public void testFromJson() {
        String json = "{\"numCompte\":12345,\"dateCreation\":\"2024-11-04\",\"dateUpdate\":\"2024-11-04\",\"devise\":\"EUR\",\"solde\":1000.0}";
        compte compte = CompteConverter.fromJson(json);
        assertNotNull(compte);
        assertEquals(12345, compte.getNumCompte());
        assertEquals("EUR", compte.getDevise());
    }
}

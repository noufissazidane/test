package ConvertisseurToJson.Test;

import com.exemple.devoirlibre.transaction;
import com.exemple.devoirlibre.TypeTrans;
import ConvertisseurToJson.TransactionConverter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TransactionConverterTest {

    @Test
    public void testToJson() {
        transaction transaction = new transaction(TypeTrans.VIRIN, LocalDateTime.now(), "REF123", 1000.0, new ArrayList<>(), null);
        String json = TransactionConverter.toJson(transaction);
        assertNotNull(json);
        assertTrue(json.contains("REF123"));
    }

    @Test
    public void testFromJson() {
        String json = "{\"transaction\":\"VIRIN\",\"time\":\"2024-11-04T12:00:00\",\"reference\":\"REF123\",\"solde\":1000.0}";
        transaction transaction = TransactionConverter.fromJson(json);
        assertNotNull(transaction);
        assertEquals("REF123", transaction.getReference());
        assertEquals(TypeTrans.VIRIN, transaction.getTransaction());
    }
}

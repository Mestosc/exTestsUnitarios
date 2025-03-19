import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    @ParameterizedTest
    @DisplayName("El dni {0} con la letra {1} es {2}")
    @CsvSource({"12345678,Z,true",      // Caso válido: DNI correcto
            "23456789,A,false",     // Caso inválido: la letra correcta para 23456789 es 'D'
            "78901234,X,true",      // Caso válido
            "34567890,G,false",     // Caso inválido: la letra correcta para 34567890 es distinta de 'G'
            "00000000,T,true",      // Caso válido: 00000000 % 23 = 0 -> 'T'
            "00000001,R,true",      // Caso válido: 00000001 % 23 = 1 -> 'R'
            "00000001,T,false",     // Caso inválido: letra incorrecta para 00000001
            "11111111,H,true",      // Caso válido: 11111111 % 23 = 18 -> 'H'
            "22222222,J,true",      // Caso válido: 22222222 % 23 = 13 -> 'J'
            "00000000,T,true",
            "99999999,R,true",
            "23000000, T, true", // 23000000 % 23 = 0  -> 'T'
            "23000001, R, true", // 23000001 % 23 = 1  -> 'R'
            "23000002, W, true", // 23000002 % 23 = 2  -> 'W'
            "23000003, A, true", // 23000003 % 23 = 3  -> 'A'
            "23000004, G, true", // 23000004 % 23 = 4  -> 'G'
            "23000005, M, true", // 23000005 % 23 = 5  -> 'M'
            "23000006, Y, true", // 23000006 % 23 = 6  -> 'Y'
            "23000007, F, true", // 23000007 % 23 = 7  -> 'F'
            "23000008, P, true", // 23000008 % 23 = 8  -> 'P'
            "23000009, D, true", // 23000009 % 23 = 9  -> 'D'
            "23000010, X, true", // 23000010 % 23 = 10 -> 'X'
            "23000011, B, true", // 23000011 % 23 = 11 -> 'B'
            "23000012, N, true", // 23000012 % 23 = 12 -> 'N'
            "23000013, J, true", // 23000013 % 23 = 13 -> 'J'
            "23000014, Z, true", // 23000014 % 23 = 14 -> 'Z'
            "23000015, S, true", // 23000015 % 23 = 15 -> 'S'
            "23000016, Q, true", // 23000016 % 23 = 16 -> 'Q'
            "23000017, V, true", // 23000017 % 23 = 17 -> 'V'
            "23000018, H, true", // 23000018 % 23 = 18 -> 'H'
            "23000019, L, true", // 23000019 % 23 = 19 -> 'L'
            "23000020, C, true", // 23000020 % 23 = 20 -> 'C'
            "23000021, K, true", // 23000021 % 23 = 21 -> 'K'
            "23000022, E, true"  // 23000022 % 23 = 22 -> 'E'
    })
    void testComprobarDNI(String dni, char letra, boolean validez) {
        assertEquals(validez, Main.comprobarDNI(dni,letra));
    }
    @ParameterizedTest
    @DisplayName("La letra para el DNI {0} es {1}")
    @CsvSource(
            {
                    "90123456,A",
                    "67890123,B",
                    "45678901,G",
                    "34567890,V",
                    "89012345,E",
                    "10212,T",       // Caso de menos de 8 dígitos (comprobación de manejo de padding o error)
                    "12345678,Z",    // 12345678 % 23 = 14  → 'Z'
                    "98765432,M",    // 98765432 % 23 = 5   → 'M'
                    "00000000,T",    // 00000000 % 23 = 0   → 'T'
                    "00000001,R",    // 00000001 % 23 = 1   → 'R'
                    "11111111,H",    // 11111111 % 23 = 18  → 'H'
                    "22222222,J",    // 22222222 % 23 = 13  → 'J'
                    "99999999,R",     // 99999999 % 23 = 1   → 'R'
                    "23000000, T",  // 23000000 % 23 = 0  → 'T'
                    "23000001, R",  // 23000001 % 23 = 1  → 'R'
                    "23000002, W",  // 23000002 % 23 = 2  → 'W'
                    "23000003, A",  // 23000003 % 23 = 3  → 'A'
                    "23000004, G",  // 23000004 % 23 = 4  → 'G'
                    "23000005, M",  // 23000005 % 23 = 5  → 'M'
                    "23000006, Y",  // 23000006 % 23 = 6  → 'Y'
                    "23000007, F",  // 23000007 % 23 = 7  → 'F'
                    "23000008, P",  // 23000008 % 23 = 8  → 'P'
                    "23000009, D",  // 23000009 % 23 = 9  → 'D'
                    "23000010, X",  // 23000010 % 23 = 10 → 'X'
                    "23000011, B",  // 23000011 % 23 = 11 → 'B'
                    "23000012, N",  // 23000012 % 23 = 12 → 'N'
                    "23000013, J",  // 23000013 % 23 = 13 → 'J'
                    "23000014, Z",  // 23000014 % 23 = 14 → 'Z'
                    "23000015, S",  // 23000015 % 23 = 15 → 'S'
                    "23000016, Q",  // 23000016 % 23 = 16 → 'Q'
                    "23000017, V",  // 23000017 % 23 = 17 → 'V'
                    "23000018, H",  // 23000018 % 23 = 18 → 'H'
                    "23000019, L",  // 23000019 % 23 = 19 → 'L'
                    "23000020, C",  // 23000020 % 23 = 20 → 'C'
                    "23000021, K",  // 23000021 % 23 = 21 → 'K'
                    "23000022, E"   // 23000022 % 23 = 22 → 'E'
            }
    )
    void testCalcularLetra(String dni,char letra) {
        assertEquals(letra,Main.calcularLetraDNI(dni));
    }
}
